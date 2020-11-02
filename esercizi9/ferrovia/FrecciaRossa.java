package it.corsobackendtree.esercizi9.ferrovia;

public class FrecciaRossa extends Treno{
    public FrecciaRossa(int codice, double velocita) {
        super(codice, velocita, 20);
    }
    @Override
    public void entraInStazione(){
        this.fermo = true;
        this.apriPorte();
    }
}
