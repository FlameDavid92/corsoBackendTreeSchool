package it.corsobackendtree.esercizi15.justdelivery.classi;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Ordine {
    private UUID id;
    private String emailUtente;
    private Ristorante ristorante;
    private HashMap<Vivanda, Integer> vivandeOrdinate;
    private boolean completato;

    Ordine(String emailUtente, Ristorante ristorante) {
        id = UUID.randomUUID();
        this.emailUtente = emailUtente;
        this.ristorante = ristorante;
        vivandeOrdinate = new HashMap<>();
        completato = false;
    }

    public Ristorante getRistorante() {
        return ristorante;
    }

    public boolean aggiungi(Vivanda vivanda, int quantita){
        if(!completato){
            if(ristorante.getMenu().contains(vivanda)){
                if(quantita > 0){
                    vivandeOrdinate.put(vivanda,quantita);
                    return true;
                }else{
                    System.out.println("Quantità non valida!");
                    return false;
                }
            }else{
                System.out.println("Il ristorante non ha la vivanda selezionata nel menù!");
                return false;
            }
        }else{
            System.out.println("Non puoi aggiungere vivande ad un ordine completato!");
            return false;
        }
    }

    public boolean rimuovi(Vivanda vivanda){
        if(completato){
            System.out.println("Non puoi rimuovere vivande ad un ordine completato!");
            return false;
        }
        return vivandeOrdinate.remove(vivanda) != null;
    }

    public double calcolaPrezzo() {
        BigDecimal ret = new BigDecimal(0);
        /*con stream???*/
        /*vivandeOrdinate.entrySet().stream().forEach(es ->
                ret = ret.add(es.getKey().getPrezzo().multiply(new BigDecimal(es.getValue()))));*/
        for(Map.Entry<Vivanda,Integer> entry : vivandeOrdinate.entrySet()){
            ret = ret.add( entry.getKey().getPrezzo().multiply(new BigDecimal(entry.getValue())) );
        }
        return ret.setScale(2, RoundingMode.UP).doubleValue();
    }

    public void printDettaglio() {
        vivandeOrdinate.entrySet().stream().forEach(es -> System.out.println(es.getKey() + " quantità:" + es.getValue()));
        System.out.println("TOTALE: " + calcolaPrezzo());
    }

    public void completaOrdine(){
        completato = true;
    }
}
