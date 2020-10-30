package it.corsobackendtree.esercizi8.distributorebevande;

import it.corsobackendtree.esercizi8.distributorebevande.classi.Caffe;
import it.corsobackendtree.esercizi8.distributorebevande.classi.Cappuccino;
import it.corsobackendtree.esercizi8.distributorebevande.classi.DistributoreDiBevande;

public class Main {
    public static void main(String[] args){
        Caffe caffe = new Caffe(0.5);
        Cappuccino cappuccino = new Cappuccino(1);
        DistributoreDiBevande distributoreDiBevande = new DistributoreDiBevande(10);
        distributoreDiBevande.caricaProdotto(caffe);
        distributoreDiBevande.caricaProdotto(caffe);
        distributoreDiBevande.caricaProdotto(cappuccino);
        distributoreDiBevande.caricaProdotto(caffe);
        distributoreDiBevande.caricaProdotto(caffe);
        distributoreDiBevande.caricaProdotto(cappuccino);
        distributoreDiBevande.caricaProdotto(caffe);
        System.out.println(distributoreDiBevande.saldoAttuale() == 0);
        System.out.println(distributoreDiBevande.getResto() == 0);
        distributoreDiBevande.inserisciImporto(0.4);
        System.out.println(distributoreDiBevande.scegliProdotto("caffe") == null);
        distributoreDiBevande.inserisciImporto(0.2);
        System.out.println(distributoreDiBevande.scegliProdotto("caffe") != null);
        System.out.println(distributoreDiBevande.getResto()-0.10 < 1E-6);
        System.out.println(distributoreDiBevande.saldoAttuale() == 0);
        System.out.println(distributoreDiBevande.scegliProdotto("caffe") == null);
        distributoreDiBevande.inserisciImporto(2.0);
        System.out.println(distributoreDiBevande.scegliProdotto("caffe") != null);
        System.out.println(distributoreDiBevande.scegliProdotto("cappuccino") != null);
        System.out.println(distributoreDiBevande.scegliProdotto("caffe") != null);
        System.out.println(distributoreDiBevande.saldoAttuale() == 0);
        System.out.println(distributoreDiBevande.getResto()-0.10 < 1E-6);
    }
}
