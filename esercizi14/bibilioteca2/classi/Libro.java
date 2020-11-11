package it.corsobackendtree.esercizi14.bibilioteca2.classi;

import java.util.Objects;
import java.util.UUID;

public class Libro implements Comparable<Libro>{
    private UUID codice;
    private String titolo;
    private String sinossi;
    private Autore autore;

    protected Libro(String titolo, String sinossi, Autore autore){
        codice = UUID.randomUUID();
        this.titolo = titolo;
        this.sinossi = sinossi;
        this.autore = autore;
    }

    public UUID getCodice(){ return codice; }
    public String getTitolo() {
        return titolo;
    }
    public String getSinossi() {
        return sinossi;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Libro libro = (Libro) o;
        return Objects.equals(codice, libro.codice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codice);
    }

    @Override
    public int compareTo(Libro o) {
        return this.titolo.compareTo(o.titolo);
    }

    @Override
    public String toString() {
        return titolo+": "+sinossi;
    }
}
