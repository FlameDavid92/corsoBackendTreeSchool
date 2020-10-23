package it.corsobackendtree.esercizi5;

public class Quadrato {
    private int lato;
    private Colore colore;
    public Quadrato(int lato){
        this.lato = lato;
        this.colore = Colore.NERO;
    }
    public int getLato(){
        return this.lato;
    }
    public int getPerimetro(){
        return this.lato*4;
    }
    public void print(){
        for(int i=0; i<lato; i++){
            System.out.println("  *".repeat(this.lato));
        }
    }
    public Colore getColore(){
        return this.colore;
    }
    public void setColore(int r, int g, int b){
        try {
            this.colore = new Colore(r,g,b);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
