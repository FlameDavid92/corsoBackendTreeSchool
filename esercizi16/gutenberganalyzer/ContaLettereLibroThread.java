package it.corsobackendtree.esercizi16.gutenberganalyzer;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Set;
import java.util.concurrent.Callable;


public class ContaLettereLibroThread implements Callable<long[]> {
    private int index;
    private String filePath;
    private String fileName;
    private long[] letterCounters;

    public ContaLettereLibroThread(int index, String filePath, String fileName){
        this.index = index;
        this.filePath = filePath;
        this.fileName = fileName;
        letterCounters = new long[26];
    }

    public long[] getLetterCounters() {
        return letterCounters;
    }

    public String getFileName() {
        return fileName;
    }

    @Override
    public long[] call() {
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
        //System.out.println(Arrays.toString(letterCounters));
        return letterCounters;
    }
}
