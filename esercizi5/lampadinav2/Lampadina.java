package it.corsobackendtree.esercizi5.lampadinav2;

public class Lampadina {
    private StatoLampadina stato;
    private int limiteClick;
    private boolean corrente;
    private StatoLampadina prevStato;

    public Lampadina(int limiteClick, boolean corrente){
        this.limiteClick = limiteClick;
        this.stato = StatoLampadina.SPENTA;
        this.corrente = corrente;
    }

    public StatoLampadina stato(){
        return this.stato;
    }

    public void click(){
        if(this.corrente) {
            if(this.stato == StatoLampadina.ROTTA){
                return;
            }else this.limiteClick--;

            if(limiteClick < 0){
                this.stato = StatoLampadina.ROTTA;
            }else{
                if (this.stato == StatoLampadina.ACCESA) {
                    this.stato = StatoLampadina.SPENTA;
                } else {
                    this.stato = StatoLampadina.ACCESA;
                }
            }
        }
    }

    public void switchOff(){
        this.corrente = false;
        if(this.stato != StatoLampadina.ROTTA){
            this.prevStato = this.stato;
            this.stato = StatoLampadina.SPENTA;
        }
    }

    public void switchOn(){
        this.corrente = true;
        if(this.stato != StatoLampadina.ROTTA){
            this.stato = this.prevStato;
        }
    }
}
