package it.corsobackendtree.esercizi15.justdelivery;

import it.corsobackendtree.esercizi15.justdelivery.classi.*;

public class Main {
    public static void main(String[] args) {
        JustDelivery jd = JustDelivery.getInstance();
        Utente davide = jd.registraUtente("davidefiguccia2020@gmail.com", "Davide", "Figuccia");
        System.out.println(davide.getEmail());
        System.out.println("-----");
        Utente wrongEmail = jd.registraUtente("davidefiguccia2020@gmail", "Davide", "Figuccia");
        System.out.println(wrongEmail == null);
        System.out.println("-----");
        Ristorante risto1 = jd.registraRistorante("Pizziamoci", Ristorante.TipoCucina.PIZZA,2.0);
        Ristorante risto2 = jd.registraRistorante("FantasyPizza", Ristorante.TipoCucina.PIZZA,1.5);
        Ristorante risto3 = jd.registraRistorante("PizzaPazza", Ristorante.TipoCucina.PIZZA,2.5);

        System.out.println(jd.getRistorantiPerCucina(Ristorante.TipoCucina.PIZZA).size() == 3);
        System.out.println("-----");

        Vivanda margherita1 = new Vivanda("Margherita",6.5);
        Vivanda diavola1 = new Vivanda("Diavola",7.0);

        risto1.aggiungiVivandaAMenu(margherita1);
        risto1.aggiungiVivandaAMenu(diavola1);

        System.out.println("MENU risto1:");
        risto1.printMenu();
        System.out.println("-----");

        Vivanda margherita2 = new Vivanda("Margherita",8);
        Vivanda diavola2 = new Vivanda("Diavola",8.5);
        Vivanda parma2 = new Vivanda("Parma",9.0);

        risto2.aggiungiVivandaAMenu(margherita2);
        risto2.aggiungiVivandaAMenu(diavola2);
        risto2.aggiungiVivandaAMenu(parma2);

        System.out.println("MENU risto2:");
        risto2.printMenu();
        System.out.println("-----");

        Ordine ordineDavide = davide.creaOrdine(risto2);
        System.out.println(ordineDavide.aggiungi(diavola2,2));
        System.out.println(!ordineDavide.aggiungi(margherita1,1));
        System.out.println("-----");
        System.out.println("ORDINE Davide:");
        ordineDavide.printDettaglio();
        System.out.println("-----");
        System.out.println(davide.getStoricoOrdini().size() == 1);
        System.out.println("-----");
        ordineDavide.completaOrdine();
        System.out.println(!ordineDavide.aggiungi(margherita1,1));
        System.out.println("-----");
        System.out.println("TEST1 Ristoranti preferiti:");
        System.out.println(davide.getMyPrefRestaurant());
        System.out.println("-----");

        System.out.println("TEST2 Ristoranti preferiti:");

        Vivanda special3 = new Vivanda("PizzaSpecial",10.2);
        risto3.aggiungiVivandaAMenu(special3);

        Ordine ordineDavide2 = davide.creaOrdine(risto3);
        ordineDavide2.aggiungi(special3,2);
        ordineDavide2.completaOrdine();

        Ordine ordineDavide3 = davide.creaOrdine(risto3);
        ordineDavide3.aggiungi(special3,1);
        ordineDavide3.completaOrdine();

        System.out.println(davide.getMyPrefRestaurant());
        System.out.println("-----");
        System.out.println(davide.getPrefTipoCucina());
        Utente chiara = jd.registraUtente("chiaragabriele@outlook.com","Chiara","Gabriele");
        System.out.println(chiara.getPrefTipoCucina() == null);

        System.out.println(jd.getNewRistoranteOfPrefType(davide).getNome().equals("Pizziamoci"));
    }
}
