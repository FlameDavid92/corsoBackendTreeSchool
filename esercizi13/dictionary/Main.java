package it.corsobackendtree.esercizi13.dictionary;

import it.corsobackendtree.esercizi13.dictionary.eccezioni.MalformedSignificatoException;
import it.corsobackendtree.esercizi13.dictionary.eccezioni.MalformedWordException;
import it.corsobackendtree.esercizi13.dictionary.eccezioni.VoidDictionaryException;

public class Main {
    public static void main(String[] args) {
        Dictionary nuovoDizionario = new Dictionary();
        stampaDizionario(nuovoDizionario);

        Parola calcio = creaParola("calcio","sport");
        Parola carota = creaParola("carota","ortaggio");
        Parola caffeina = creaParola("caffeina","alcaloide naturale");
        Parola badword = creaParola("","significato");
        Parola badwordmeaning = creaParola("badwordmeaning","?jbsdjv");
        Parola badDictionaryWord = creaParola("?","punto interrogativo");

        aggiungiSignificato(calcio,"elemento chimico");

        aggiungiParola(nuovoDizionario,calcio);
        aggiungiParola(nuovoDizionario,carota);
        aggiungiParola(nuovoDizionario,caffeina);
        aggiungiParola(nuovoDizionario,badword);
        aggiungiParola(nuovoDizionario,badwordmeaning);
        aggiungiParola(nuovoDizionario,badDictionaryWord);

        stampaDizionario(nuovoDizionario);
    }

    private static void stampaDizionario(Dictionary dizionario){
        System.out.println("\n");
        try {
            dizionario.printDictionary();
        } catch (VoidDictionaryException e) {
            System.out.println("ECCEZIONE: "+e.getMessage());
        }
    }

    private static void aggiungiParola(Dictionary dizionario, Parola parola){
        try {
            dizionario.inserisciParola(parola);
        } catch (MalformedWordException e) {
            System.out.println("ECCEZIONE: "+e.getMessage());
        } catch (NullPointerException e2) {
            System.out.println("Null Pointer Exception!!!!!!!");
        }
    }
    private static Parola creaParola(String parola, String significato){
        try {
            Parola ret = new Parola(parola, significato);
            return ret;
        } catch (MalformedSignificatoException e) {
            System.out.println("ECCEZIONE: "+e.getMessage());
        } catch (MalformedWordException e2){
            System.out.println("ECCEZIONE: "+e2.getMessage());
        }
        return null;
    }
    private static void aggiungiSignificato(Parola parola, String significato){
        try {
            parola.addSignificato(significato);
        } catch (MalformedSignificatoException e) {
            System.out.println("ECCEZIONE: "+e.getMessage());
        } catch (NullPointerException e2) {
            System.out.println("Null Pointer Exception!!!!!!!");
        }
    }
}
