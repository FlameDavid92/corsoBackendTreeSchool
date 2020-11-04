package it.corsobackendtree.esercizi9.ferrovia.classi.treni;

import it.corsobackendtree.esercizi9.ferrovia.classi.vagoni.Vagone;
import it.corsobackendtree.esercizi9.ferrovia.classi.vagoni.VagonePasseggero;

public class TrenoRegionale extends Treno {
    public static final int maxVagoni = 15;
    public TrenoRegionale() {
        super(maxVagoni);
    }

    @Override
    public void aggiungiVagone(Vagone v) {
        if(v instanceof VagonePasseggero){
            super.aggiungiVagone(v);
        }else{
            System.out.println("Un treno regionale può avere solo vagoni passeggero!");
        }
    }
}
