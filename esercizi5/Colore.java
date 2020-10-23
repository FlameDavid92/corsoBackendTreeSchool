package it.corsobackendtree.esercizi5;

public class Colore {
    int r,g,b;
    public static final Colore NERO = new Colore(true);
    public static final Colore BIANCO = new Colore(false);
    private Colore(boolean bianco){
        if(bianco){
            this.r = 255;
            this.g = 255;
            this.b = 255;
        }else{
            this.r = 0;
            this.g = 0;
            this.b = 0;
        }
    }
    public Colore(int r, int g, int b) throws Exception {
        if(r>=0 && r<=255) this.r = r;
        else{throw new Exception("r non valido!");}
        if(g>=0 && g<=255) this.r = r;
        else{throw new Exception("g non valido!");}
        if(b>=0 && b<=255) this.r = r;
        else{throw new Exception("b non valido!");}
    }
    public String toString(){
        return "r:"+this.r+" g:"+this.g+" b:"+this.b;
    }
}
