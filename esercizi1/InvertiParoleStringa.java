package it.corsobackendtree.esercizi1;
import java.util.Scanner;

public class InvertiParoleStringa {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Inserisci una stringa: ");
        String a=sc.nextLine();
        reverseStringWords(a);
        sc.close();
    }

    /**
     * Metodo reverseStringWords(String s)
     *
     * input: una stringa s.
     * stringReverse: stampa le parole di cui è composta la stringa s in ordine inverso rispetto all'ordine in s.
     * output: -
     */
    private static void reverseStringWords(String s) {
        String[] split = s.trim().split(" ");
        for(int i=(split.length-1); i>=0; i--) {
        	System.out.print(split[i]+" ");
        }
    }
}