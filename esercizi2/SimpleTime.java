package it.corsobackendtree.esercizi2;

import java.util.Scanner;

public class SimpleTime {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Inserisci un numero di secondi: ");
        long secondi =sc.nextLong();
        SimpleTime st = new SimpleTime();
        String toPrint = st.daysHMS(secondi);
        System.out.println(toPrint);
        /*
        172800 => 2Giorni
        172960 => 2Giorni 2Minuti 40Secondi
        */
    }

    private String daysHMS(long secondi){
        if(secondi < 0) return "Il numero di secondi deve essere positivo!";
        long giorni = secondi/(24*60*60);
        secondi %= 24*60*60;
        long ore = secondi/(60*60);
        secondi %= 60*60;
        long minuti = secondi/60;
        secondi %= 60;
        return "Giorni:"+giorni+" Ore:"+ore+" Minuti:"+minuti+" Secondi:"+secondi;
    }
}
