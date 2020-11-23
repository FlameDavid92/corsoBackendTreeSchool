package it.corsobackendtree.esercizi17.arcaderank.classi;

import java.util.Objects;
import java.util.UUID;

public class Utente{
    private final UUID id;
    private final String username;

    Utente(String username){
        id = UUID.randomUUID();
        this.username = username;
    }

    public UUID getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public String toString() {
        return username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Utente utente = (Utente) o;
        return Objects.equals(id, utente.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
