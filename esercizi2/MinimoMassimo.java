package it.corsobackendtree.esercizi2;
import java.util.Arrays;
import java.util.Scanner;

public class MinimoMassimo {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Inserisci numeri (separati dalla virgola): ");
        String a = sc.nextLine();
        int[] values = parseNumbers(a);
        computeMinAndMax(values);
    }

    static int[] parseNumbers(String s) {
        String[] numbers = s.split(",");
        int[] retNumbers = new int[numbers.length];
        for(int i=0; i<numbers.length;i++){
            retNumbers[i] = Integer.parseInt(numbers[i]);
        }
        return retNumbers;
    }

    static void computeMinAndMax(int[] values) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i=0; i<values.length;i++){
            if(values[i] > max) max = values[i];
            if(values[i] < min) min = values[i];
        }
        System.out.println(min+", "+max);
    }
}
