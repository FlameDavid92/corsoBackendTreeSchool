package it.corsobackendtree.esercizi8.formageometrica.classi;

public abstract class FormaGeometrica {
    protected String tipo;

    public abstract double getPerimeter();
    public abstract double getArea();

    @Override
    public String toString(){
        return this.tipo;
    }
}
