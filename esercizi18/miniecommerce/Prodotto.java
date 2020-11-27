package it.corsobackendtree.esercizi18.miniecommerce;

import java.util.Objects;
import java.util.UUID;

public class Prodotto {
    private final UUID id;
    private String nome;
    private int quantitaDisponibile;
    private double prezzo;

    public Prodotto(){
        id = UUID.randomUUID();
    }

    public Prodotto(String nome, int quantita, double prezzo) {
        id = UUID.randomUUID();
        this.nome = nome;
        this.quantitaDisponibile = quantita;
        this.prezzo = prezzo;
    }

    public UUID getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getQuantitaDisponibile() {
        return quantitaDisponibile;
    }

    public double getPrezzo() {
        return prezzo;
    }

    boolean acquisto(int quantita) {
        if (quantitaDisponibile >= quantita) {
            quantitaDisponibile -= quantita;
            return true;
        }
        System.out.println("Prodotto "+nome+" terminato!");
        return false;
    }

    @Override
    public String toString() {
        return nome+" q:"+quantitaDisponibile+" "+prezzo+"€";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prodotto prodotto = (Prodotto) o;
        return Objects.equals(id, prodotto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
