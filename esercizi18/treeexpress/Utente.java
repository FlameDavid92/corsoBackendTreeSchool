package it.corsobackendtree.esercizi18.treeexpress;

import java.util.UUID;

public class Utente {
    private UUID id;
    private String nome;
    private String cognome;
    private String indirizzo;

    public Utente(){
        id = UUID.randomUUID();
    }

    public UUID getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getIndirizzo() {
        return indirizzo;
    }
}
