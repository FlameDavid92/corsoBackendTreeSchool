package it.corsobackendtree.esercizi8.gestoreprenotazioni;

import it.corsobackendtree.esercizi8.gestoreprenotazioni.classi.*;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //test1(); /*test nella specifica*/
        test2(); /*test PLUS se di default provate prima ad inserire i gruppi all'interno*/
        //test3(); /*test PLUS se di default provate prima ad inserire i gruppi all'esterno*/
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
        Prenotazione p5 = new PrenotazioneSingola("37", Preferenza.INTERNO);

        System.out.println(miniGestorePrenotazioni.prenota(p1)); //la preferenza di p1 verrà rispettata
        System.out.println(miniGestorePrenotazioni.prenota(p2)); //la preferenza di p2 verrà rispettata
        /*p3 verrà messa all'interno perché se sono disponibili posti interni la preferenza per i gruppi è all'interno*/
        System.out.println(miniGestorePrenotazioni.prenota(p3));
        /*p4 e p5 verranno messe all'esterno perché ho già tutti i posti occupati all'interno*/
        System.out.println(miniGestorePrenotazioni.prenota(p4));
        System.out.println(miniGestorePrenotazioni.prenota(p5));
        System.out.println("-----");

        Prenotazione[] prenotazioniInternoArray = miniGestorePrenotazioni.prenotazioniAttualiInterno();
        Prenotazione[] prenotazioniEsternoArray = miniGestorePrenotazioni.prenotazioniAttualiEsterno();
        int prenotazioniInterno=0, prenotazioniEsterno=0;
        for (int i = 0; i < prenotazioniInternoArray.length; i++)
            if (prenotazioniInternoArray[i] != null) {
                prenotazioniInterno++;
            }
        for (int i = 0; i < prenotazioniEsternoArray.length; i++)
            if (prenotazioniEsternoArray[i] != null) {
                prenotazioniEsterno++;
            }
        System.out.println(prenotazioniInterno == 3 && prenotazioniEsterno == 2);

        miniGestorePrenotazioni.terminaPrenotazione(p3);
        prenotazioniInterno=0;
        prenotazioniEsterno=0;
        for (int i = 0; i < prenotazioniInternoArray.length; i++)
            if (prenotazioniInternoArray[i] != null) {
                prenotazioniInterno++;
            }
        for (int i = 0; i < prenotazioniEsternoArray.length; i++)
            if (prenotazioniEsternoArray[i] != null) {
                prenotazioniEsterno++;
            }

        System.out.println(prenotazioniInterno == 4 && prenotazioniEsterno == 0);
    }

    public static void test3(){
        MiniGestorePrenotazioni miniGestorePrenotazioni = new MiniGestorePrenotazioni(2, 4);
        Prenotazione p1 = new PrenotazioneSingola("12", Preferenza.ESTERNO);
        Prenotazione p2 = new PrenotazioneSingola("23", Preferenza.ESTERNO);
        PrenotazioneGruppo p3 = new PrenotazioneGruppo("56",2);
        Prenotazione p4 = new PrenotazioneSingola("24", Preferenza.ESTERNO);
        Prenotazione p5 = new PrenotazioneSingola("37", Preferenza.ESTERNO);

        System.out.println(miniGestorePrenotazioni.prenota(p1)); //la preferenza di p1 verrà rispettata
        System.out.println(miniGestorePrenotazioni.prenota(p2)); //la preferenza di p2 verrà rispettata
        /*p3 verrà messa all'interno perché se sono disponibili posti interni la preferenza per i gruppi è all'interno*/
        System.out.println(miniGestorePrenotazioni.prenota(p3));
        /*p4 e p5 verranno messe all'esterno perché ho già tutti i posti occupati all'interno*/
        System.out.println(miniGestorePrenotazioni.prenota(p4));
        System.out.println(miniGestorePrenotazioni.prenota(p5));
        System.out.println("-----");

        Prenotazione[] prenotazioniInternoArray = miniGestorePrenotazioni.prenotazioniAttualiInterno();
        Prenotazione[] prenotazioniEsternoArray = miniGestorePrenotazioni.prenotazioniAttualiEsterno();
        int prenotazioniInterno=0, prenotazioniEsterno=0;
        for (int i = 0; i < prenotazioniInternoArray.length; i++)
            if (prenotazioniInternoArray[i] != null) {
                prenotazioniInterno++;
            }
        for (int i = 0; i < prenotazioniEsternoArray.length; i++)
            if (prenotazioniEsternoArray[i] != null) {
                prenotazioniEsterno++;
            }
        System.out.println(prenotazioniInterno == 2 && prenotazioniEsterno == 3);

        miniGestorePrenotazioni.terminaPrenotazione(p3);
        prenotazioniInterno=0;
        prenotazioniEsterno=0;
        for (int i = 0; i < prenotazioniInternoArray.length; i++)
            if (prenotazioniInternoArray[i] != null) {
                prenotazioniInterno++;
            }
        for (int i = 0; i < prenotazioniEsternoArray.length; i++)
            if (prenotazioniEsternoArray[i] != null) {
                prenotazioniEsterno++;
            }

        System.out.println(prenotazioniInterno == 0 && prenotazioniEsterno == 4);
    }
}
