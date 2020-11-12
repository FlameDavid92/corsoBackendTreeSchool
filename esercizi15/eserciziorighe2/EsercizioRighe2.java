package it.corsobackendtree.esercizi15.eserciziorighe2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class EsercizioRighe2 {
    String path1,path2,path3,path4;
    private Map<String, String[]> righe;

    public EsercizioRighe2(String path1,String path2,String path3,String path4){
        this.path1 = path1;
        this.path2 = path2;
        this.path3 = path3;
        this.path4 = path4;
        righe = new LinkedHashMap<>();
    }

    private void salvaRigheFile(String fileName) {
        Path pathFile = Paths.get(path1, path2, path3, path4, fileName);
        if (!Files.isDirectory(pathFile)) {
            try (BufferedReader br = Files.newBufferedReader(pathFile)) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] keyAndWords = line.split(":");
                    String[] words = keyAndWords[1].split(",");
                    righe.put(keyAndWords[0],words);
                }
            } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("No directory!!!");
        }
    }

    public void printMapRighe(String fileName){
        salvaRigheFile(fileName);
        Set<String> keys = righe.keySet();
        Iterator<String> it = keys.iterator();
        String tempKey;
        while(it.hasNext()) {
            tempKey = it.next();
            System.out.println(tempKey+": "+Arrays.toString(righe.get(tempKey)));
        }
    }
}
