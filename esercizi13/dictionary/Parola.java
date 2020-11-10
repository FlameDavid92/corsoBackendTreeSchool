package it.corsobackendtree.esercizi13.dictionary;

import it.corsobackendtree.esercizi13.dictionary.eccezioni.MalformedSignificatoException;
import it.corsobackendtree.esercizi13.dictionary.eccezioni.MalformedWordException;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Parola implements Comparable<Parola>{
    private String parola;
    private Set<String> significati;

    public Parola(String parola, String significato) throws MalformedSignificatoException, MalformedWordException {
        if(parola.length() == 0) throw new MalformedWordException("Una parola deve avere almeno una lettera.");
        if(significato.length() > 0 && Character.isLetter(significato.charAt(0))){
            this.parola = parola;
            significati = new HashSet<>();
            significati.add(significato);
        }else{
            throw new MalformedSignificatoException("Il significato di una parola deve iniziare con una lettera.");
        }
    }
    public boolean addSignificato(String significato) throws MalformedSignificatoException {
        if(Character.isLetter(significato.charAt(0)) && significato.length() > 0){
            return significati.add(significato);
        }else{
            throw new MalformedSignificatoException("Il significato di una parola deve iniziare con una lettera.");
        }
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
