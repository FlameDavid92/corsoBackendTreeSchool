package it.corsobackendtree.esercizi16.gutenberganalyzer;

import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.Callable;

public class ContaLettereLibroJob implements Callable<long[]> {
    String filePath;

    public ContaLettereLibroJob(String filePath){
        this.filePath = filePath;
    }

    @Override
    public long[] call() {
        long[] counters = new long[26];;
        try (FileReader fr = new FileReader(filePath)) {
            int content;
            while ((content = fr.read()) != -1) {
                if(content >= 65 && content <= 90){
                    counters[content-65]++;
                }else if(content >= 97 && content <= 122){
                    counters[content-97]++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return counters;
    }
}
