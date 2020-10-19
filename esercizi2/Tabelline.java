package it.corsobackendtree.esercizi2;

import java.util.Arrays;
import java.util.Scanner;

public class Tabelline {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Inserisci un intero n: ");
        int n =sc.nextInt();
        System.out.print("Inserisci un intero m: ");
        int m =sc.nextInt();
        Tabelline tb = new Tabelline();
        int[] resp = tb.calcolaInArray(n,m);
        System.out.println(Arrays.toString(resp));
    }

    private int[] calcolaInArray(int n, int m){
        int[] ret = new int[m];
        for(int i=0; i<m; i++){
            ret[i] = i*n;
        }
        return ret;
    }

}
