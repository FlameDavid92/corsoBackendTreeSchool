package it.corsobackendtree.esercizi1;
import java.util.Scanner;

public class StringReverse {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Inserisci una stringa: ");
        String a = sc.nextLine();
        stringReverse3(a);
        sc.close();
    }

    /**
     * Metodo stringReverse(String s)
     *
     * input: una stringa s.
     * stringReverse: stampa la stringa s al contrario.
     * output: -
     */
    static void stringReverse(String s) {
        for(int i=s.length()-1; i>=0; i--) {
            System.out.print(s.charAt(i));
        }
    }

    static void stringReverse2(String s) {
        char[] rev = s.toCharArray();
        for(int i=s.length()/2; i>=0; i--) {
            char tmp = rev[i];
            rev[i] = rev[rev.length-i-1];
            rev[rev.length-i-1] = tmp;
        }
        System.out.println(rev);
    }

    /* Metodo migliore */
    static void stringReverse3(String s) {
        System.out.println(new StringBuffer(s).reverse());
    }
}
