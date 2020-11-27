package it.corsobackendtree.esercizi18.treeexpress;

import java.util.UUID;

public class Spedizione {
    private UUID codice;
    private StatoSpedizione stato;
    private double peso;
    private Utente mittente;
    private Utente destinatario;

    public Spedizione(){

    }

    public UUID getCodice() {
        return codice;
    }

    public StatoSpedizione getStato() {
        return stato;
    }

    public double getPeso() {
        return peso;
    }

    public Utente getMittente() {
        return mittente;
    }

    public Utente getDestinatario() {
        return destinatario;
    }
}
