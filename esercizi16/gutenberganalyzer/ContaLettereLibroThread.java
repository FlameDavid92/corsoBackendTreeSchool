package it.corsobackendtree.esercizi16.gutenberganalyzer;

import java.io.FileReader;
import java.io.IOException;

public class ContaLettereLibroThread implements Runnable {
    private final String filePath;
    private final String fileName;
    private final long[] letterCounters;
    private final GestoreClassifiche gestoreClassifiche;

    public ContaLettereLibroThread(String filePath, String fileName, GestoreClassifiche gestoreClassifiche){
        this.filePath = filePath;
        this.fileName = fileName;
        letterCounters = new long[26];

        this.gestoreClassifiche = gestoreClassifiche;
    }

    public long[] getLetterCounters() {
        return letterCounters;
    }

    public String getFileName() {
        return fileName;
    }

    @Override
    public void run() {
        try (FileReader fr = new FileReader(filePath)) {
            int content;
            while ((content = fr.read()) != -1) {
                if(content >= 65 && content <= 90){
                    letterCounters[content-65]++;
                }else if(content >= 97 && content <= 122){
                    letterCounters[content-97]++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        gestoreClassifiche.aggiungiLibro(fileName,letterCounters);
    }
}
