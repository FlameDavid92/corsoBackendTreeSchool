package it.corsobackendtree.esercizi9.ferrovia.classi;

public class FrecciaRossa extends Treno{
    public static final int maxVagoni = 20;
    public FrecciaRossa(int codice, double velocita) {
        super(velocita, maxVagoni);
    }
    @Override
    public void entraInStazione(){
        this.fermo = true;
        this.apriTutteLePorte();
    }
}