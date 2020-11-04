package it.corsobackendtree.esercizi9.ferrovia.classi.vagoni;

import it.corsobackendtree.esercizi9.ferrovia.classi.passeggeri.Passeggero;
import it.corsobackendtree.esercizi9.ferrovia.classi.passeggeri.PasseggeroAssonnato;

import java.util.ArrayList;

public class VagoneLetto extends Vagone {
    int numeroLetti;

    public VagoneLetto(int numeroLetti) {
        super(numeroLetti, new ArrayList<Porta>());
        this.numeroLetti = numeroLetti;
    }

    @Override
    public boolean entraPasseggero(Passeggero p) {
        if (p instanceof PasseggeroAssonnato) {
            return super.entraPasseggero(p);
        }else return false;
    }
}
