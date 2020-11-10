package it.corsobackendtree.esercizi13;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Parola implements Comparable<Parola>{
    private String parola;
    private Set<String> significati;

    public Parola(String parola, String significato){
        this.parola = parola;
        significati = new HashSet<>();
        significati.add(significato);
    }
    public void addSignificato(String significato){
        significati.add(significato);
    }

    public String getParola() {
        return parola;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Parola parola1 = (Parola) o;
        return Objects.equals(parola, parola1.parola);
    }

    @Override
    public int hashCode() {
        return Objects.hash(parola);
    }

    @Override
    public String toString() {
        String ret = parola+": (";
        for(String significato : significati){
            ret+= significato+";";
        }
        ret += ")";
        return ret;
    }

    @Override
    public int compareTo(Parola o) {
        return this.parola.compareTo(o.parola);
    }
}
