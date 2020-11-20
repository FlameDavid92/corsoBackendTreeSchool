package it.corsobackendtree.esercizi16.gutenberganalyzer;

import java.util.Objects;
import java.util.TreeMap;

public class MyBook {
    private String fileName;
    private long[] letterCounters;
    private final TreeMap<Double, String> classifica;

    public MyBook(String fileName, long[] letterCounters){
        this.fileName = fileName;
        this.letterCounters = letterCounters;
        this.classifica = new TreeMap<>();
    }

    public String getFileName() {
        return fileName;
    }
    public long[] getLetterCounters() {
        return letterCounters;
    }
    public TreeMap<Double, String> getClassifica() {
        return classifica;
    }
    public void aggiornaClassificaLibro(String nuovoLibroCalcolato, double nuovaDistanza){
        synchronized (classifica){
            if(classifica.size()< 5) classifica.put(nuovaDistanza, nuovoLibroCalcolato);
            else if(nuovaDistanza < classifica.lastKey()){
                classifica.pollLastEntry();
                classifica.put(nuovaDistanza, nuovoLibroCalcolato);
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyBook myBook = (MyBook) o;
        return Objects.equals(fileName, myBook.fileName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fileName);
    }

    @Override
    public String toString() {
        return fileName;
    }
}
