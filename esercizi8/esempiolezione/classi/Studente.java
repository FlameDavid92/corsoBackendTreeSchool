package it.corsobackendtree.esercizi8.esempiolezione.classi;

import java.util.Objects;

public class Studente extends Persona {
    private String matricola;

    public Studente(String matricola, String nome, String cognome) {
        super(nome, cognome);
        this.matricola = matricola;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Studente studente = (Studente) o;
        return Objects.equals(matricola, studente.matricola);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matricola);
    }
}
