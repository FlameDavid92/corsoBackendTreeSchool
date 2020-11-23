package it.corsobackendtree.esercizi17.civilregistry.classi;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class Persona {
    private final CodiceFiscaleItaliano codiceFiscale;
    private final String nome;
    private final String cognome;
    private final LocalDate nascita;
    private final Indirizzo residenza;
    protected List<Persona> figli;

    public Persona(CodiceFiscaleItaliano codiceFiscale, String nome, String cognome, LocalDate nascita, Indirizzo residenza){
        this.nome = nome;
        this.cognome = cognome;
        this.nascita = nascita;
        this.codiceFiscale = codiceFiscale;
        this.residenza = residenza;
        figli = new LinkedList<>();
    }

    public void aggiungiFiglio(Persona p){
        if(p.equals(this)){
            System.out.println("Una persona non può essere figlia di sé stessa.");
            return;
        }
        figli.add(p);
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public LocalDate getNascita() {
        return nascita;
    }

    public CodiceFiscaleItaliano getCodiceFiscale() {
        return codiceFiscale;
    }

    public Indirizzo getResidenza() {
        return residenza;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Persona persona = (Persona) o;
        return codiceFiscale.equals(persona.codiceFiscale);
    }

    @Override
    public int hashCode() {
        return codiceFiscale.hashCode();
    }

    @Override
    public String toString() {
        return nome+" "+cognome+" "+nascita;
    }
}
