package it.corsobackendtree.esercizi15.eserciziorighe;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.ListIterator;

public class EsercizioRighe {
    String path1,path2,path3,path4;
    private ArrayList<String> righe;

    public EsercizioRighe(String path1,String path2,String path3,String path4) {
        this.path1 = path1;
        this.path2 = path2;
        this.path3 = path3;
        this.path4 = path4;
        righe = new ArrayList<>();
    }

    public void scriviFileRigheInverse(String toReadFileName, String toWriteFileName) {
        salvaRigheFile(toReadFileName);
        Path pathFile = Paths.get(path1, path2, path3, path4, toWriteFileName);
        try(BufferedWriter bw = Files.newBufferedWriter(pathFile)) {
            ListIterator<String> listIterator = righe.listIterator(righe.size());
            if(listIterator.hasPrevious()){
                bw.write(listIterator.previous());
                while (listIterator.hasPrevious()) {
                    bw.write("\n"+listIterator.previous());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void salvaRigheFile(String fileName) {
        Path pathFile = Paths.get(path1, path2, path3, path4, fileName);
        if (!Files.isDirectory(pathFile)) {
            try (BufferedReader br = Files.newBufferedReader(pathFile)) {
                String line;
                while ((line = br.readLine()) != null) {
                    righe.add(line);
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
}
