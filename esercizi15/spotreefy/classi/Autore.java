package it.corsobackendtree.esercizi15.spotreefy.classi;
import java.util.Objects;
import java.util.UUID;

public class Autore {
    private UUID id;
    private String nomeDArte;
    private String nome;
    private String cognome;

    public Autore(String nomeDArte, String nome, String cognome){
        id = UUID.randomUUID();
        this.nomeDArte = nomeDArte;
        this.nome = nome;
        this.cognome = cognome;
    }

    public Autore(String nome, String cognome){
        this("-",nome,cognome);
    }

    public UUID getId() {
        return id;
    }

    public String getNomeDArte() {
        return nomeDArte;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Autore autore = (Autore) o;
        return Objects.equals(id, autore.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
