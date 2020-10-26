package it.corsobackendtree.esercizi6;
import java.util.Scanner;

public class Main {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Inserisci il nickname del giocatore1: ");
        String giocatore1 = sc.nextLine();
        System.out.println("Inserisci il nickname del giocatore2: ");
        String giocatore2 = sc.nextLine();
        Tris tr = new Tris(giocatore1,giocatore2,sc);
        tr.gioca();
        sc.close();
    }
}
