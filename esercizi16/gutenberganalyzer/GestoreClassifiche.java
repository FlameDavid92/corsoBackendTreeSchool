package it.corsobackendtree.esercizi16.gutenberganalyzer;

import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

public class GestoreClassifiche {
    HashMap<MyBook, TreeMap<Double, String>> classifiche;

    public GestoreClassifiche(){
        classifiche = new HashMap<>();
    }

    public HashMap<MyBook, TreeMap<Double, String>> getClassifiche() {
        return classifiche;
    }

    private void aggiornaClassificaLibro(MyBook libro, String nuovoLibroCalcolato, double nuovaDistanza){
        if(classifiche.containsKey(libro)){
            TreeMap<Double, String> classifica = classifiche.get(libro);
            if(classifica.size()< 5) classifica.put(nuovaDistanza, nuovoLibroCalcolato);
            else if(nuovaDistanza < classifica.lastKey()){
                classifica.pollLastEntry();
                classifica.put(nuovaDistanza, nuovoLibroCalcolato);
            }
        }else{
            System.out.println("Nome file libro non riconosciuto!");
        }
    }

    synchronized public void aggiungiLibro(String nuovoLibroCalcolato, long[] arrayDiLettere){
        MyBook nuovoLibro = new MyBook(nuovoLibroCalcolato,arrayDiLettere);

        classifiche.put(nuovoLibro,new TreeMap<>());

        classifiche.keySet().stream().forEach(key -> {
            if(!key.equals(nuovoLibro)){
                MyBook current = key;
                double nuovaDistanza = calcolaDistanza(nuovoLibro.getLetterCounters(), current.getLetterCounters());
                aggiornaClassificaLibro(key, nuovoLibro.getFileName(),nuovaDistanza);
                aggiornaClassificaLibro(nuovoLibro,current.getFileName(),nuovaDistanza);
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
