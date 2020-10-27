package it.corsobackendtree.esercizi7.classificaseriea.classi;

public class Giocatore {
    private static int idCounter = 0;
    private int id;
    private String nome;
    private String cognome;

    public Giocatore(String nome, String cognome){
        this.id = idCounter++;
        this.nome = nome;
        this.cognome = cognome;
    }
}
