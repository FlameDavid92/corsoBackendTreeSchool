package it.corsobackendtree.esercizi17.civilregistry.classi;

public class Indirizzo {
    private String via;
    private Integer civico;
    private String citta;

    public Indirizzo(String via, int civico, String citta){
        this.via = via;
        this.civico = civico;
        this.citta = citta;
    }

    @Override
    public String toString() {
        return via+" "+civico+" "+citta;
    }
}
