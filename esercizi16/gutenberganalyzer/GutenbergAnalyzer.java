package it.corsobackendtree.esercizi16.gutenberganalyzer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class GutenbergAnalyzer {
    public static void main(String[] args) {
        String booksDirectory = "./it/corsobackendtree/esercizi16/gutenberganalyzer/books/";
        Set<String> files = listFilesUsingFileWalk(booksDirectory,1);
        ExecutorService pool = Executors.newFixedThreadPool(5);

        ArrayList<Future<long[]>> futures = new ArrayList<>();

        if(files != null){
            for(String fileName : files){
                futures.add(pool.submit(new ContaLettereLibroJob(booksDirectory+fileName)));
            }

            pool.shutdown();
            try {
                pool.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        IntStream stream = IntStream.range(0, futures.size());
        stream.forEach(ind -> {
            if(futures.get(ind).isDone()){
                System.out.println(ind + "completed.");
                /*try {
                    System.out.println(Arrays.toString(futures.get(ind).get()));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }*/
            }
        });
        //ArrayList<long[]>
        IntStream stream2 = IntStream.range(0, futures.size());
        IntStream stream3 = IntStream.range(0, futures.size());



    }

    public static Set<String> listFilesUsingFileWalk(String dir, int depth){
        try (Stream<Path> stream = Files.walk(Paths.get(dir), depth)) {
            return stream
                    .filter(file -> !Files.isDirectory(file))
                    .map(Path::getFileName)
                    .map(Path::toString)
                    .collect(Collectors.toSet());
        }catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
