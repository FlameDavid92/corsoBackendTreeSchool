package it.corsobackendtree.esercizi13.dictionary;

import it.corsobackendtree.esercizi13.dictionary.eccezioni.MalformedWordException;
import it.corsobackendtree.esercizi13.dictionary.eccezioni.VoidDictionaryException;

import java.util.*;

public class Dictionary {
    Map<Character, Set<Parola>> dizionario;

    public Dictionary() {
        dizionario = new HashMap<>();
        inizializzaDizionario();
    }

    private void inizializzaDizionario() {
        for (int i = 65; i < 91; i++) {
            dizionario.put((char) i, new TreeSet<>());
        }
    }

    public boolean inserisciParola(Parola parola) throws MalformedWordException {
        Character firstChar = parola.getParola().toUpperCase().charAt(0);
        if (dizionario.containsKey(firstChar)) {
            return dizionario.get(firstChar).add(parola);
        } else {
            throw new MalformedWordException("Non è possibile aggiungere la parola data a questo dizionario!");
        }
    }

    public void printDictionary() throws VoidDictionaryException {
        boolean check = false;
        for (Character key : dizionario.keySet()) {
            if (dizionario.get(key).size() != 0) {
                if(!check) check = true;
                System.out.print(key + ":");
                System.out.print(dizionario.get(key)+"\n");
            }
        }
        if(!check){
            throw new VoidDictionaryException("Non ci sono parole nel dizionario!");
        }
    }
}
