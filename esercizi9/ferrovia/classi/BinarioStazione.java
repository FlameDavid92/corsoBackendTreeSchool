package it.corsobackendtree.esercizi9.ferrovia.classi;

public class BinarioStazione implements Binario{
    int idStazione;
    public BinarioStazione(int idStazione){
        this.idStazione = idStazione;
    }

    @Override
    public Binario getSuccessivo() {
        return new BinarioSemplice();
    }

    @Override
    public Binario percorri(Treno t) {
        System.out.println("Il treno è in stazione.");
        t.inStazione(this.idStazione);
        return getSuccessivo();
    }
}
