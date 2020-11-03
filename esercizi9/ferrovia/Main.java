package it.corsobackendtree.esercizi9.ferrovia;

import it.corsobackendtree.esercizi9.ferrovia.classi.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        /*Percorso*/
        BinarioCapolinea binarioCapolinea = new BinarioCapolinea(20);
        BinarioSemplice binarioSemplice4 = new BinarioSemplice(binarioCapolinea);
        BinarioStazione binarioStazione2 = new BinarioStazione(19, binarioSemplice4);
        BinarioScambio binarioScambio1 = new BinarioScambio(binarioSemplice4,binarioStazione2);
        BinarioSemaforo binarioSemaforo = new BinarioSemaforo(2000,binarioScambio1);
        BinarioSemplice binarioSemplice3 = new BinarioSemplice(binarioSemaforo);
        BinarioSemplice binarioSemplice2 = new BinarioSemplice(binarioSemplice3);
        BinarioStazione binarioStazione1 = new BinarioStazione(15, binarioSemplice2);
        BinarioSemplice binarioSemplice1 = new BinarioSemplice(binarioStazione1);

        ArrayList<Porta> porteVagone1 = new ArrayList<>();
        porteVagone1.add(new Porta());
        porteVagone1.add(new Porta());
        ArrayList<Porta> porteVagone2 = new ArrayList<>();
        porteVagone2.add(new Porta());
        porteVagone2.add(new Porta());
        VagonePasseggero vagone1 = new VagonePasseggero(20, porteVagone1);
        VagonePasseggero vagone2 = new VagonePasseggero(20, porteVagone2);
        PasseggeroSemplice passeggero1 = new PasseggeroSemplice("Davide", "IT7860", vagone1.getId(), 20);
        PasseggeroSemplice passeggero2 = new PasseggeroSemplice("Giovanni", "IT7861", vagone2.getId(), 15);

        /*FRECCIA ROSSA*/
        System.out.println("FRECCIA ROSSA");
        FrecciaRossa frecciaRossa = new FrecciaRossa();
        frecciaRossa.aggiungiVagone(vagone1);
        frecciaRossa.aggiungiVagone(vagone2);

        System.out.println("TEST passeggero prova ad entrare con porte chiuse: ");
        System.out.println(!frecciaRossa.entraPasseggero(vagone1, passeggero1)+"\n");

        frecciaRossa.apriTutteLePorte();
        System.out.println("TEST passeggero1 entra nel vagone1 dopo aver aperto tutte le porte: ");
        System.out.println(frecciaRossa.entraPasseggero(vagone1, passeggero1)+"\n");

        System.out.println("TEST passeggero2 prova ad entrare dal vagone sbagliato: ");
        System.out.println(!frecciaRossa.entraPasseggero(vagone1, passeggero2)+"\n");

        System.out.println("TEST passeggero2 entra nel vagone2: ");
        System.out.println(frecciaRossa.entraPasseggero(vagone2, passeggero2)+"\n");

        System.out.println("TEST numero passeggeri: ");
        System.out.println((frecciaRossa.getNumPasseggeri()==2)+"\n");

        frecciaRossa.parti();
        Binario percorso = binarioSemplice1;
        while(percorso != null){
            if(percorso instanceof BinarioScambio) ((BinarioScambio) percorso).scambia();
            percorso = percorso.percorri(frecciaRossa);
        }

        /*TRENO REGIONALE*/
        System.out.println("\n\nTRENO REGIONALE");
        TrenoRegionale trenoRegionale = new TrenoRegionale();
        trenoRegionale.aggiungiVagone(vagone1);
        trenoRegionale.aggiungiVagone(vagone2);

        System.out.println("TEST passeggero prova ad entrare con porte chiuse: ");
        System.out.println(!trenoRegionale.entraPasseggero(vagone1, passeggero1)+"\n");

        trenoRegionale.apriTutteLePorte();
        System.out.println("TEST passeggero1 entra nel vagone1 dopo aver aperto tutte le porte: ");
        System.out.println(trenoRegionale.entraPasseggero(vagone1, passeggero1)+"\n");

        System.out.println("TEST passeggero2 prova ad entrare dal vagone sbagliato: ");
        System.out.println(!trenoRegionale.entraPasseggero(vagone1, passeggero2)+"\n");

        System.out.println("TEST passeggero2 entra nel vagone2: ");
        System.out.println(trenoRegionale.entraPasseggero(vagone2, passeggero2)+"\n");

        System.out.println("TEST numero passeggeri: ");
        System.out.println((trenoRegionale.getNumPasseggeri()==2)+"\n");

        trenoRegionale.parti();
        Binario percorso2 = binarioSemplice1;
        while(percorso2 != null){
            if(percorso2 instanceof BinarioSemaforo){
                Binario temp = percorso2;
                percorso2 = percorso2.percorri(trenoRegionale);
                if(temp == percorso2){
                    System.out.println("Il treno sta aspettando al semaforo.");
                    try {
                        Thread.sleep(((BinarioSemaforo) percorso2).getDurataMillisec());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                continue;
            }else if(percorso2 instanceof BinarioScambio) ((BinarioScambio) percorso2).scambia();

            percorso2 = percorso2.percorri(trenoRegionale);
        }
    }
}
