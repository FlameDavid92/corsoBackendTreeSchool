package it.corsobackendtree.esercizi15.facebook.classi;

import java.util.Objects;
import java.util.UUID;

public class Like {
    private UUID id;
    private Utente utente;
    private Post post;

    Like(Utente utente, Post post){
        id = UUID.randomUUID();
        this.utente = utente;
        this.post = post;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Like like = (Like) o;
        return Objects.equals(id, like.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
