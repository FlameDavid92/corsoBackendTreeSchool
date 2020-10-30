package it.corsobackendtree.esercizi8.gestoreprenotazioni.classi;

public class PrenotazioneGruppo extends Prenotazione{
    private int numeroPosti;
    public PrenotazioneGruppo(String codice, int numeroPosti) {
        super(codice);
        this.numeroPosti = numeroPosti;
    }

    @Override
    public int getNumeroPosti(){
        return numeroPosti;
    }
}
