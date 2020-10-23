package it.corsobackendtree.esercizi5.lampadinav2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Lampadina[] lampadine = new Lampadina[]{
                new Lampadina(5, false),
                new Lampadina(6, true),
                new Lampadina(3, true)
        };

        /* Creo un nuovo quadro elettrico a cui sono collegate le 3 lampadine precedentemente create,
         la corrente delle lampadine sarà ora uguale alla corrente del quadro elettrico (false in questo caso). */
        QuadroElettrico qe = new QuadroElettrico(lampadine, false);
        /* Do ora corrente a tutto l'impianto */
        qe.switchOn();
        /* Monto due interruttori sulla seconda lampadina */
        Interruttore interruttore1 = new Interruttore(lampadine[1]);
        Interruttore interruttore2 = new Interruttore(lampadine[1]);

        /*La terza lampadina è stata spenta quando l'ho collegata al QE*/
        System.out.println("\nTEST ROTTURA TERZA LAMPADINA (limite click 3)");
        System.out.println("Stato iniziale terza lampadina:" + lampadine[2].stato());
        /*Ora rompo la terza lampadina*/
        for (int i = 1; i <= 4; i++) {
            lampadine[2].click();
            System.out.println("Stato lampadina:" + lampadine[2].stato() + " Numero click:" + i);
        }

        /* Ora, se vuoi, potrai testare i due interruttori collegati alla seconda lampadina. */
        testLampadinaUtente(interruttore1, interruttore2);

        /*
        Ora testo lo switchOff della corrente del QE provando a cliccare 5 volte
        un interruttore collegato alla prima lampadina, togliendo la corrente dopo il secondo click
        e facendola tornare al quinto click
        */
        System.out.println("\nTEST SWITCHOFF/ON CORRENTE LAMPADINA 1");
        for (int i = 1; i <= 5; i++) {
            if (i == 3) {
                qe.switchOff();
                System.out.println("È andata via la corrente!!!");
            }else if(i == 5){
                qe.switchOn();
                System.out.println("È tornata la corrente!!!");
            }
            lampadine[0].click();
            System.out.println("Stato lampadina1:" + lampadine[0].stato() + " Numero click:" + (i));
        }

        /*
        Ora testo lo switchOff della corrente del QE provando a cliccare 3 volte
        un interruttore collegato alla terza lampadina che è stata già rotta,
        togliendo la corrente dopo il primo click e facendola tornare al terzo click
        */
        System.out.println("\nTEST SWITCHOFF/ON CORRENTE LAMPADINA 3 (ROTTA)");
        for (int i = 1; i <= 3; i++) {
            if (i == 2) {
                qe.switchOff();
                System.out.println("È andata via la corrente!!!");
            }else if(i == 3){
                qe.switchOn();
                System.out.println("È tornata la corrente!!!");
            }
            lampadine[2].click();
            System.out.println("Stato lampadina1:" + lampadine[2].stato() + " Numero click:" + (i));
        }
    }

    private static void testLampadinaUtente(Interruttore interruttore1, Interruttore interruttore2) {
        System.out.println("\nTEST INTERRUTTORI");
        System.out.println("Stato iniziale seconda lampadina:" + interruttore1.getLampadina().stato()+"\n");
        Scanner sc = new Scanner(System.in);
        int click = 0;
        while (true) {
            System.out.print("Inserisci: 1 per il primo interruttore o 2 per il secondo.\n" +
                    "(Esci inserendo un qualunque altro carattere o stringa)\n");
            try {
                int a = sc.nextInt();
                if (a == 1) {
                    interruttore1.clickInterruttore();
                } else if (a == 2) {
                    interruttore2.clickInterruttore();
                } else {
                    break;
                }
                System.out.println("Stato seconda lampadina:" + interruttore1.getLampadina().stato() + " Numero click:" + ++click);
            } catch (InputMismatchException e) {
                break;
            }
        }
    }
}
