package it.corsobackendtree.esercizi17.arcaderank;

import it.corsobackendtree.esercizi17.arcaderank.classi.ArcadeRank;
import it.corsobackendtree.esercizi17.arcaderank.classi.Difficolta;
import it.corsobackendtree.esercizi17.arcaderank.classi.Utente;
import it.corsobackendtree.esercizi17.arcaderank.classi.Videogioco;

public class Main {
    public static void main(String[] args) {

        ArcadeRank ar = ArcadeRank.getInstance();
        Utente flamedavid92 = ar.inserisciUtente("flamedavid92");
        Utente pippo = ar.inserisciUtente("pippo");
        Utente pluto = ar.inserisciUtente("pluto");
        Utente paperino = ar.inserisciUtente("paperino");
        Utente topolino = ar.inserisciUtente("topolino");

        Videogioco bubbleBobble = ar.inserisciVideogioco("Bubble Bobble", Difficolta.DUE);
        Videogioco pacman = ar.inserisciVideogioco("Pac-Man", Difficolta.TRE);
        Videogioco tetris = ar.inserisciVideogioco("Tetris",Difficolta.QUATTRO);
        Videogioco metalSlug = ar.inserisciVideogioco("Metal Slug",Difficolta.CINQUE);

        System.out.println("DIFFICOLTÀ dei giochi inseriti:\nBubbleBobble:2 - PaMan:3 - Tetris:4 - MetalSlug:5");

        System.out.println("\nGIORNO1:");
        System.out.println("flamedavid92 gioca a PacMan e fa 150 punti.");
        ar.inserisciPartita(flamedavid92.getId(),pacman.getId(),150);
        System.out.println("pluto gioca a PacMan e fa 200 punti.");
        ar.inserisciPartita(pluto.getId(),pacman.getId(),200);
        System.out.println("topolino gioca a PacMan e fa 100 punti.");
        ar.inserisciPartita(topolino.getId(),pacman.getId(),100);
        System.out.println("pippo gioca a PacMan e fa 250 punti.\n");
        ar.inserisciPartita(pippo.getId(),pacman.getId(),250);

        System.out.println("CLASSIFICA VIDEOGIOCO PAC-MAN:");
        ar.printClassificaVideogioco(pacman.getId());
        System.out.println("------");
        System.out.println("CLASSIFICA GENERALE");
        ar.printClassificaGenerale();
        System.out.println("------");
        System.out.println("------");
        System.out.println("\nGIORNO2:");
        System.out.println("flamedavid92 gioca a MetalSlug e fa 200 punti.\n");
        ar.inserisciPartita(flamedavid92.getId(),metalSlug.getId(),200);
        System.out.println("CLASSIFICA VIDEOGIOCO PAC-MAN:");
        ar.printClassificaVideogioco(pacman.getId());
        System.out.println("------");
        System.out.println("CLASSIFICA VIDEOGIOCO METALSLUG:");
        ar.printClassificaVideogioco(metalSlug.getId());
        System.out.println("------");
        System.out.println("CLASSIFICA GENERALE");
        ar.printClassificaGenerale();
        System.out.println("------");
    }
}
