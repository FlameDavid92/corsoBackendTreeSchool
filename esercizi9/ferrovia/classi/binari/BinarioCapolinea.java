package it.corsobackendtree.esercizi9.ferrovia.classi.binari;

public class BinarioCapolinea extends BinarioStazione{
    public BinarioCapolinea(int idStazione) {
        super(idStazione, null);
    }
    @Override
    public Binario getSuccessivo(){
        System.out.println("Il treno è arrivato al capolinea!");
        return null;
    }
}
