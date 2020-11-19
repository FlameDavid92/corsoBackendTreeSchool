package it.corsobackendtree.esercizi16.covidsimulator2020;

import java.io.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CovidFileJob implements Runnable {
    String filepath;
    BufferedWriter writer;
    ExecutorService pool;

    public CovidFileJob(String filepath, BufferedWriter writer){
        this.filepath = filepath;
        this.writer = writer;
        this.pool = Executors.newFixedThreadPool(5);
    }

    @Override
    public void run() {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(filepath));
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(br != null){
            String line;
            try{
                while ((line = br.readLine()) != null) {
                    pool.submit(new AnalizzaUtenteJob(line,writer));
                }
                br.close();
            }catch(IOException e){
                e.printStackTrace();
            }

            pool.shutdown();

            try {
                pool.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
