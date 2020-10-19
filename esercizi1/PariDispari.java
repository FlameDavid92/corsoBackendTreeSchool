package it.corsobackendtree.esercizi1;
import java.util.Scanner;
 
public class PariDispari {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Inserisci un intero: ");
        int number =sc.nextInt();
        checkEvenOdd(number);
        sc.close();
    }

    /**
     * Metodo stringReverse(String s)
     *
     * input: una stringa s
     * stringReverse: stampa la stringa s al contrario
     * output: -
     */
    private static void checkEvenOdd(int number) {
    	if(number%2 == 0) {
    		System.out.print(true);
    	}else {
    		System.out.print(false);
    	}
    }
}