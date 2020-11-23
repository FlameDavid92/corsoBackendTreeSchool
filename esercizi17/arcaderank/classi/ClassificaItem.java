package it.corsobackendtree.esercizi17.arcaderank.classi;

import java.util.UUID;

public class ClassificaItem {
    private final UUID idUtente;
    private final Integer punteggio;

    public ClassificaItem(UUID idUtente, Integer punteggio){
        this.idUtente = idUtente;
        this.punteggio = punteggio;
    }

    public UUID getIdUtente() {
        return idUtente;
    }

    public Integer getPunteggio() {
        return punteggio;
    }
}
