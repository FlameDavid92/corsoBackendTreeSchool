package it.corsobackendtree.esercizi3;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class TrovaPrimi {
    public static void main(String[] args){
        TrovaPrimi tp = new TrovaPrimi();
        ArrayList al = tp.findPrimesLessEqualN(5000);
        System.out.println(al.toString());
    }

    private ArrayList<Integer> findPrimesLessEqualN(int n){
        ArrayList<Integer> primes = new ArrayList<>();
        primes.add(2); /* 2 è primo */
        primes.add(3); /* 3 è primo */
        /* tutti i pari non sono primi*/
        for(int i=5; i<=n; i+=2){
            if(checkOddPrimeGreaterThan3(i)) primes.add(i);
        }
        return primes;
    }

    /* number deve essere dispari! */
    private boolean checkOddPrimeGreaterThan3(int number) {
        int c = 3;
        while (c <= Math.sqrt(number)){
            if ( (number % c) == 0){
                return false;
            }
            c = c + 2;
        };
        return true;
    }
}
