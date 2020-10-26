package it.corsobackendtree.esercizi6.numeriromani;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Inserisci un numero romano: ");
        Scanner input = new Scanner(System.in);
        String data = input.nextLine();

        NumeroRomano nr = new NumeroRomano(data);
        System.out.println(nr.getValore());
    }
}
