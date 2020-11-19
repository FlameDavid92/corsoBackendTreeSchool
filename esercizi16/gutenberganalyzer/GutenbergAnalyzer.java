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
        String booksDirectory = "./it/corsobackendtree/esercizi16/gutenberganalyzer/books/";
        Set<String> files = listFilesUsingFileWalk(booksDirectory,1);
        ExecutorService pool = Executors.newFixedThreadPool(5);

        if(files != null){

            HashSet<Integer> indiciThreads = new HashSet<>();
            IntStream.range(0, files.size()).forEach(ind-> indiciThreads.add(ind));
            Set<Integer> syncSet = Collections.synchronizedSet(indiciThreads);

            int i=0;
            for(String fileName : files){
                pool.submit(new ContaLettereLibroThread(i,booksDirectory+fileName, fileName, syncSet));
                i++;
            }
            pool.shutdown();
            try {
                pool.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
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
