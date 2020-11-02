package it.corsobackendtree.esercizi9.ferrovia.classi;

import java.util.ArrayList;

public class VagoneRistorante extends Vagone {
    private ArrayList<Tavolo> tavoli;

    public enum CapienzaTavolo{
        DUE(2),QUATTRO(4);
        private int cap;
        private CapienzaTavolo(int cap){
            this.cap = cap;
        }
        public int getIntCap() {
            return cap;
        }
    }

    public class Tavolo {
        int capienza;
        int nPersone;

        public Tavolo(int capienza, int nPersone) {
            this.capienza = capienza;
            this.nPersone = nPersone;
        }
    }

    public VagoneRistorante(int numeroTavoli, VagoneRistorante.CapienzaTavolo capienzaTavoli, ArrayList<Porta> porte) {
        super(numeroTavoli*capienzaTavoli.getIntCap(), porte);
    }

    @Override
    public boolean entraPasseggero(Passeggero p) {
        if (p instanceof PasseggeroAffamato) {
            return super.entraPasseggero(p);
        } else return false;
    }
}
