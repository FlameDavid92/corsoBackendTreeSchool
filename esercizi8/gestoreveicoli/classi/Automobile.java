package it.corsobackendtree.esercizi8.gestoreveicoli.classi;

public class Automobile extends Veicolo{
    private int numeroPorte;

    public Automobile(String targa, int numeroPorte, int numeroPosti){
        this.targa = targa;
        this.numeroPorte = numeroPorte;
        this.numeroPosti = numeroPosti;
    }

    public int getNumeroPorte(){
        return this.numeroPorte;
    }

    @Override
    public String toString(){
        return this.targa+":"+this.numeroPorte;
    }
}
