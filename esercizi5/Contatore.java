package it.corsobackendtree.esercizi5;

public class Contatore {
    private int contatore;

    public Contatore(){
        this.contatore = 0;
    }
    public Contatore(int valoreIniziale){
        this.contatore = valoreIniziale;
    }

    public int getContatore(){
        return this.contatore;
    }
    public void setContatore(int value){
        this.contatore = value;
    }
    public int increment(){
        setContatore(this.contatore + 1);
        return getContatore();
    }
    public int reset(){
        setContatore(0);
        return getContatore();
    }
    public int resetContatore(int value){
        setContatore(value);
        return getContatore();
    }
}
