package it.corsobackendtree.esercizi10.miniAmazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class Magazzino implements Deposito {
    private UUID id;
    private ArrayList<ProdottoFisico> prodottiFisici;
    private int nProdotti;
    private int capienza;

    public Magazzino(int capienza) {
        this.id = UUID.randomUUID();
        this.capienza = capienza;
        this.prodottiFisici = new ArrayList<>();
        this.nProdotti = 0;
    }

    @Override
    public boolean addProdotto(Prodotto p) {
        if (p instanceof ProdottoFisico) {
            if (nProdotti < capienza) {
                prodottiFisici.add((ProdottoFisico) p);
                nProdotti++;
                return true;
            } else {
                System.out.println("Magazzino pieno, non puoi aggiungere prodotti.");
                return false;
            }
        } else {
            System.out.println("Prodotto non aggiunto. Puoi aggiungere solo prodotti fisici al magazzino!");
            return false;
        }
    }

    @Override
    public boolean removeProdotto(Prodotto p) {
        if (p instanceof ProdottoFisico) {
            if (nProdotti > 0) {
                return prodottiFisici.remove((ProdottoFisico) p);
            } else {
                System.out.println("Magazzino vuoto, non ci sono prodotti da rimuovere!");
                return false;
            }
        } else {
            System.out.println("Puoi rimuovere solo prodotti fisici dal magazzino!");
            return false;
        }
    }

    public ArrayList<ProdottoFisico> getProdottiFisici() {
        return prodottiFisici;
    }

    public int getSpazioDisponibile() {
        return capienza - nProdotti;
    }
}
