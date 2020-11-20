package it.corsobackendtree.esercizi16.boxblur;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ImageBlurThread extends Thread{
    private final BufferedImage inputImage;
    private final BufferedImage outputImage;
    private final int startH;
    private final int endH;
    int raggioBlur;

    public ImageBlurThread(BufferedImage inputImage, BufferedImage outputImage, int startH, int endH, int raggioBlur){
        this.inputImage = inputImage;
        this.outputImage = outputImage;
        this.startH = startH;
        this.endH = endH;
        this.raggioBlur = raggioBlur;
    }

    @Override
    public void run() {
        bordi(inputImage,outputImage,startH,endH,raggioBlur);
    }

    private static Color calcoloBlurColore(int i, int j, int width, int height, int raggio, BufferedImage inputImage){
        int red = 0;
        int green = 0;
        int blue = 0;

        Color temp;
        int num = 0;
        for(int n=i-raggio; n<=i+raggio; n++){
            if(n < 0 || n >= width) continue;

            for(int m=j-raggio; m<=j+raggio; m++){
                if(m < 0 || m >= height) continue;
                temp = new Color(inputImage.getRGB(n,m));
                red += temp.getRed();
                green += temp.getGreen();
                blue += temp.getBlue();

                num++;
            }
        }
        return new Color(red/num,green/num,blue/num);
    }

    private static void bordi(BufferedImage inputImage, BufferedImage outputImage,int startH, int endH, int raggioBlur){
        for(int i = 0; i < inputImage.getWidth(); i++)
            for(int j = startH; j < endH; j++) //itero sui pixel dell'immagine
            {
                Color blurred = calcoloBlurColore(i,j,inputImage.getWidth(),inputImage.getHeight(),raggioBlur, inputImage);
                outputImage.setRGB(i,j,blurred.getRGB());
            }
    }
}
