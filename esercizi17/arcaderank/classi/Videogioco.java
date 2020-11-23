package it.corsobackendtree.esercizi17.arcaderank.classi;

import java.util.*;
import java.util.stream.Collectors;

public class Videogioco {
    private final UUID id;
    private final String nome;
    private final Difficolta difficolta;
    private final Map<UUID,Integer> punteggi;

    Videogioco(String nome, Difficolta difficolta){
        id = UUID.randomUUID();
        this.nome = nome;
        this.difficolta = difficolta;
        punteggi = new HashMap<>();
    }

    public UUID getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Difficolta getDifficolta() {
        return difficolta;
    }

    List<ClassificaItem> getClassifica(){
        return punteggi.entrySet().stream().sorted((a,b) -> b.getValue().compareTo(a.getValue()))
                .limit(3).map(e -> new ClassificaItem(e.getKey(),e.getValue())).collect(Collectors.toList());
    }

    /* Ritorna un array di interi di dimensione 2 dove in prima posizione c'è il precedente punteggio ed in seconda posizione quello aggiornato.
    (i punteggi vengono già moltiplicati alla difficoltà per agevolare il calcolo della classifica generale) */
    Integer[] inserisciPunteggio(UUID idUtente, Integer nuovoPunteggio){
        Integer punteggio = punteggi.getOrDefault(idUtente,null);
        if(punteggio == null || punteggio < nuovoPunteggio){
            punteggi.put(idUtente,nuovoPunteggio);
            if(punteggio == null) return new Integer[] {0, nuovoPunteggio*difficolta.getInt()};
            else return new Integer[] {punteggio*difficolta.getInt(), nuovoPunteggio*difficolta.getInt()};
        }
        return null;
    }

    @Override
    public String toString() {
        return nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Videogioco that = (Videogioco) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
