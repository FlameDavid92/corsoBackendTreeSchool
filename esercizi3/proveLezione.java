package it.corsobackendtree.esercizi3;

import java.util.Random;

public class proveLezione {
    public static void main(String args[]) {
        Random rand = new Random();
        for (int i = 0; i < 50; i++) {
            System.out.println(rand.nextGaussian() * 2); /* deviazione standard 2, valore medio 0 */
        }
    }
}
