package it.corsobackendtree.esercizi1;

import java.util.Scanner;

public class ContaOccorrenze {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Inserisci un carattere a: ");
        String a = sc.nextLine();
        System.out.print("Inserisci una stringa b: ");
        String b =sc.nextLine();
        countOccurrences3(a.charAt(0), b);
    }

    /**
     * Metodo countOccurrences(char a, String b)
     *
     * input: un carattere a ed una stringa s.
     * stringReverse: stampa il numero di occorrenze del carattere a nella stringa s.
     */
    static void countOccurrences(char a, String b) {
        int occ = 0;
        for(int i=0; i<b.length(); i++){
            if(b.charAt(i) == a) occ++;
        }
        System.out.println(occ);
    }
    static void countOccurrences2(char a, String b) {
        int occ = 0;
        for(char c : b.toCharArray()){
            if(c == a) occ++;
        }
        System.out.println(occ);
    }

    /* Metodo migliore */
    static void countOccurrences3(char a, String b) {
        System.out.println(b.length() - (b.replaceAll(""+a, "").length()));
    }
}
