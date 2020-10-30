package it.corsobackendtree.esercizi8.distributorebevande.classi;

public class Prodotto {
    private String codice;
    private double prezzo;

    public Prodotto(String codice, double prezzo){
        this.codice = codice;
        this.prezzo = prezzo;
    }

    public double getPrezzo() {
        return prezzo;
    }
    public String getCodice() {
        return codice;
    }
}
