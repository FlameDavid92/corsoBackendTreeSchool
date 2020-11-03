package it.corsobackendtree.esercizi10.miniAmazon;

import it.corsobackendtree.esercizi10.miniAmazon.classi.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Amazon miniAmazon = new Amazon();
        Utente davide = new Utente("Davide");
        Utente alessio = new Utente("Alessio");
        miniAmazon.registraUtente(davide);
        miniAmazon.registraUtente(alessio);

        System.out.println("TEST numero utenti:");
        System.out.println((miniAmazon.getnUtenti() == 2)+"\n");

        System.out.println("TEST aggiunta prodotto software senza aver inserito repositories in miniAmazon:");
        ProdottoSoftware prodottoSoftware1 = new ProdottoSoftware("miniAmazon",2.50,5230,"0.2");
        System.out.println(!miniAmazon.aggiungiProdotto(prodottoSoftware1)+"\n");

        SoftwareRepository sr = new SoftwareRepository();
        miniAmazon.aggiungiSoftwareRepository(sr);

        System.out.println("TEST aggiunta prodotto software dopo aver inserito una repositories in miniAmazon:");
        System.out.println(miniAmazon.aggiungiProdotto(prodottoSoftware1)+"\n");

        Magazzino magazzino1 = new Magazzino(5);
        miniAmazon.aggiungiMagazzino(magazzino1);
        ProdottoFisico prodottoFisico1 = new ProdottoFisico("GeForce RTX 3080",1000,1400,2,3);
        miniAmazon.aggiungiProdotto(prodottoFisico1);

        ArrayList<Prodotto> acquistiDavide = new ArrayList<>();
        acquistiDavide.add(prodottoSoftware1);
        acquistiDavide.add(prodottoFisico1);

        miniAmazon.creaAggiungiOrdine(davide.getId(), acquistiDavide);

        QueryOrdiniResult ordineDavide = miniAmazon.getOrdiniUtente(davide.getId());

        System.out.println("TEST numero di ordini effettuati da Davide:");
        System.out.println((ordineDavide.getnOrdini() == 1)+"\n");

        System.out.println("TEST numero prodotti ordinati nel primo ordine effettuato da Davide:");
        System.out.println((ordineDavide.getOrdini().get(0).getProdotti().size() == 2)+"\n");

        System.out.println("TEST totale spese acquistiDavide:");
        System.out.println((ordineDavide.getTotaleSpeseUtente() == 1002.50)+"\n");

        System.out.println("TEST trova magazzino dove si trova il prodottoFisico1:");
        System.out.println(miniAmazon.trovaProdotto(prodottoFisico1.getId()).getDeposito().equals(magazzino1)+"\n");

        System.out.println("TEST quantità disponibile prodottoFisico1:");
        System.out.println((prodottoFisico1.getQuantitaDisponibile() == 2) + "\n");

        System.out.println("TEST acquisti effettuati per il prodottoFisico1:");
        System.out.println(miniAmazon.getAcquisti(prodottoFisico1.getId()) == 1);
    }
}
