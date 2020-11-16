package it.corsobackendtree.esercizi15.justdelivery.classi;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;
import java.util.UUID;

public class Vivanda {
    private UUID id;
    private String nome;
    private BigDecimal prezzo;

    public Vivanda(String nome, double prezzo){
        id = UUID.randomUUID();
        this.nome = nome;
        this.prezzo = new BigDecimal(prezzo);
    }

    public UUID getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public BigDecimal getPrezzo() {
        return prezzo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vivanda vivanda = (Vivanda) o;
        return Objects.equals(id, vivanda.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return nome +" "+ prezzo.setScale(2, RoundingMode.UP);
    }
}
