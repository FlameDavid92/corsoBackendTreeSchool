package it.corsobackendtree.esercizi15.share2go.classi;

public class Parcheggio {
    private double latitudine;
    private double longitudine;
    public Parcheggio(double latitudine, double longitudine){
        this.latitudine = latitudine;
        this.longitudine = longitudine;
    }
    public double getLatitudine() {
        return latitudine;
    }
    public double getLongitudine() {
        return longitudine;
    }
}
