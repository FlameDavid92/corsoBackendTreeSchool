package it.corsobackendtree.esercizi13;

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

    public boolean inserisciParola(Parola parola) {
        Character firstChar = parola.getParola().toUpperCase().charAt(0);
        if (dizionario.containsKey(firstChar)) {
            return dizionario.get(firstChar).add(parola);
        } else {
            System.out.println("Non è possibile aggiungere la parola data a questo dizionario!");
            return false;
        }
    }

    public void printDictionary() {
        for (Character key : dizionario.keySet()) {
            if (dizionario.get(key).size() != 0) {
                System.out.print(key + ":");
                System.out.print(dizionario.get(key)+"\n");
            }
        }
    }
}
