package it.corsobackendtree.esercizi15.spotreefy.classi;

import java.util.Objects;
import java.util.UUID;

public class Brano {

    static class IdBrano{
        String id;
        public IdBrano(UUID idAutore, String titolo){
            this.id = (idAutore.toString()+titolo.toLowerCase());
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            IdBrano idBrano = (IdBrano) o;
            return Objects.equals(id, idBrano.id);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id);
        }
    }

    private IdBrano id;
    private UUID idAutore;
    private String titolo;
    private String genere;
    private long ascolti;

    Brano(UUID idAutore, String titolo, String genere) {
        id = new IdBrano(idAutore,titolo);
        this.idAutore = idAutore;
        this.titolo = titolo;
        this.genere = genere;
        ascolti = 0;
    }

    public IdBrano getIdBrano() {
        return id;
    }

    public UUID getIdAutore() {
        return idAutore;
    }

    public String getTitolo() {
        return titolo;
    }

    public String getGenere() {
        return genere;
    }

    public long getAscolti() {
        return ascolti;
    }

    void ascolta(){
        ascolti++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Brano brano = (Brano) o;
        return Objects.equals(id, brano.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Brano("+titolo+")";
    }
}
