package it.corsobackendtree.esercizi16.gutenberganalyzer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class GutenbergAnalyzer {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        String booksDirectory = "./it/corsobackendtree/esercizi16/gutenberganalyzer/books/";
        Set<String> files = listFilesUsingFileWalk(booksDirectory, 1);
        ExecutorService pool = Executors.newFixedThreadPool(5);

        if (files != null) {

            HashSet<Integer> indiciThreads = new HashSet<>();
            IntStream.range(0, files.size()).forEach(ind -> indiciThreads.add(ind));
            Set<Integer> syncSet = Collections.synchronizedSet(indiciThreads);
            ArrayList<ContaLettereLibroThread> threadsList = new ArrayList<>();

            int i = 0;
            ContaLettereLibroThread temp;
            for (String fileName : files) {
                temp = new ContaLettereLibroThread(i, booksDirectory + fileName, fileName);
                threadsList.add(temp);
                pool.submit(temp);
                i++;
            }
            pool.shutdown();

            try {
                pool.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
                return;
            }

            /*CLASSIFICA SEQUENZIALE*/
            HashMap<String,TreeMap<Double, String>> classifiche = new HashMap<>();
            TreeMap<Double, String> classifica;
            double[] distanze;

            for(int k=0; k<threadsList.size(); k++){
                classifica = new TreeMap<>();
                distanze = new double[threadsList.size()];
                distanze[k] = 0;
                for(int j=0; j<threadsList.size(); j++){
                    if(j==k) continue;
                    double distanza = calcolaDistanza(threadsList.get(k).getLetterCounters(), threadsList.get(j).getLetterCounters());
                    if(classifica.size() < 5) classifica.put(distanza,threadsList.get(j).getFileName());
                    else if(distanza < classifica.lastKey()){
                        classifica.pollLastEntry();
                        classifica.put(distanza,threadsList.get(j).getFileName());
                    }
                }
                classifiche.put(threadsList.get(k).getFileName(), classifica);
            }

            for(Map.Entry<String,TreeMap<Double, String>> entry : classifiche.entrySet()){
                System.out.println(entry.getKey()+":");
                for(Map.Entry<Double, String> libro : entry.getValue().entrySet()){
                    System.out.println("    "+libro.getValue()+" -- "+libro.getKey());
                }
                System.out.println();
            }
        }

        System.out.println((System.currentTimeMillis() - startTime)+" millisecondi.");
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

    public static Set<String> listFilesUsingFileWalk(String dir, int depth) {
        try (Stream<Path> stream = Files.walk(Paths.get(dir), depth)) {
            return stream
                    .filter(file -> !Files.isDirectory(file))
                    .map(Path::getFileName)
                    .map(Path::toString)
                    .collect(Collectors.toSet());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
