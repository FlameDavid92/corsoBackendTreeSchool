package it.corsobackendtree.esercizi5;

public class Colore {
    int r,g,b;
    public static final Colore NERO = new Colore(0,0,0);
    public static final Colore BIANCO = new Colore(255,255,255);
    public Colore(int r, int g, int b){
        this.r = r;
        this.g = g;
        this.b = b;
    }
    public String toString(){
        return "r:"+this.r+" g:"+this.g+" b:"+this.b;
    }
}
