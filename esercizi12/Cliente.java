package it.corsobackendtree.esercizi12;

import java.util.Objects;
import java.util.UUID;

public class Cliente implements Comparable<Cliente> {
    private UUID id;
    private String nome;
    private String cognome;
    private int eta;

    public Cliente(String nome, String cognome, int eta) {
        id = UUID.randomUUID();
        this.nome = nome;
        this.cognome = cognome;
        this.eta = eta;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(id, cliente.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public int compareTo(Cliente o) {
        if (this.eta > o.eta) {
            return -1;
        } else if (this.eta < o.eta) {
            return 1;
        } else{
            return this.id.compareTo(o.id);
        }
    }

    @Override
    public String toString() {
        return nome+" "+cognome+" "+eta;
    }
}
