package it.corsobackendtree.esercizi16.covidsimulator2020;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CovidSimulator {
    private static ExecutorService pool;

    public static void main(String[] args) {
        testFileJobs();
        testLineJobs();
    }

    private static void testFileJobs(){
        long startTime = System.currentTimeMillis();
        BufferedWriter bw = null;
        try {
            bw = Files.newBufferedWriter(Paths.get("./it/corsobackendtree/esercizi16/covidsimulator2020/output.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (bw!=null){
            CovidFileJob2 t1 = new CovidFileJob2("./it/corsobackendtree/esercizi16/covidsimulator2020/files/nord.txt", bw);
            CovidFileJob2 t2 = new CovidFileJob2("./it/corsobackendtree/esercizi16/covidsimulator2020/files/centro.txt", bw);
            CovidFileJob2 t3 = new CovidFileJob2("./it/corsobackendtree/esercizi16/covidsimulator2020/files/sud.txt", bw);

            t1.start();
            t2.start();
            t3.run();
            try {
                t1.join();
                t2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Soluzione con 3 thread: "+(System.currentTimeMillis() - startTime) + " millisecondi.");
    }

    private static void testLineJobs(){
        long startTime = System.currentTimeMillis();
        pool = Executors.newFixedThreadPool(3);
        BufferedWriter bw = null;
        try {
            bw = Files.newBufferedWriter(Paths.get("./it/corsobackendtree/esercizi16/covidsimulator2020/output.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (bw!=null){
            pool.submit(new CovidFileJob("./it/corsobackendtree/esercizi16/covidsimulator2020/files/nord.txt",bw));
            pool.submit(new CovidFileJob("./it/corsobackendtree/esercizi16/covidsimulator2020/files/centro.txt",bw));
            pool.submit(new CovidFileJob("./it/corsobackendtree/esercizi16/covidsimulator2020/files/sud.txt",bw));

            pool.shutdown();
            try {
                pool.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
                bw.close();
            } catch (InterruptedException | IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Soluzione con un Job per ogni linea: "+(System.currentTimeMillis() - startTime) + " millisecondi.");
    }
}