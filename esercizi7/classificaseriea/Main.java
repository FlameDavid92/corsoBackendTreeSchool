package it.corsobackendtree.esercizi7.classificaseriea;

import it.corsobackendtree.esercizi7.classificaseriea.classi.Classifica;
import it.corsobackendtree.esercizi7.classificaseriea.classi.Giocatore;
import it.corsobackendtree.esercizi7.classificaseriea.classi.Squadra;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String[] nomi = new String[]{ "Juventus","Milan","Inter","Roma",
                "Napoli","Lazio","Atalanta","Genoa","Fiorentina",
                "Sampdoria","Verona","Torino","Sassuolo","Cagliari",
                "Bologna","Udinese","Parma","Spezia","Benevento","Crotone"
        };
        Squadra[] squadreSerieA = new Squadra[20];
        for(int i=0; i<20; i++){
            squadreSerieA[i] = new Squadra(nomi[i], new Giocatore[]{});
        }
        Classifica classificaSerieA = new Classifica(squadreSerieA);

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

    }

}
