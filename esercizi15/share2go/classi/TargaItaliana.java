package it.corsobackendtree.esercizi15.share2go.classi;

import it.corsobackendtree.esercizi15.share2go.classi.eccezioni.MalformedTargaException;

import java.util.Objects;
import java.util.regex.Pattern;

public class TargaItaliana {
    String targa;
    public TargaItaliana(String targa) throws MalformedTargaException {
        if(valuta(targa.toUpperCase())){
            this.targa = targa.toUpperCase();
        }else{
            throw new MalformedTargaException();
        }
    }

    public boolean valuta(String targa){
        return Pattern.matches("^[A-Z][A-Z]\\d\\d\\d[A-Z][A-Z]$",targa.toUpperCase());
    }

    @Override
    public String toString() {
        return targa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TargaItaliana that = (TargaItaliana) o;
        return Objects.equals(targa, that.targa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(targa);
    }
}
