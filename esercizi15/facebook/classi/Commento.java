package it.corsobackendtree.esercizi15.facebook.classi;

import java.util.Objects;
import java.util.UUID;

public class Commento {
    private UUID id;
    private Utente utente;
    private Post post;
    private String testo;

    protected Commento(Utente utente, Post post, String testo){
        id = UUID.randomUUID();
        this.utente = utente;
        this.post = post;
        this.testo = testo;
    }

    public String getTesto() {
        return testo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Commento commento = (Commento) o;
        return Objects.equals(id, commento.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
