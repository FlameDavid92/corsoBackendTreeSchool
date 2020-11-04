package it.corsobackendtree.esercizi9.ferrovia.classi.binari;

import it.corsobackendtree.esercizi9.ferrovia.classi.treni.Treno;

public class BinarioStazione extends Binario{
    int idStazione;
    public BinarioStazione(int idStazione, Binario successivo){
        super(successivo);
        this.idStazione = idStazione;
    }
    @Override
    public Binario percorri(Treno t) {
        System.out.println("Il treno è in stazione "+idStazione+".");
        t.inStazione(this.idStazione);
        return getSuccessivo();
    }
}
