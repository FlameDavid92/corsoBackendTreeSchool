package it.corsobackendtree.esercizi17.civilregistry.classi;

import java.util.LinkedList;
import java.util.List;

public class Persona {
    private CodiceFiscaleItaliano codiceFiscale;
    private String nome;
    private String cognome;
    private int eta;
    private Indirizzo residenza;
    protected List<Persona> figli;

    public Persona(CodiceFiscaleItaliano codiceFiscale, String nome, String cognome, int eta, Indirizzo residenza){
        this.nome = nome;
        this.cognome = cognome;
        this.eta = eta;
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

    public int getEta() {
        return eta;
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
        return nome+" "+cognome+" ("+eta+")";
    }
}
