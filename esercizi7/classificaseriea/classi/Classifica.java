package it.corsobackendtree.esercizi7.classificaseriea.classi;

public class Classifica {
    Squadra[] serieA;
    boolean ordinata;

    public Classifica(Squadra[] serieA) {
        this.serieA = serieA;
        this.ordinata = false;
    }

    public void esitoPartita(Squadra squadraCasa, int golCasa,
                             Squadra squadraOspite, int golOspite) {
        if (this.ordinata) this.ordinata = false;

        if (golCasa > golOspite) {
            squadraCasa.vittoria();
        } else if (golCasa == golOspite) {
            squadraCasa.pareggio();
            squadraOspite.pareggio();
        } else {
            squadraOspite.vittoria();
        }

        squadraCasa.setGolFatti(golCasa);
        squadraOspite.setGolSubiti(golCasa);
        squadraOspite.setGolFatti(golOspite);
        squadraCasa.setGolSubiti(golOspite);
    }

    public Squadra[] getClassifica() {
        if (this.ordinata) return this.serieA;
        else {
            ordinaClassifica();
            return this.serieA;
        }
    }

    public void ordinaClassifica() {
        /* ordina in base al punteggio della squadra */
        MergeSortSquadre.sort(this.serieA, 0, this.serieA.length - 1);
        this.ordinata = true;
    }

    public Squadra[] getMiglioreAttacco() {
        Squadra sq = null;
        int dim = 0;
        for (int i = 0; i < serieA.length; i++) {
            if (sq == null) sq = this.serieA[i];
            if (sq.getGolFatti() < this.serieA[i].getGolFatti()) {
                dim = 1;
                sq = this.serieA[i];
            } else if (sq.getGolFatti() == this.serieA[i].getGolFatti()) {
                dim++;
            }
        }
        Squadra[] ret = new Squadra[dim];
        int j = 0;
        for (int i = 0; i < serieA.length; i++) {
            if (sq.getGolFatti() == this.serieA[i].getGolFatti()) {
                ret[j] = this.serieA[i];
                j++;
            }
        }
        return ret;
    }

    public Squadra[] getPeggiorDifesa() {
        Squadra sq = null;
        int dim = 0;
        for (int i = 0; i < serieA.length; i++) {
            if (sq == null) sq = this.serieA[i];
            if (sq.getGolSubiti() < this.serieA[i].getGolSubiti()) {
                dim = 1;
                sq = this.serieA[i];
            } else if (sq.getGolSubiti() == this.serieA[i].getGolSubiti()) {
                dim++;
            }
        }
        Squadra[] ret = new Squadra[dim];
        int j = 0;
        for (int i = 0; i < serieA.length; i++) {
            if (sq.getGolFatti() == this.serieA[i].getGolFatti()) {
                ret[j] = this.serieA[i];
                j++;
            }
        }
        return ret;
    }
}
