package it.corsobackendtree.esercizi8.gestoreveicoli.classi;

public class Autocarro extends Veicolo {
    private int capacitaMassimaInQuintali;

    public Autocarro(String targa, int capacitaMassimaInQuintali, int numeroPosti){
        this.targa = targa;
        this.capacitaMassimaInQuintali = capacitaMassimaInQuintali;
        this.numeroPosti = numeroPosti;
    }

    public int getCapacitaMassimaInQuintali(){
        return this.capacitaMassimaInQuintali;
    }

    @Override
    public String toString(){
        return this.targa+":"+this.capacitaMassimaInQuintali;
    }
}
