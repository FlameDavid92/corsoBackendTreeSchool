package it.corsobackendtree.esercizi5.lampadinav2;

public class Interruttore {
    private Lampadina lampadina;
    Interruttore(Lampadina lampadina){
        this.lampadina = lampadina;
    }
    public void clickInterruttore(){
        lampadina.click();
    }
    public Lampadina getLampadina() { return this.lampadina; }
}
