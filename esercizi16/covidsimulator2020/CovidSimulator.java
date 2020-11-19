package it.corsobackendtree.esercizi16.covidsimulator2020;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CovidSimulator {
    private static String directory = "./it/corsobackendtree/esercizi16/covidsimulator2020/";

    public static void main(String[] args) {
        testFileThread();
        testLineJobs();
        testCorrettezza();
    }

    private static void testCorrettezza(){
        long startTime = System.currentTimeMillis();
        boolean resp = true;
        Set<String> ids = new HashSet<>();

        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(directory+"myoutput.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(br != null){
            String line;
            try{
                while ((line = br.readLine()) != null) {
                    ids.add(line);
                }
                br.close();
            }catch(IOException e){
                e.printStackTrace();
            }
        }

        try {
            br = new BufferedReader(new FileReader(directory+"validoutput.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(br != null){
            String line;
            try{
                while ((line = br.readLine()) != null) {
                    if(!ids.contains(line)){
                        resp = false;
                        break;
                    }
                }
                br.close();
            }catch(IOException e){
                e.printStackTrace();
            }
        }
        System.out.println("TEST CORRETTEZZA: "+resp+" ("+(System.currentTimeMillis() - startTime) + " millisecondi).");
    }

    private static void testFileThread(){
        long startTime = System.currentTimeMillis();
        BufferedWriter bw = null;
        try {
            bw = Files.newBufferedWriter(Paths.get(directory+"myoutput.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (bw!=null){
            CovidFileThread t1 = new CovidFileThread(directory+"files/nord.txt", bw);
            CovidFileThread t2 = new CovidFileThread(directory+"files/centro.txt", bw);
            CovidFileThread t3 = new CovidFileThread(directory+"files/sud.txt", bw);

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
        ExecutorService pool = Executors.newFixedThreadPool(3);
        BufferedWriter bw = null;
        try {
            bw = Files.newBufferedWriter(Paths.get(directory+"myoutput.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (bw!=null){
            pool.submit(new CovidFileJob(directory+"files/nord.txt",bw));
            pool.submit(new CovidFileJob(directory+"files/centro.txt",bw));
            pool.submit(new CovidFileJob(directory+"files/sud.txt",bw));

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