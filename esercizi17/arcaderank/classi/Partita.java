package it.corsobackendtree.esercizi17.arcaderank.classi;

import java.util.UUID;

public class Partita {
    private final UUID idUtente;
    private final UUID idVideogioco;
    private final int punteggio;

    public Partita(UUID idUtente, UUID idVideogioco, int punteggio){
        this.idUtente = idUtente;
        this.idVideogioco = idVideogioco;
        this.punteggio = punteggio;
    }

    public UUID getIdUtente() {
        return idUtente;
    }

    public UUID getIdVideogioco() {
        return idVideogioco;
    }

    public int getPunteggio() {
        return punteggio;
    }

    @Override
    public String toString() {
        return "idUtente:"+idUtente+" idVideogioco:"+idVideogioco+" punteggio:"+punteggio;
    }
}
