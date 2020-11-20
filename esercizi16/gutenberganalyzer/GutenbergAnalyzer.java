package it.corsobackendtree.esercizi16.gutenberganalyzer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GutenbergAnalyzer {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        String booksDirectory = "./it/corsobackendtree/esercizi16/gutenberganalyzer/books/";
        List<String> filesName = listFilesUsingFileWalk(booksDirectory, 1);
        ExecutorService pool = Executors.newFixedThreadPool(5);

        if (filesName != null) {
            GestoreClassifiche gestoreClassifiche = new GestoreClassifiche();

            int i = 0;
            ContaLettereLibroThread temp;
            for (String fileName : filesName) {
                temp = new ContaLettereLibroThread(i, booksDirectory + fileName, fileName, gestoreClassifiche);
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

            /*STAMPA CLASSIFICHE*/
            HashSet<MyBook> classifiche = gestoreClassifiche.getClassifiche();
            for(MyBook libro : classifiche){
                System.out.println(libro.getFileName()+":");
                for(Map.Entry<Double, String> libroInClassifica : libro.getClassifica().entrySet()){
                    System.out.println("    "+libroInClassifica.getValue()+" -- "+libroInClassifica.getKey());
                }
                System.out.println();
            }
        }

        System.out.println((System.currentTimeMillis() - startTime)+" millisecondi.");
    }

    public static List<String> listFilesUsingFileWalk(String dir, int depth) {
        try (Stream<Path> stream = Files.walk(Paths.get(dir), depth)) {
            return stream
                    .filter(file -> !Files.isDirectory(file))
                    .map(Path::getFileName)
                    .map(Path::toString)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
