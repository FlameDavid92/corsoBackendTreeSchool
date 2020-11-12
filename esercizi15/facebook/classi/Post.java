package it.corsobackendtree.esercizi15.facebook.classi;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

public class Post {
    UUID id;
    String testo;
    Set<Commento> commenti;
    Set<Like> likes;

    Post(String testo){
        id = UUID.randomUUID();
        this.testo = testo;
        commenti = new HashSet<>();
        likes = new HashSet<>();
    }

    public String getTesto() {
        return testo;
    }

    public Set<Commento> getCommenti(){
        return commenti;
    }

    boolean aggiungiCommento(Commento commento){
        return commenti.add(commento);
    }

    boolean rimuoviCommento(Commento commento){
        return commenti.remove(commento);
    }

    boolean aggiungiLike(Like like){
        return likes.add(like);
    }

    boolean rimuoviLike(Like like){
        return likes.remove(like);
    }

    public int getNumeroLike(){
        return likes.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return Objects.equals(id, post.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
