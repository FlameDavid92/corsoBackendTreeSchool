package it.corsobackendtree.esercizi15.facebook;

import it.corsobackendtree.esercizi15.facebook.classi.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Facebook facebook = new Facebook();
        Utente davide1 = facebook.iscriviUtente("Davide","Figuccia");
        Utente davide2 = facebook.iscriviUtente("Davide","Figuccia");
        Utente davide3 = facebook.iscriviUtente("Davide","Figuccia");
        System.out.print("TEST INSERIMENTO UTENTI: ");
        System.out.println(facebook.getNUtentiIscritti() == 3);

        System.out.print("TEST RICERCA UTENTE PER ID: ");
        System.out.println(facebook.getUtenteById(davide1.getId()).equals(davide1));

        System.out.print("TEST RICERCA UTENTI PER NOME E COGNOME (davide,figuccia): ");
        List<Utente> davidi = facebook.getUtenti("davide","figuccia");
        System.out.println(davidi.size() == 3);

        System.out.print("TEST CREA AMICIZIA: ");
        facebook.creaAmicizia(davide1,davide2);
        System.out.print((davide1.getAmici().size() == 1)+" ");
        System.out.println(davide2.getAmici().size() == 1);

        System.out.print("TEST RIMUOVI AMICIZIA: ");
        facebook.rimuoviAmicizia(davide2,davide1);
        System.out.print((davide1.getAmici().size() == 0)+" ");
        System.out.println(davide2.getAmici().size() == 0);

        System.out.print("TEST CAMBIA NOME UTENTE: ");
        facebook.cambiaNomeUtente(davide3,"NonDavide");
        System.out.println(davide3.getNome().equals("NonDavide"));

        System.out.print("TEST RICERCA UTENTI PER NOME E COGNOME (davide,figuccia): ");
        davidi = facebook.getUtenti("davide","figuccia");
        System.out.println(davidi.size() == 2);

        System.out.print("TEST CAMBIA COGNOME UTENTE: ");
        facebook.cambiaCognomeUtente(davide2,"Figuccio");
        System.out.println(davide2.getCognome().equals("Figuccio"));

        System.out.print("TEST RICERCA UTENTI PER NOME E COGNOME (davide,figuccia): ");
        davidi = facebook.getUtenti("davide","figuccia");
        System.out.println(davidi.size() == 1);

        System.out.print("TEST PUBBLICAZIONE POST UTENTE: ");
        Post postDavide1 = facebook.pubblicaPostUtente(davide1,"Un bellissimo post!!!");
        System.out.println(facebook.getPostsUtente(davide1).size() == 1);

        System.out.print("TEST COMMENTO: ");
        Commento commentoDiDavide2 = facebook.utenteCommentaPost(davide2,postDavide1,"Che post inutile :P");
        System.out.print((facebook.getPostCommentati(davide2).size() == 1)+" ");
        System.out.println(postDavide1.getCommenti().size() == 1);

        System.out.print("TEST LIKE POST: ");
        System.out.print((postDavide1.getNumeroLike()==0)+" ");
        facebook.utenteInserisceLikeAPost(davide3,postDavide1);
        System.out.print((postDavide1.getNumeroLike()==1)+" ");
        System.out.print((facebook.getPostPiaciuti(davide2).size() == 0)+" ");
        System.out.println(facebook.getPostPiaciuti(davide3).size() == 1);

        System.out.print("TEST ULTIMI 3 UTENTI ISCRITTI: ");
        facebook.iscriviUtente("Mario","Rossi");
        facebook.iscriviUtente("Paolo","Verdi");
        facebook.iscriviUtente("Aldo","Bianchi");

        System.out.print((facebook.getNUtentiIscritti() == 6)+" ");
        Utente[] ultimi3 = facebook.getUltimi3NuoviUtenti();
        System.out.print((ultimi3[0].getNome().equals("Mario"))+" ");
        System.out.print((ultimi3[1].getNome().equals("Paolo"))+" ");
        System.out.print(ultimi3[2].getNome().equals("Aldo"));
    }
}
