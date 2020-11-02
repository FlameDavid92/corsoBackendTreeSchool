package it.corsobackendtree.esercizi9.ferrovia.classi;

public class TrenoRegionale extends Treno {
    public static final int maxVagoni = 15;
    public TrenoRegionale(int codice, double velocita) {
        super(codice, velocita, maxVagoni);
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
