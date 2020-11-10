package it.corsobackendtree.esercizi13.tinderlike;

import it.corsobackendtree.esercizi13.tinderlike.classi.Interesse;
import it.corsobackendtree.esercizi13.tinderlike.classi.TinderLike;
import it.corsobackendtree.esercizi13.tinderlike.classi.UserNotRegisteredException;
import it.corsobackendtree.esercizi13.tinderlike.classi.Utente;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        TinderLike tinder = new TinderLike();
        Interesse radio = new Interesse("radio");
        Interesse cinema = new Interesse("cinema");
        Interesse serietv = new Interesse("serietv");
        Interesse calcio = new Interesse("calcio");
        Interesse tennis = new Interesse("tennis");
        Interesse polo = new Interesse("polo");

        ArrayList<Interesse> interessi1 = new ArrayList<>();
        interessi1.add(radio);
        interessi1.add(cinema);
        interessi1.add(tennis);

        Utente davide = tinder.iscriviUtente("Davide","Figuccia",polo);
        try {
            tinder.aggiungiInteresseUtente(davide,serietv);
        } catch (UserNotRegisteredException e) {
            System.out.println("Utente non registrato!");
        }
        try {
            tinder.aggiungiInteressiUtente(davide,interessi1);
        } catch (UserNotRegisteredException e) {
            System.out.println("Utente non registrato!");
        }

        try {
            System.out.println(davide + " si è iscritto a Tinder. I suoi interessi sono: "+tinder.getInteressiUtente(davide));
        } catch (UserNotRegisteredException e) {
            System.out.println("Utente non registrato!");
        }

        Utente chiara = tinder.iscriviUtente("Chiara","Gabriele", serietv);
        try {
            tinder.aggiungiInteressiUtente(chiara, interessi1);
        } catch (UserNotRegisteredException e) {
            System.out.println("Utente non registrato!");
        }

        try {
            System.out.println(chiara + " si è iscritta a Tinder. I suoi interessi sono: "+tinder.getInteressiUtente(chiara));
        } catch (UserNotRegisteredException e) {
            System.out.println("Utente non registrato!");
        }

        Utente fulvia = tinder.iscriviUtente("Fulvia","Fulvi", calcio);
        try {
            System.out.println(fulvia + " si è iscritta a Tinder. I suoi interessi sono: "+tinder.getInteressiUtente(fulvia));
        } catch (UserNotRegisteredException e) {
            System.out.println("Utente non registrato!");
        }

        Utente michela = tinder.iscriviUtente("Michela","Micheli", serietv);
        try {
            tinder.aggiungiInteressiUtente(michela, interessi1);
        } catch (UserNotRegisteredException e) {
            System.out.println("Utente non registrato!");
        }

        try {
            System.out.println(michela + " si è iscritta a Tinder. I suoi interessi sono: "+tinder.getInteressiUtente(michela));
        } catch (UserNotRegisteredException e) {
            System.out.println("Utente non registrato!");
        }

        System.out.println("-----");
        try {
            System.out.println("Best match per Davide: "+tinder.getBestMatch(davide));
        } catch (UserNotRegisteredException e) {
            System.out.println("Utente non registrato!");
        }

        try {
            System.out.print("Best matches per Davide: ");
            for(Utente utente : tinder.getBestMatches(davide)) System.out.print(utente+"; ");
            System.out.println();
        } catch (UserNotRegisteredException e) {
            System.out.println("Utente non registrato!");
        }

        tinder.rimuoviUtente(chiara);
        System.out.println("Chiara si è disiscritta da Tinder!");

        try {
            System.out.println("Best match per Davide: "+tinder.getBestMatch(davide));
        } catch (UserNotRegisteredException e) {
            System.out.println("Utente non registrato!");
        }

        tinder.rimuoviUtente(michela);
        System.out.println("Michela si è disiscritta da Tinder!");
        try {
            System.out.println("Best match per Davide: "+tinder.getBestMatch(davide));
        } catch (UserNotRegisteredException e) {
            System.out.println("Utente non registrato!");
        }

        tinder.rimuoviUtente(davide);
        System.out.println("Davide si è disiscritto da Tinder!");
        try {
            System.out.println("Best match per Davide: "+tinder.getBestMatch(davide));
        } catch (UserNotRegisteredException e) {
            System.out.println("Utente non registrato!");
        }
    }
}
