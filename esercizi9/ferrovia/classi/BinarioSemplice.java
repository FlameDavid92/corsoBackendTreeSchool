package it.corsobackendtree.esercizi9.ferrovia.classi;

public class BinarioSemplice implements Binario{

    @Override
    public Binario getSuccessivo() {
        return new BinarioSemplice();
    }

    @Override
    public Binario percorri(Treno t) {
        System.out.println("Il treno percorre il binario...");
        return getSuccessivo();
    }
}
