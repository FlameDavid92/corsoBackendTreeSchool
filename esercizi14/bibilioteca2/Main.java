package it.corsobackendtree.esercizi14.bibilioteca2;

import it.corsobackendtree.esercizi14.bibilioteca2.classi.Autore;
import it.corsobackendtree.esercizi14.bibilioteca2.classi.Biblioteca;
import it.corsobackendtree.esercizi14.bibilioteca2.classi.Libro;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Autore davide = biblioteca.registraAutore("Davide","Figuccia");
        Libro orbil = biblioteca.inserisciLibro("Orbil","!orbil omissilleb nU",davide);
        Libro libro = biblioteca.inserisciLibro("Libro","Un bellissimo libro!",davide);
        Libro birlo = biblioteca.inserisciLibro("Birlo","Nu lebsisliom birlo!",davide);

        System.out.println("Stampa libri dell'autore "+davide.getNome()+" "+davide.getCognome()+" (in ordine lessicografico ascendente per titolo):\n");
        biblioteca.printLibri(davide);
        System.out.println("------");
        System.out.println("Ricerca libro con codice "+libro.getCodice()+" = "+biblioteca.getLibro(libro.getCodice()));
        System.out.println("Ricerca libro con titolo "+orbil.getTitolo()+" = "+biblioteca.getLibro(orbil.getTitolo()));
        System.out.println("Rimozione libro "+orbil.getTitolo()+": "+biblioteca.rimuoviLibro(orbil.getTitolo()));
        System.out.println("Ricerca libro con titolo "+orbil.getTitolo()+" = "+biblioteca.getLibro(orbil.getTitolo()));
    }
}
