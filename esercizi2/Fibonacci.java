package it.corsobackendtree.esercizi2;
import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Inserisci un intero: ");
        int index =sc.nextInt();
        long resp = fibonacci(index);
        System.out.println(resp);
    }

    static long fibonacci(int index) {
        if(index == 0) return 0;
        else if(index == 1) return 1;

        long[] temps = new long[2];
        temps[0] = 0; /*Fibonacci(0)*/
        temps[1] = 1; /*Fibonacci(1)*/
        long toSwitch;
        for(long i=2; i<=index; i++){
            toSwitch = temps[1];
            temps[1] += temps[0];
            temps[0] = toSwitch;
        }
        return temps[1];
    }
}
