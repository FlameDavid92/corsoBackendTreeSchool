package it.corsobackendtree.esercizi8.distributorebevande.classi;

public interface DistributoreDiBevande {
    public void caricaProdotto(Prodotto p);
    public void inserisciImporto(double importo);
    public Prodotto scegliProdotto(String codice);
    public double saldoAttuale();
    public double getResto();
}
