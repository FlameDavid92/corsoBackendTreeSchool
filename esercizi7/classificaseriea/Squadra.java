package it.corsobackendtree.esercizi7.classificaseriea;

public class Squadra {
    private static int idCounter = 0;

    private int id;
    private String nome;
    private Giocatore[] rosaGiocatori;
    private int punteggio;
    private int golFatti;
    private int golSubiti;

    Squadra(String nome, Giocatore[] rosaGiocatori){
        this.id = idCounter++;
        this.nome = nome;

    }
}
