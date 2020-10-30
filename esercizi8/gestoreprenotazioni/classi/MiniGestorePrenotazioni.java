package it.corsobackendtree.esercizi8.gestoreprenotazioni.classi;

import java.util.Arrays;

public class MiniGestorePrenotazioni {
    private int numeroPostiInterni;
    private int numeroPostiEsterni;
    private int interniImpegnati;
    private int esterniImpegnati;
    private Prenotazione[] prenotazioniInterno;
    private int lastFreeIndexInterni;
    private Prenotazione[] prenotazioniEsterno;
    private int lastFreeIndexEsterni;

    public MiniGestorePrenotazioni(int numeroPostiInterni, int numeroPostiEsterni) {
        this.numeroPostiInterni = numeroPostiInterni;
        this.numeroPostiEsterni = numeroPostiEsterni;
        this.interniImpegnati = 0;
        this.esterniImpegnati = 0;
        this.prenotazioniInterno = new Prenotazione[numeroPostiInterni];
        this.lastFreeIndexInterni = 0;
        this.prenotazioniEsterno = new Prenotazione[numeroPostiEsterni];
        this.lastFreeIndexEsterni = 0;
    }

    public boolean prenota(Prenotazione p) {
        int esterniLiberi = numeroPostiEsterni - esterniImpegnati;
        int interniLiberi = numeroPostiInterni - interniImpegnati;

        if (esterniLiberi + interniLiberi == 0) return false;

        if (p instanceof PrenotazioneSingola) {
            if (((PrenotazioneSingola) p).getPreferenza() == Preferenza.ESTERNO && esterniLiberi > 0) {
                prenotazioniEsterno[lastFreeIndexEsterni] = p;
                lastFreeIndexEsterni++;
                esterniImpegnati++;
                return true;
            } else {
                if (interniLiberi > 0) {
                    prenotazioniInterno[lastFreeIndexInterni] = p;
                    lastFreeIndexInterni++;
                    interniImpegnati++;
                    return true;
                } else {
                    prenotazioniEsterno[lastFreeIndexEsterni] = p;
                    lastFreeIndexEsterni++;
                    esterniImpegnati++;
                    return true;
                }
            }
        } else if (p instanceof PrenotazioneGruppo) {
            if (p.getNumeroPosti() <= interniLiberi) {
                prenotazioniInterno[lastFreeIndexInterni] = p;
                lastFreeIndexInterni++;
                interniImpegnati += p.getNumeroPosti();
                return true;
            } else if (p.getNumeroPosti() <= esterniLiberi) {
                prenotazioniEsterno[lastFreeIndexEsterni] = p;
                lastFreeIndexEsterni++;
                esterniImpegnati += p.getNumeroPosti();
                return true;
            }
        }
        return false;
    }

    public Prenotazione[] prenotazioniAttualiInterno() {
        /*Prenotazione[] ret = new Prenotazione[lastFreeIndexInterni];
        for(int i=0;i<lastFreeIndexInterni; i++){
            ret[i] = prenotazioniInterno[i];
        }
        return ret;*/
        return prenotazioniInterno;
    }

    public Prenotazione[] prenotazioniAttualiEsterno() {
        /*Prenotazione[] ret = new Prenotazione[lastFreeIndexEsterni];
        for(int i=0;i<lastFreeIndexEsterni; i++){
            ret[i] = prenotazioniEsterno[i];
        }
        return ret;*/
        return prenotazioniEsterno;
    }

    public void terminaPrenotazione(Prenotazione p) {
        int index = -1;
        boolean interno = false;
        int postiLiberati = 0;

        for (int i = 0; i < lastFreeIndexInterni; i++) {
            if (p.equals(prenotazioniInterno[i])) {
                index = i;
                interno = true;
                postiLiberati = prenotazioniInterno[i].getNumeroPosti();
                break;
            }
        }
        if (index == -1) {
            for (int i = 0; i < lastFreeIndexEsterni; i++) {
                if (p.equals(prenotazioniEsterno[i])) {
                    index = i;
                    postiLiberati = prenotazioniEsterno[i].getNumeroPosti();
                    break;
                }
            }
        }

        if (index != -1 && interno) {
            interniImpegnati -= prenotazioniInterno[index].getNumeroPosti();
            for (int i = index; i < lastFreeIndexInterni; i++) {
                if (i == lastFreeIndexInterni - 1) prenotazioniInterno[i] = null;
                else prenotazioniInterno[i] = prenotazioniInterno[i + 1];
            }
            lastFreeIndexInterni--;

            /*PLUS posti interno liberi*/
            for (int j = 0; j < lastFreeIndexEsterni; j++) {
                if (postiLiberati > 0 &&
                        prenotazioniEsterno[j] instanceof PrenotazioneSingola &&
                        ((PrenotazioneSingola) prenotazioniEsterno[j]).getPreferenza() == Preferenza.INTERNO) {

                    postiLiberati--;
                    Prenotazione temp = prenotazioniEsterno[j];
                    terminaPrenotazione(prenotazioniEsterno[j]);
                    prenotazioniInterno[lastFreeIndexInterni] = temp;
                }
            }


        } else if (index != -1) {
            esterniImpegnati -= prenotazioniEsterno[index].getNumeroPosti();
            for (int i = index; i < lastFreeIndexEsterni; i++) {
                if (i == lastFreeIndexEsterni - 1) prenotazioniEsterno[i] = null;
                else prenotazioniEsterno[i] = prenotazioniEsterno[i + 1];
            }
            lastFreeIndexEsterni--;

            /*PLUS posti esterno liberi*/
            for (int j = 0; j < lastFreeIndexInterni; j++) {
                if (postiLiberati > 0 &&
                        prenotazioniInterno[j] instanceof PrenotazioneSingola &&
                        ((PrenotazioneSingola) prenotazioniInterno[j]).getPreferenza() == Preferenza.ESTERNO) {

                    postiLiberati--;
                    Prenotazione temp = prenotazioniInterno[j];
                    terminaPrenotazione(prenotazioniInterno[j]);
                    prenotazioniEsterno[lastFreeIndexEsterni] = temp;
                }
            }
        }
    }
}
