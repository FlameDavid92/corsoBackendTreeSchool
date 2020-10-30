package it.corsobackendtree.esercizi8.distributorebevande.classi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DistributoreDiBevande {
    private int maxNDiffProdotti;
    private int maxSizeBox;
    private Map<String, List<Prodotto>> prodotti;
    private double saldo;

    public DistributoreDiBevande(int maxNDiffProdotti, int maxSizeBox) {
        this.maxNDiffProdotti = maxNDiffProdotti;
        this.maxSizeBox = maxSizeBox;
        this.prodotti = new HashMap<String, List<Prodotto>>();
        this.saldo = 0;
    }
    public DistributoreDiBevande(int maxNDiffProdotti) {
        this(maxNDiffProdotti, 10);
    }

    public void caricaProdotto(Prodotto p) {
        if (prodotti.get(p.getCodice()) == null) {
            if (prodotti.size() <= maxNDiffProdotti) {
                ArrayList<Prodotto> box = new ArrayList<Prodotto>();
                box.add(p);
                prodotti.put(p.getCodice(), box);
            } else {
                System.out.println("Non c'è spazio per altri box prodotto!");
            }
        } else {
            if (prodotti.get(p.getCodice()).size() <= maxSizeBox) {
                prodotti.get(p.getCodice()).add(p);
            } else{
                System.out.println("Box prodotto pieno!");
            }
        }

    }

    public void inserisciImporto(double importo) {
        saldo += importo;
    }

    public Prodotto scegliProdotto(String codice) {
        if (prodotti.get(codice) != null && prodotti.get(codice).size() != 0) {
            Prodotto ret = prodotti.get(codice).remove(prodotti.get(codice).size() - 1);
            if (saldo < ret.getPrezzo()) {
                return null;
            } else {
                saldo -= ret.getPrezzo();
                return ret;
            }
        } else return null;
    }

    public double saldoAttuale() {
        return saldo;
    }

    public double getResto() {
        if (saldo != 0) {
            double resto = saldo;
            saldo = 0;
            return resto;
        }
        return saldo;
    }
}
