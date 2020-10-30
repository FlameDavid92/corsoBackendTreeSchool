package it.corsobackendtree.esercizi8.gestoreprenotazioni.classi;

import java.util.Objects;

public class Prenotazione {
    private String codice;

    public Prenotazione(String codice){
        this.codice = codice;
    }

    public int getNumeroPosti(){
        return 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prenotazione that = (Prenotazione) o;
        return Objects.equals(codice, that.codice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codice);
    }

    @Override
    public String toString(){
        return codice;
    }
}
