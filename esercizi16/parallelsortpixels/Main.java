package it.corsobackendtree.esercizi16.parallelsortpixels;

import it.corsobackendtree.esercizi16.parallelsortpixels.sortingpixelsandrearosati.soluzione.ThreadPixelSorter;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;

public class Main {
    public static void main(String[] args) {
        /*Leggi immagine*/
        BufferedImage inputImage = null;
        try {
            inputImage = ImageIO.read(new File("./it/corsobackendtree/esercizi16/parallelsortpixels/gris.png")); //caricamento immagine
        } catch (IOException e) {
        }
        BufferedImage outputImage = new BufferedImage(inputImage.getWidth(), inputImage.getHeight(), BufferedImage.TYPE_4BYTE_ABGR); // creazione immagine output

        System.out.println("Soluzione ANDREA ROSATI:");
        testParallelSortPixelsAndreaRosati(inputImage,outputImage);
        System.out.println("-----------------");
        System.out.println("Mie soluzioni:");
        testSortPixelsDavideFiguccia(inputImage,outputImage,0); /*Mergesort parallelo*/
        testSortPixelsDavideFiguccia(inputImage,outputImage,1); /*Arrays.parallelSort*/
        testSortPixelsDavideFiguccia(inputImage,outputImage,2); /*Arrays.sort (sequenziale)*/
        System.out.println("\n**I tempi non includono la scrittura dell'immagine né l'inizializzazione dell'inputImage e outputImage.");
    }

    private static void testParallelSortPixelsAndreaRosati(BufferedImage inputImage, BufferedImage outputImage){
        long startTime = System.currentTimeMillis();

        ThreadPixelSorter tps = new ThreadPixelSorter(inputImage, outputImage);

        tps.start();
        try {
            tps.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Tempo: "+(System.currentTimeMillis() - startTime));

        try {
            ImageIO.write(outputImage, "png", new File("./it/corsobackendtree/esercizi16/parallelsortpixels/outputImage.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void testSortPixelsDavideFiguccia(BufferedImage inputImage, BufferedImage outputImage, int op){
        /*Crea array di MyColor*/
        long startTime = System.currentTimeMillis();
        MyColor[] imageToSort = new MyColor[inputImage.getWidth() * inputImage.getHeight()];
        int k = 0;
        for (int i = 0; i < inputImage.getWidth(); i++) {
            for (int j = 0; j < inputImage.getHeight(); j++) {
                imageToSort[k++] = new MyColor(new Color(inputImage.getRGB(i, j)));
            }
        }

        /*Ordina array*/
        switch(op){
            case 0:
                final ForkJoinPool forkJoinPool = new ForkJoinPool(Runtime.getRuntime().availableProcessors() - 1);
                forkJoinPool.invoke(new ParallelMergeSortMyColor(imageToSort, 0, imageToSort.length - 1));
                System.out.println("Ordinamento su copia dell'immagine in array di MyColor -> con ParallelMergeSortMyColor.");
                break;
            case 1:
                Arrays.parallelSort(imageToSort); //ordinamento parallelo
                System.out.println("Ordinamento su copia dell'immagine in array di MyColor -> con Arrays.parallelSort.");
                break;
            case 2:
                Arrays.sort(imageToSort); //ordinamento sequenziale
                System.out.println("Ordinamento su copia dell'immagine in array di MyColor -> con Arrays.sort.");
                break;
            default:
                System.out.println("op in input non riconosiuta!");
                return;
        }

        /*Utilizza l'array per settare i colori dell'immagine in output*/
        k=0;
        for (int j = 0; j < inputImage.getHeight(); j++) {
            for (int i = 0; i < inputImage.getWidth(); i++) {
                outputImage.setRGB(i, j, imageToSort[k++].getColor().getRGB());
            }
        }
        System.out.println("Tempo: "+(System.currentTimeMillis() - startTime)+" millisecondi.\n");

        /*Scrivi immagine*/
        try {
            ImageIO.write(outputImage, "png", new File("./it/corsobackendtree/esercizi16/parallelsortpixels/outputImage.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
