package it.corsobackendtree.esercizi8.formageometrica.classi;

public class Quadrato extends FormaGeometrica{
    private int lato;
    public Quadrato(int lato){
        this.tipo = "quadrato";
        this.lato = lato;
    }

    public int getLato(){
        return this.lato;
    }

    @Override
    public double getPerimeter() {
        return this.lato*4;
    }
    @Override
    public double getArea() {
        return Math.pow(this.lato,2);
    }

}
