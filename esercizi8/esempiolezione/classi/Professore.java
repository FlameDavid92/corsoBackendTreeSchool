package it.corsobackendtree.esercizi8.esempiolezione.classi;

import java.util.Objects;

public class Professore extends Persona {
    private int idProf;

    public Professore(int idProf, String nome, String cognome) {
        super(nome, cognome);
        this.idProf = idProf;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Professore that = (Professore) o;
        return idProf == that.idProf;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProf);
    }
}
