package it.corsobackendtree.esercizi9.ferrovia.classi.treni;

public class FrecciaRossa extends Treno{
    public static final int maxVagoni = 20;
    public FrecciaRossa() {
        super(maxVagoni);
    }
    @Override
    public void entraInStazione(){
        super.entraInStazione();
        this.apriTutteLePorte();
    }
}