package it.corsobackendtree.esercizi8.gestoreveicoli.classi;

public class Veicolo {
    protected String targa;
    protected String marca;
    protected String modello;
    protected int numeroPosti;

    public String getTarga(){
        return this.targa;
    }

    public int getNumeroPosti(){
        return this.numeroPosti;
    }
}
