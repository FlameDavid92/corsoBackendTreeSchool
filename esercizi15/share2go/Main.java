package it.corsobackendtree.esercizi15.share2go;

import it.corsobackendtree.esercizi15.share2go.classi.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        App app = new App();
        System.out.println("---TEST REGISTRAZIONE UTENTI---");
        System.out.println(app.registraUtente("chiaragabriele@outlook.com"));
        System.out.println(app.registraUtente("alessioritondo@outlook.com"));
        System.out.println(app.registraUtente("davidefiguccia2020@outlook.it"));
        System.out.println(!app.registraUtente("davidefiguccia2020@outlook.it"));
        System.out.println(!app.registraUtente("marco.com"));

        System.out.println("---TEST INSERIMENTO VETTURE---");
        Parcheggio parcheggioInStrada = new Parcheggio(37.794690,12.441030);
        ParcheggioConvenzionato parcheggioConvenzionato = new ParcheggioConvenzionato(37.794040,12.441560,2);
        Importo prezzo1 = new Importo(Locale.ITALY,new BigDecimal("0.5"));
        Importo prezzo2 = new Importo(Locale.ITALY,new BigDecimal("0.7"));
        Importo prezzo3 = new Importo(Locale.ITALY,new BigDecimal("1"));

        System.out.println(app.inserisciVettura("KL256LP", Vettura.TipoVettura.AUTOMOBILE,2,40,parcheggioInStrada,prezzo3));
        System.out.println(app.inserisciVettura("BW374PB", Vettura.TipoVettura.AUTOMOBILE,3,80,parcheggioInStrada,prezzo1));
        System.out.println(!app.inserisciVettura("BW374PB", Vettura.TipoVettura.AUTOMOBILE,3,80,parcheggioInStrada,prezzo2));
        System.out.println(!app.inserisciVettura("AA374564BB", Vettura.TipoVettura.FURGONE,2,100,parcheggioInStrada,prezzo2));
        System.out.println(app.inserisciVettura("AB123CD", Vettura.TipoVettura.FURGONE,2,100,parcheggioInStrada,prezzo2));

        System.out.println("---TEST NOLEGGIO VETTURA---");
        System.out.println(app.noleggiaVettura(app.getUtente("alessioritondo@outlook.com"),app.getVettura("KL256LP")));
        System.out.println(!app.noleggiaVettura(app.getUtente("chiaragabriele@outlook.com"),app.getVettura("KL256LP")));
        System.out.println(app.noleggiaVettura(app.getUtente("chiaragabriele@outlook.com"),app.getVettura("AB123CD")));

        System.out.println("---TEST MAX MINUTI NOLEGGIO---");
        System.out.println(app.getMaxMinutiNoleggio(app.getUtente("davidefiguccia2020@outlook.it"),app.getVettura("BW374PB")) == 0);
        app.ricarica(app.getUtente("davidefiguccia2020@outlook.it"),new Importo(Locale.ITALY,new BigDecimal(10)));
        System.out.println(app.getMaxMinutiNoleggio(app.getUtente("davidefiguccia2020@outlook.it"),app.getVettura("BW374PB")) == 20);
        app.ricarica(app.getUtente("chiaragabriele@outlook.com"),new Importo(Locale.ITALY,new BigDecimal(2)));
        System.out.println(app.getMaxMinutiNoleggio(app.getUtente("chiaragabriele@outlook.com"),app.getVettura("AB123CD")) == 2);

        System.out.println("---TEST PRINT STATO VETTURE---");
        app.printStatoVetture();

        System.out.println("---TEST PARCHEGGIO VETTURA---");
        System.out.println(!app.parcheggiaVettura(app.getUtente("davidefiguccia2020@outlook.it"),app.getVettura("BW374PB"),parcheggioConvenzionato));
        System.out.println(!app.parcheggiaVettura(app.getUtente("alessioritondo@outlook.com"),app.getVettura("BW374PB"),parcheggioConvenzionato));
        System.out.println();
        System.out.println(app.parcheggiaVettura(app.getUtente("alessioritondo@outlook.com"),app.getVettura("KL256LP"),parcheggioConvenzionato));
        System.out.println(parcheggioConvenzionato.getPostiOccupati() == 1);

        System.out.println(!parcheggioConvenzionato.isFull());
        System.out.println("Aspetta quanto vuoi poi invia una qualunque stringa!");
        sc.nextLine();
        System.out.println(app.parcheggiaVettura(app.getUtente("chiaragabriele@outlook.com"),app.getVettura("AB123CD"),parcheggioConvenzionato));
        System.out.println(parcheggioConvenzionato.isFull());

        System.out.println("---TEST NOLEGGI EFFETTUATI---");
        for(Noleggio nol : app.getUtente("chiaragabriele@outlook.com").getNoleggiEffettuati()){
            System.out.println(nol);
            app.noleggioPagato(nol);
            System.out.println(nol);
        }

        System.out.println();
        System.out.println(app.getUtente("chiaragabriele@outlook.com").getCredito().getValue());
    }
}