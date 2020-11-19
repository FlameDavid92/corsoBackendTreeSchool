package it.corsobackendtree.esercizi16.parallelsortpixels;

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

        /*Crea array di MyColor*/
        MyColor[] imageToSort = new MyColor[inputImage.getWidth() * inputImage.getHeight()];
        int k = 0;
        for (int i = 0; i < inputImage.getWidth(); i++) {
            for (int j = 0; j < inputImage.getHeight(); j++) {
                imageToSort[k++] = new MyColor(new Color(inputImage.getRGB(i, j)));
            }
        }

        /*Ordina array*/
        ordinamParMyParMergesort(imageToSort);
        //ordinamParJava(imageToSort);
        //ordinamSeqJava(imageToSort);

        /*Utilizza l'array per settare i colori dell'immagine in output*/
        k=0;
        for (int j = 0; j < inputImage.getHeight(); j++) {
            for (int i = 0; i < inputImage.getWidth(); i++) {
                outputImage.setRGB(i, j, imageToSort[k++].getColor().getRGB());
            }
        }

        /*Scrivi immagine*/
        try {
            ImageIO.write(outputImage, "png", new File("./it/corsobackendtree/esercizi16/parallelsortpixels/outputImage.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void ordinamSeqJava(MyColor[] imageToSort){
        long startTime = System.currentTimeMillis();
        Arrays.sort(imageToSort); //ordinamento sequenziale
        System.out.println("Ordinamento sequenziale (Arrays.sort): "+(System.currentTimeMillis() - startTime)+" millisecondi.");
    }

    private static void ordinamParJava(MyColor[] imageToSort){
        long startTime = System.currentTimeMillis();
        Arrays.parallelSort(imageToSort); //ordinamento parallelo
        System.out.println("Ordinamento parallelo (Arrays.parallelSort): "+(System.currentTimeMillis() - startTime)+" millisecondi.");
    }

    private static void ordinamParMyParMergesort(MyColor[] imageToSort){
        long startTime = System.currentTimeMillis();
        final ForkJoinPool forkJoinPool = new ForkJoinPool(Runtime.getRuntime().availableProcessors() - 1);
        forkJoinPool.invoke(new ParallelMergeSortMyColor(imageToSort, 0, imageToSort.length - 1));
        System.out.println("Ordinamento parallelo (ParallelMergesortMyColor): "+(System.currentTimeMillis() - startTime)+" millisecondi.");
    }
}
