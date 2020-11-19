package it.corsobackendtree.esercizi16.gutenberganalyzer;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Set;

public class ContaLettereLibroThread extends Thread {
    int index;
    String filePath;
    String fileName;
    long[] letterCounters;
    Set<Integer> syncSet;
    double[] distanze;

    public ContaLettereLibroThread(int index, String filePath, String fileName, Set<Integer> syncSet){
        this.index = index;
        this.filePath = filePath;
        this.fileName = fileName;
        letterCounters = new long[26];
        this.syncSet = syncSet;
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

        syncSet.remove(index);
        
        System.out.println(Arrays.toString(letterCounters));
    }
}
