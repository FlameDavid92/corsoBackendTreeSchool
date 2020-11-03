package it.corsobackendtree.esercizi10.miniAmazon.classi;

import java.util.UUID;

public class Prodotto {
    private UUID id;
    private String nome;
    private double prezzo;
    private long nAcquisti;

    public Prodotto(String nome, double prezzo){
        this.id = UUID.randomUUID();
        this.nome = nome;
        this.prezzo = prezzo;
    }

    public UUID getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void acquista(){
        nAcquisti++;
    }

    public long getnAcquisti(){
        return nAcquisti;
    }
}
