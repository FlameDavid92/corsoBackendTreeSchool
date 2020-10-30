package it.corsobackendtree.esercizi8.distributorebevande.classi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DistributoreDiBevandeMapList implements DistributoreDiBevande{
    private Prodotto[] prodotti;
    private int lastFreeIndex;
    private double saldo;

    public DistributoreDiBevandeMapList(int maxNProdotti) {
        this.prodotti = new Prodotto[maxNProdotti];
        this.lastFreeIndex = 0;
        this.saldo = 0;
    }

    @Override
    public void caricaProdotto(Prodotto p) {
        if (lastFreeIndex != prodotti.length) {
            prodotti[lastFreeIndex] = p;
            lastFreeIndex++;
        } else {
            System.out.println("Distributore pieno!");
        }
    }

    @Override
    public void inserisciImporto(double importo) {
        saldo += importo;
    }

    @Override
    public Prodotto scegliProdotto(String codice) {
        if(codice == null) return null;
        for(int i=0; i<lastFreeIndex; i++){
            if(codice.equals(prodotti[i].getCodice())){
                Prodotto ret = prodotti[i];
                if(ret.getPrezzo() <= saldo){
                    saldo -= ret.getPrezzo();
                    removeProduct(i);
                    return ret;
                }
            }
        }
        return null;
    }

    private void removeProduct(int index){
        for(int i=index; i<lastFreeIndex; i++){
            if(i == lastFreeIndex -1 ) prodotti[i] = null;
            else prodotti[i] = prodotti[i+1];
        }
        lastFreeIndex--;
    }

    @Override
    public double saldoAttuale() {
        return saldo;
    }

    @Override
    public double getResto() {
        if (saldo != 0) {
            double resto = saldo;
            saldo = 0;
            return resto;
        }
        return saldo;
    }
}
