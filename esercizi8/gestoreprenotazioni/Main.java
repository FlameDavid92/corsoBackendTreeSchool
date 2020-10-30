package it.corsobackendtree.esercizi8.gestoreprenotazioni;

import it.corsobackendtree.esercizi8.gestoreprenotazioni.classi.*;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //test1();
        test2();
    }

    public static void test1(){
        MiniGestorePrenotazioni miniGestorePrenotazioni = new MiniGestorePrenotazioni(3, 5);
        Prenotazione p1 = new PrenotazioneSingola("12", Preferenza.ESTERNO);
        Prenotazione p2 = new PrenotazioneSingola("23", Preferenza.ESTERNO);
        Prenotazione p3 = new PrenotazioneSingola("34", Preferenza.INTERNO);
        Prenotazione p4 = new PrenotazioneSingola("56", Preferenza.ESTERNO);
        miniGestorePrenotazioni.prenota(p1);
        miniGestorePrenotazioni.prenota(p2);
        miniGestorePrenotazioni.prenota(p3);
        miniGestorePrenotazioni.prenota(p4);

        Prenotazione[] prenotazioniInternoArray = miniGestorePrenotazioni.prenotazioniAttualiInterno();
        Prenotazione[] prenotazioniEsternoArray = miniGestorePrenotazioni.prenotazioniAttualiEsterno();
        int prenotazioniInterno = 0, prenotazioniEsterno = 0;
        //contiamo e togliamo i null se presenti
        for (int i = 0; i < prenotazioniInternoArray.length; i++)
            if (prenotazioniInternoArray[i] != null) {
                prenotazioniInterno++;
            }
        for (int i = 0; i < prenotazioniEsternoArray.length; i++)
            if (prenotazioniEsternoArray[i] != null) {
                prenotazioniEsterno++;
            }
        System.out.println(prenotazioniInterno == 1);
        System.out.println(prenotazioniEsterno == 3);
        Prenotazione p5 = new PrenotazioneGruppo("45", 2);
        boolean a = miniGestorePrenotazioni.prenota(p5);
        prenotazioniInterno = 0;
        prenotazioniEsterno = 0;
        //contiamo e togliamo i null se presenti
        for (int i = 0; i < prenotazioniInternoArray.length; i++)
            if (prenotazioniInternoArray[i] != null) {
                prenotazioniInterno++;
            }
        for (int i = 0; i < prenotazioniEsternoArray.length; i++)
            if (prenotazioniEsternoArray[i] != null) {
                prenotazioniEsterno++;
            }
        System.out.println(prenotazioniInterno + prenotazioniEsterno == 5);
        //verifichiamo i posti effettivamente riservati
        int postiTotali = 0;
        for (int i = 0; i < prenotazioniInternoArray.length; i++)
            if (prenotazioniInternoArray[i] != null) {
                postiTotali += prenotazioniInternoArray[i].getNumeroPosti();
            }
        for (int i = 0; i < prenotazioniEsternoArray.length; i++)
            if (prenotazioniEsternoArray[i] != null) {
                postiTotali += prenotazioniEsternoArray[i].getNumeroPosti();
            }
        System.out.println(postiTotali == 6);
        Prenotazione p6 = new PrenotazioneSingola("67", Preferenza.ESTERNO);
        boolean inserita = miniGestorePrenotazioni.prenota(p6);
        System.out.println(inserita);
    }

    public static void test2(){
        MiniGestorePrenotazioni miniGestorePrenotazioni = new MiniGestorePrenotazioni(4, 2);
        Prenotazione p1 = new PrenotazioneSingola("12", Preferenza.INTERNO);
        Prenotazione p2 = new PrenotazioneSingola("23", Preferenza.INTERNO);
        PrenotazioneGruppo p3 = new PrenotazioneGruppo("56",2);
        Prenotazione p4 = new PrenotazioneSingola("24", Preferenza.INTERNO);

        System.out.println(miniGestorePrenotazioni.prenota(p1));
        System.out.println(miniGestorePrenotazioni.prenota(p2));
        System.out.println(miniGestorePrenotazioni.prenota(p3));
        System.out.println(miniGestorePrenotazioni.prenota(p4));

        System.out.println("Prenotazioni interno: "+Arrays.toString(miniGestorePrenotazioni.prenotazioniAttualiInterno()));
        System.out.println("Prenotazioni esterno: "+Arrays.toString(miniGestorePrenotazioni.prenotazioniAttualiEsterno()));

        miniGestorePrenotazioni.terminaPrenotazione(p3);
        System.out.println("-----");
        System.out.println("Prenotazioni interno: "+Arrays.toString(miniGestorePrenotazioni.prenotazioniAttualiInterno()));
        System.out.println("Prenotazioni esterno: "+Arrays.toString(miniGestorePrenotazioni.prenotazioniAttualiEsterno()));

    }
}
