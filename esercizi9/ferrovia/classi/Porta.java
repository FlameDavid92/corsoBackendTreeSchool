package it.corsobackendtree.esercizi9.ferrovia.classi;

public class Porta {
    public enum StatoPorta {
        APERTA,CHIUSA,GUASTA
    }
    private StatoPorta statoPorta;

    public Porta(){
        this.statoPorta = StatoPorta.CHIUSA;
    }

    public void apriPorta() {
        if (statoPorta != StatoPorta.GUASTA) {
            statoPorta = StatoPorta.APERTA;
        }else{
            System.out.println("La porta è guasta");
        }
    }
    public void chiudiPorta() {
        if (statoPorta != StatoPorta.GUASTA) {
            statoPorta = StatoPorta.CHIUSA;
        }else{
            System.out.println("La porta è guasta");
        }
    }
    public StatoPorta getStatoPorta() {
        return statoPorta;
    }

}
