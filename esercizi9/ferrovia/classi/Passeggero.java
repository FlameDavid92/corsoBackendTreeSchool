package it.corsobackendtree.esercizi9.ferrovia.classi;

public abstract class Passeggero {
    private String nome;
    private String codiceBiglietto;
    protected int idVagone;
    protected Passeggero(String nome, String codiceBiglietto, int idVagone){
        this.nome = nome;
        this.codiceBiglietto = codiceBiglietto;
        this.idVagone = idVagone;
    }
}
