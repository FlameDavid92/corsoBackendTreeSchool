package it.corsobackendtree.esercizi16.gutenberganalyzer;

import java.util.Objects;

public class MyBook {
    private String fileName;
    private long[] letterCounters;

    public MyBook(String fileName, long[] letterCounters){
        this.fileName = fileName;
        this.letterCounters = letterCounters;
    }

    public String getFileName() {
        return fileName;
    }
    public long[] getLetterCounters() {
        return letterCounters;
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
