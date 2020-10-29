package it.corsobackendtree.esercizi7.classificaseriea;

import it.corsobackendtree.esercizi7.classificaseriea.classi.Classifica;
import it.corsobackendtree.esercizi7.classificaseriea.classi.Giocatore;
import it.corsobackendtree.esercizi7.classificaseriea.classi.Squadra;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //testSemplice();
        testPrimaGiornata();
    }

    private static Classifica init(){
        String[] nomi = new String[]{ "Juventus","Milan","Inter","Roma",
                "Napoli","Lazio","Atalanta","Genoa","Fiorentina",
                "Sampdoria","Verona","Torino","Sassuolo","Cagliari",
                "Bologna","Udinese","Parma","Spezia","Benevento","Crotone"
        };
        Squadra[] squadreSerieA = new Squadra[20];
        for(int i=0; i<20; i++){
            squadreSerieA[i] = new Squadra(nomi[i], new Giocatore[]{});
        }
        return new Classifica(squadreSerieA);
    }

    private static void printClassifica(Classifica classificaSerieA){
        Squadra[] squadre = classificaSerieA.getClassifica();
        for(int i=0; i<squadre.length; i++){
            System.out.println((i+1)+"a "+squadre[i]);
        }
    }

    private static void testSemplice(){
        Classifica classificaSerieA =init();
        Squadra juventus = classificaSerieA.getSquadra("Juventus");
        Squadra roma = classificaSerieA.getSquadra("Roma");
        classificaSerieA.esitoPartita(juventus,1,roma,3);

        Squadra napoli = classificaSerieA.getSquadra("Napoli");
        Squadra inter = classificaSerieA.getSquadra("Inter");
        classificaSerieA.esitoPartita(napoli,1,inter,0);

        Squadra[] squadre = classificaSerieA.getClassifica();
        for(int i=0; i<squadre.length; i++){
            System.out.println((i+1)+"a "+squadre[i]);
        }
        printClassifica(classificaSerieA);
    }

    private static void testPrimaGiornata(){
        Scanner sc = new Scanner(System.in);
        Classifica classificaSerieA =init();
        Squadra[] classifica = classificaSerieA.getClassifica();
        int tempGolCasa;
        int tempGolOspite;
        for(int i=0; i<20; i+=2){
            System.out.println("Inserisci il risultato per "+classifica[i].getNome()+"-"+classifica[i+1].getNome());
            System.out.println(classifica[i].getNome()+": ");
            tempGolCasa = sc.nextInt();
            System.out.println(classifica[i+1].getNome()+": ");
            tempGolOspite = sc.nextInt();
            classificaSerieA.esitoPartita(classifica[i],tempGolCasa,classifica[i+1],tempGolOspite);
        }
        printClassifica(classificaSerieA);
    }
}
