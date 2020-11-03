package it.corsobackendtree.esercizi10.miniAmazon.classi;

public class ProdottoSoftware extends Prodotto{
    private long dimensioneKb;
    private String versione;

    public ProdottoSoftware(String nome, double prezzo, long dimensioneKb, String versione) {
        super(nome, prezzo);
        this.dimensioneKb = dimensioneKb;
        this.versione = versione;
    }
}
