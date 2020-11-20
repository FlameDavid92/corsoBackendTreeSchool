package it.corsobackendtree.esercizi16.boxblur;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) {
        String pathInputImage = "./it/corsobackendtree/esercizi16/boxblur/sample.jpg";
        String pathOutputImage1 = "./it/corsobackendtree/esercizi16/boxblur/output1.png";
        String pathOutputImage5 = "./it/corsobackendtree/esercizi16/boxblur/output5.png";
        String pathOutputImage10 = "./it/corsobackendtree/esercizi16/boxblur/output10.png";
        String pathOutputImage20 = "./it/corsobackendtree/esercizi16/boxblur/output20.png";
        creaImmagineConSfocatura(pathInputImage,pathOutputImage1,1);
        creaImmagineConSfocatura(pathInputImage,pathOutputImage5,5);
        creaImmagineConSfocatura(pathInputImage,pathOutputImage10,10);
        creaImmagineConSfocatura(pathInputImage,pathOutputImage20,20);
    }

    public static void creaImmagineConSfocatura(String pathInputImage, String pathOutputImage, int raggioBlur){
        System.out.println("RAGGIO BLUR: "+raggioBlur);
        BufferedImage inputImage = null;
        try {
            inputImage = ImageIO.read(new File(pathInputImage)); //caricamento immagine
        } catch (IOException e) {
        }
        BufferedImage outputImage = new BufferedImage(inputImage.getWidth(), inputImage.getHeight(), BufferedImage.TYPE_4BYTE_ABGR); // creazione immagine output

        testSequenziale(inputImage,outputImage,raggioBlur);
        testParalleloDivisioneIn2Righe(inputImage,outputImage,raggioBlur);
        testParalleloDivisioneIn4Righe(inputImage,outputImage,raggioBlur);

        long startTime = System.currentTimeMillis();
        try {
            ImageIO.write(outputImage, "png", new File(pathOutputImage));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Scrittura immagine: "+(System.currentTimeMillis() - startTime)+" millisecondi.\n");
    }

    public static void testSequenziale(BufferedImage inputImage, BufferedImage outputImage, int raggioBlur){
        long startTime = System.currentTimeMillis();
        ImageBlurThread t1 = new ImageBlurThread(inputImage,outputImage,0,inputImage.getHeight(),raggioBlur);
        t1.run();
        System.out.println("Sequenziale: "+(System.currentTimeMillis() - startTime)+" millisecondi.");
    }

    public static void testParalleloDivisioneIn2Righe(BufferedImage inputImage, BufferedImage outputImage, int raggioBlur){
        long startTime = System.currentTimeMillis();
        ImageBlurThread t1 = new ImageBlurThread(inputImage,outputImage,0,inputImage.getHeight()/2,raggioBlur);
        ImageBlurThread t2 = new ImageBlurThread(inputImage,outputImage,inputImage.getHeight()/2,inputImage.getHeight(), raggioBlur);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Parallelo divisione in 2 righe: "+(System.currentTimeMillis() - startTime)+" millisecondi.");
    }

    public static void testParalleloDivisioneIn4Righe(BufferedImage inputImage, BufferedImage outputImage, int raggioBlur){
        long startTime = System.currentTimeMillis();
        ImageBlurThread t1 = new ImageBlurThread(inputImage,outputImage,0,inputImage.getHeight()/4, raggioBlur);
        ImageBlurThread t2 = new ImageBlurThread(inputImage,outputImage, inputImage.getHeight()/4,(inputImage.getHeight()/4)*2, raggioBlur);
        ImageBlurThread t3 = new ImageBlurThread(inputImage,outputImage,(inputImage.getHeight()/4)*2,(inputImage.getHeight()/4)*3, raggioBlur);
        ImageBlurThread t4 = new ImageBlurThread(inputImage,outputImage, (inputImage.getHeight()/4)*3,inputImage.getHeight(),raggioBlur);

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Parallelo divisione in 4 righe: "+(System.currentTimeMillis() - startTime)+" millisecondi.");
    }
}

