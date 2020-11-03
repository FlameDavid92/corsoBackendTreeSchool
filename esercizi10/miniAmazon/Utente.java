package it.corsobackendtree.esercizi10.miniAmazon;

import java.util.UUID;

public class Utente {
    private UUID id;
    private String nome;

    public Utente(String nome){
        this.id = UUID.randomUUID();
        this.nome = nome;
    }

    public UUID getId() {
        return id;
    }
}
