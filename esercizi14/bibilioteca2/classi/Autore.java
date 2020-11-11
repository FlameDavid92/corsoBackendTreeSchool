package it.corsobackendtree.esercizi14.bibilioteca2.classi;

import java.util.*;

public class Autore {
    private UUID id;
    private String nome;
    private String cognome;
    private TreeSet<Libro> libriScritti;

    protected Autore(String nome, String cognome) {
        id = UUID.randomUUID();
        this.nome = nome;
        this.cognome = cognome;
        libriScritti = new TreeSet<>();
    }

    public UUID getId() { return id; }
    public String getNome() { return nome; }
    public String getCognome() { return cognome; }

    protected void inserisciLibro(Libro libro) {
        libriScritti.add(libro);
    }

    protected List<Libro> getLibriScritti() {
        return List.copyOf(libriScritti);
    }

    protected void printLibri() {
        for (Libro libro : libriScritti) System.out.println(libro);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Autore autore = (Autore) o;
        return Objects.equals(id, autore.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
