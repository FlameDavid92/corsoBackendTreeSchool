package it.corsobackendtree.esercizi16.gutenberganalyzer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeMap;

public class GestoreClassifiche {
    private final HashSet<MyBook> classifiche;

    public GestoreClassifiche(){
        classifiche = new HashSet<>();
    }

    public HashSet<MyBook> getClassifiche() {
        return classifiche;
    }

    public void aggiungiLibro(String nuovoLibroCalcolato, long[] arrayDiLettere){
        MyBook nuovoLibro = new MyBook(nuovoLibroCalcolato,arrayDiLettere);

        synchronized (classifiche){
            classifiche.add(nuovoLibro);
        }

        classifiche.forEach(libro -> {
            if(!libro.equals(nuovoLibro)){
                double nuovaDistanza = calcolaDistanza(nuovoLibro.getLetterCounters(), libro.getLetterCounters());
                libro.aggiornaClassificaLibro(nuovoLibro.getFileName(),nuovaDistanza);
                nuovoLibro.aggiornaClassificaLibro(libro.getFileName(),nuovaDistanza);
            }
        });
    }

    public static double calcolaDistanza(long[] counter1, long[] counter2){
        int length = counter1.length;
        double ret = 0;
        for(int i=0; i<length; i++){
            ret += Math.pow(Math.abs(counter1[i]-counter2[i]),length);
        }
        ret = Math.pow(ret,1.0/length);
        return ret;
    }
}
