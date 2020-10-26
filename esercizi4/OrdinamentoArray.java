package it.corsobackendtree.esercizi4;
import java.util.Arrays;
import java.util.Scanner;

public class OrdinamentoArray {
    public static void main(String[] args){
        System.out.println("Inserisci interi separati dalla virgola: ");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] inputArr = input.split(",");
        int[] intInputArr = new int[inputArr.length];
        for(int i=0; i<inputArr.length; i++){
            intInputArr[i] = Integer.parseInt(inputArr[i]);
        }
        Arrays.sort(intInputArr);
        System.out.println(Arrays.toString(intInputArr));
    }
}
