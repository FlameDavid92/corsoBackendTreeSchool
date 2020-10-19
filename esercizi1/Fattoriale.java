package it.corsobackendtree.esercizi1;

import java.math.BigInteger;

public class Fattoriale {
    public static void main(String[] args) {
        System.out.println(factorial(0) == (1));
        System.out.println(factorial(2) == (2));
        System.out.println(factorial(5) == (120));
        System.out.println(factorial(10) == (3628800));
        System.out.println(factorial(20) == 2432902008176640000L);
    }

    /**
     * Metodo factorial(int n)
     *
     * input: un interno n.
     * output: un long il cui valore è il fattoriale di n.
     */
    private static long factorial(int n) {
        if(n==0 || n==1){ /*caso base*/
            return 1;
        }
        long l = 1L;
        for(int i = n; i>=2; i--){
            l *= i;
        }
        return l;
    }

    /* Versione ricorsiva */
    private static long recursiveFactorial(long n) {
        if(n == 0)
            return 1; /*caso base*/
        else
            return n * recursiveFactorial(n-1);
    }
}
