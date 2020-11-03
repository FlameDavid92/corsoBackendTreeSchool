package it.corsobackendtree.esercizi10.miniAmazon.classi;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;

public class QueryOrdiniResult {
    private UUID idUtente;
    private LocalDateTime data;
    private ArrayList<Ordine> ordini;
    private ArrayList<Double> costi;
    private double totaleSpeseUtente;

    public QueryOrdiniResult(UUID idUtente, ArrayList<Ordine> ordini){
        this.idUtente = idUtente;
        this.data = LocalDateTime.now();
        this.ordini = ordini;
        this.costi = new ArrayList<>();
        this.totaleSpeseUtente = 0;
        for(Ordine ordine : ordini){
            double costo = ordine.getCostoTotale();
            this.costi.add(costo);
            this.totaleSpeseUtente += costo;
        }
    }

    public ArrayList<Double> getCosti() {
        return costi;
    }

    public ArrayList<Ordine> getOrdini() {
        return ordini;
    }

    public long getnOrdini(){ return ordini.size(); }

    public double getCostoOrdine(int index){
        return costi.get(index);
    }

    public double getTotaleSpeseUtente(){
        return totaleSpeseUtente;
    }
}
