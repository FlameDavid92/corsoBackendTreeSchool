package it.corsobackendtree.esercizi5.lampadinav2;

public class QuadroElettrico {
    private Lampadina[] lampadine;
    private boolean corrente;

    public QuadroElettrico(Lampadina[] lampadine, boolean corrente){
        this.corrente = corrente;
        this.lampadine = lampadine;
        for(int i=0; i< lampadine.length; i++){
            lampadine[i].switchOff();
        }
    }
    public Lampadina getLampadina(int i){
        return lampadine[i];
    }
    public void switchOff(){
        if(this.corrente){
            for(int i=0; i<lampadine.length; i++){
                lampadine[i].switchOff();
            }
            this.corrente = false;
        }
    }
    public void switchOn(){
        if(!this.corrente){
            for(int i=0; i<lampadine.length; i++){
                lampadine[i].switchOn();
            }
            this.corrente = true;
        }
    }
}
