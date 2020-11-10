package it.corsobackendtree.esercizi13.dictionary;

import it.corsobackendtree.esercizi13.dictionary.eccezioni.MalformedSignificatoException;
import it.corsobackendtree.esercizi13.dictionary.eccezioni.MalformedWordException;
import it.corsobackendtree.esercizi13.dictionary.eccezioni.VoidDictionaryException;

public class Main {
    public static void main(String[] args) {
        Dictionary nuovoDizioanrio = new Dictionary();
        try {
            nuovoDizioanrio.printDictionary();
        } catch (VoidDictionaryException e) {
            System.out.println("ECCEZIONE: "+e.getMessage());
        }

        Parola calcio = null;
        Parola carota = null;
        Parola caffeina = null;
        Parola badword = null;
        Parola badwordmeaning = null;
        Parola badDictionaryWord = null;
        try {
            calcio = new Parola("calcio", "sport");
        } catch (MalformedSignificatoException e) {
            System.out.println("ECCEZIONE: "+e.getMessage());
        } catch (MalformedWordException e2){
            System.out.println("ECCEZIONE: "+e2.getMessage());
        }

        try {
            carota = new Parola("carota", "ortaggio");
        } catch (MalformedSignificatoException e) {
            System.out.println("ECCEZIONE: "+e.getMessage());
        } catch (MalformedWordException e2){
            System.out.println("ECCEZIONE: "+e2.getMessage());
        }
        try {
            caffeina = new Parola("caffeina", "alcaloide naturale");
        } catch (MalformedSignificatoException e) {
            System.out.println("ECCEZIONE: "+e.getMessage());
        } catch (MalformedWordException e2){
            System.out.println("ECCEZIONE: "+e2.getMessage());
        }
        try {
            badword = new Parola("","significato");
        } catch (MalformedSignificatoException e) {
            System.out.println("ECCEZIONE: "+e.getMessage());
        } catch (MalformedWordException e2){
            System.out.println("ECCEZIONE: "+e2.getMessage());
        }
        try {
            badwordmeaning = new Parola("badwordmeaning","?jbsdjv");
        } catch (MalformedSignificatoException e) {
            System.out.println("ECCEZIONE: "+e.getMessage());
        } catch (MalformedWordException e2){
            System.out.println("ECCEZIONE: "+e2.getMessage());
        }
        try {
            badDictionaryWord = new Parola("?","punto interrogativo");
        } catch (MalformedSignificatoException e) {
            System.out.println("ECCEZIONE: "+e.getMessage());
        } catch (MalformedWordException e2){
            System.out.println("ECCEZIONE: "+e2.getMessage());
        }

        try {
            calcio.addSignificato("elemento chimico");
        } catch (MalformedSignificatoException e) {
            System.out.println("ECCEZIONE: "+e.getMessage());
        } catch (NullPointerException e2) {
            System.out.println("Null Pointer Exception!!!!!!!");
        }

        try {
            nuovoDizioanrio.inserisciParola(calcio);
        } catch (MalformedWordException e) {
            System.out.println("ECCEZIONE: "+e.getMessage());
        } catch (NullPointerException e2) {
            System.out.println("Null Pointer Exception!!!!!!!");
        }

        try {
            nuovoDizioanrio.inserisciParola(carota);
        } catch (MalformedWordException e) {
            System.out.println("ECCEZIONE: "+e.getMessage());
        } catch (NullPointerException e2) {
            System.out.println("Null Pointer Exception!!!!!!!");
        }

        try {
            nuovoDizioanrio.inserisciParola(caffeina);
        } catch (MalformedWordException e) {
            System.out.println("ECCEZIONE: "+e.getMessage());
        } catch (NullPointerException e2) {
            System.out.println("Null Pointer Exception!!!!!!!");
        }

        try {
            nuovoDizioanrio.inserisciParola(badword);
        } catch (MalformedWordException e) {
            System.out.println("ECCEZIONE: "+e.getMessage());
        } catch (NullPointerException e2) {
            System.out.println("Null Pointer Exception!!!!!!!");
        }

        try {
            nuovoDizioanrio.inserisciParola(badwordmeaning);
        } catch (MalformedWordException e) {
            System.out.println("ECCEZIONE: "+e.getMessage());
        } catch (NullPointerException e2) {
            System.out.println("Null Pointer Exception!!!!!!!");
        }

        try {
            nuovoDizioanrio.inserisciParola(badDictionaryWord);
        } catch (MalformedWordException e) {
            System.out.println("ECCEZIONE: "+e.getMessage());
        } catch (NullPointerException e2) {
            System.out.println("Null Pointer Exception!!!!!!!");
        }


        System.out.println("\n");
        try {
            nuovoDizioanrio.printDictionary();
        } catch (VoidDictionaryException e) {
            System.out.println("ECCEZIONE: "+e.getMessage());
        }
    }
}
