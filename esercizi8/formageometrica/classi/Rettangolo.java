package it.corsobackendtree.esercizi8.formageometrica.classi;

public class Rettangolo extends FormaGeometrica{
    private int base;
    private int altezza;

    public Rettangolo(int base, int altezza){
        super("rettangolo");
        this.base = base;
        this.altezza = altezza;
    }

    public int getBase(){
        return this.base;
    }

    public int getAltezza(){
        return this.altezza;
    }

    @Override
    public double getPerimeter() {
        return (this.base*2)+(this.altezza*2);
    }
    @Override
    public double getArea() {
        return this.base*this.altezza;
    }
}
