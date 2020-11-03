package it.corsobackendtree.esercizi10.miniAmazon.classi;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;

public class Ordine {
    private UUID id;
    private UUID idUtente;
    private ArrayList<Prodotto> prodotti;
    private LocalDateTime dataOrdine;

    public Ordine(UUID idUtente, ArrayList<Prodotto> prodotti, LocalDateTime dataOrdine){
        this.id = UUID.randomUUID();
        this.idUtente = idUtente;
        this.prodotti = prodotti;
        this.dataOrdine = dataOrdine;
    }

    public double getCostoTotale(){
        double ret = 0;
        for(Prodotto prodotto : prodotti){
            ret += prodotto.getPrezzo();
        }
        return ret;
    }

    public ArrayList<Prodotto> getProdotti() {
        return prodotti;
    }
}
