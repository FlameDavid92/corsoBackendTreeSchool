package it.corsobackendtree.esercizi13.tinderlike.classi;

import java.util.Objects;
import java.util.UUID;

public class Interesse implements Comparable<Interesse>{
    private UUID id;
    private String interesse;

    public Interesse(String interesse){
        id = UUID.randomUUID();
        this.interesse = interesse;
    }

    public String getInteresse() {
        return interesse;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Interesse interesse = (Interesse) o;
        return Objects.equals(id, interesse.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public int compareTo(Interesse o) {
        int ret = this.interesse.compareTo(o.interesse);
        if(ret == 0) ret = this.id.compareTo(o.id);
        return ret;
    }

    @Override
    public String toString() {
        return interesse;
    }
}
