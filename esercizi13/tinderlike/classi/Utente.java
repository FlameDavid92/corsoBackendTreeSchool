package it.corsobackendtree.esercizi13.tinderlike.classi;

import java.util.Set;
import java.util.TreeSet;
import java.util.UUID;

public class Utente {
    private UUID id;
    private String nome;
    private String cognome;
    private TreeSet<Interesse> interessi;

    public Utente(String nome, String cognome){
        id = UUID.randomUUID();
        this.nome = nome;
        this.cognome = cognome;
        interessi = new TreeSet<>();
    }
    protected boolean aggiungiInteresse(Interesse i){
        return interessi.add(i);
    }
    protected UUID getId() {
        return id;
    }
    protected String getNome() {
        return nome;
    }
    protected String getCognome() {
        return cognome;
    }
    protected TreeSet<Interesse> getInteressi() {
        return interessi;
    }
    protected boolean isInterestedIn(Interesse i){
        return interessi.contains(i);
    }

    @Override
    public String toString() {
        return nome + " " + cognome;
    }
}
