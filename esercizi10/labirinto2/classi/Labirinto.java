package it.corsobackendtree.esercizi10.labirinto2.classi;

import java.util.Random;
import java.util.Scanner;

public class Labirinto {
    private int nRighe;
    private int nColonne;
    private EntitaLabirinto[][] labirinto;
    private Giocatore giocatore;
    private Mostro mostro;
    private Vortice[] vortici;
    private Uscita uscita;
    private Scanner sc;
    private Random rndm;

    public Labirinto(int nRighe, int nColonne) {
        this.sc = new Scanner(System.in);
        this.nRighe = nRighe;
        this.nColonne = nColonne;
        labirinto = new EntitaLabirinto[nRighe][nColonne];
        rndm = new Random();
        double temp;
        for (int i = 0; i < nRighe; i++) {
            for (int j = 0; j < nColonne; j++) {
                temp = rndm.nextGaussian();
                if (temp >= -1 && temp <= 1) {
                    labirinto[i][j] = new SpazioVuoto(i, j);
                } else labirinto[i][j] = new Muro(i, j);
            }
        }

        int posXGiocatore;
        int posYGiocatore;
        do {
            posXGiocatore = rndm.nextInt(nRighe);
            posYGiocatore = rndm.nextInt(nColonne);
        } while (labirinto[posXGiocatore][posYGiocatore] instanceof Muro);
        giocatore = new Giocatore(posXGiocatore, posYGiocatore);

        int posXMostro;
        int posYMostro;
        do {
            posXMostro = rndm.nextInt(nRighe);
            posYMostro = rndm.nextInt(nColonne);
        } while ( (labirinto[posXMostro][posYMostro] instanceof Muro) || ((posXGiocatore == posXMostro) && (posYGiocatore == posYMostro)) );
        mostro = new Mostro(posXMostro, posYMostro);

        vortici = new Vortice[2];
        int posXVortice1;
        int posYVortice1;
        do {
            posXVortice1 = rndm.nextInt(nRighe);
            posYVortice1 = rndm.nextInt(nColonne);
        } while (((posXGiocatore == posXVortice1) && (posYGiocatore == posYVortice1)) ||
                ((posXMostro == posXVortice1) && (posYMostro == posYVortice1)));
        vortici[0] = new Vortice(posXVortice1, posYVortice1);
        labirinto[posXVortice1][posYVortice1] = vortici[0];

        int posXVortice2;
        int posYVortice2;
        do {
            posXVortice2 = rndm.nextInt(nRighe);
            posYVortice2 = rndm.nextInt(nColonne);
        } while (((posXGiocatore == posXVortice2) && (posYGiocatore == posYVortice2)) ||
                ((posXMostro == posXVortice2) && (posYMostro == posYVortice2)) ||
                ((posXVortice1 == posXVortice2) && (posYVortice1 == posYVortice2)));
        vortici[1] = new Vortice(posXVortice2, posYVortice2);
        labirinto[posXVortice2][posYVortice2] = vortici[1];

        int posXUscita;
        int posYUscita;
        do {
            posXUscita = rndm.nextInt(nRighe);
            posYUscita = rndm.nextInt(nColonne);
        } while (((posXGiocatore == posXUscita) && (posYGiocatore == posYUscita)) ||
                ((posXMostro == posXUscita) && (posYMostro == posYUscita)) ||
                ((posXVortice1 == posXUscita) && (posYVortice1 == posYUscita)) ||
                ((posXVortice2 == posXUscita) && (posYVortice2 == posYUscita)));
        uscita = new Uscita(posXUscita, posYUscita);
        labirinto[posXUscita][posYUscita] = uscita;
    }

    public void printLabirinto() {
        for (int i = 0; i < nRighe; i++) {
            for (int j = 0; j < nColonne; j++) {
                if (i == giocatore.posX && j == giocatore.posY) {
                    System.out.print("\t" + giocatore);
                }else if(i == mostro.posX && j == mostro.posY){
                    System.out.print("\t" + mostro);
                }else {
                    System.out.print("\t" + labirinto[i][j]);
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    private int getnRighe() {
        return nRighe;
    }

    private int getnColonne() {
        return nColonne;
    }

    /*public void switchPositionLabirinto(int posX1, int posY1, int posX2, int posY2){
        EntitaLabirinto temp = labirinto[posX1][posY1];
        labirinto[posX1][posY1] = labirinto[posX2][posY2];
        labirinto[posX2][posY2] = temp;
    }*/

    private boolean muoviGiocatore(char op) {
        EntitaLabirinto temp = null;
        switch (op) {
            case 'W':
                if (giocatore.posX > 0) {
                    temp = labirinto[giocatore.posX - 1][giocatore.posY];
                    if (!(temp instanceof Muro) && !((mostro.posX == giocatore.posX - 1)&&(mostro.posY == giocatore.posY))) {
                        giocatore.posXminus();
                    } else {
                        System.out.println("Non puoi muoverti su un muro o sul mostro!");
                    }
                } else System.out.println("Puoi uscire dal labirinto solo dall'uscita :P !!!");
                break;
            case 'S':
                if (giocatore.posX < nRighe - 1) {
                    temp = labirinto[giocatore.posX + 1][giocatore.posY];
                    if (!(temp instanceof Muro) && !((mostro.posX == giocatore.posX + 1)&&(mostro.posY == giocatore.posY))) {
                        giocatore.posXplus();
                    } else {
                        System.out.println("Non puoi muoverti su un muro o sul mostro!");
                    }
                } else System.out.println("Puoi uscire dal labirinto solo dall'uscita :P !!!");
                break;
            case 'A':
                if (giocatore.posY > 0) {
                    temp = labirinto[giocatore.posX][giocatore.posY - 1];
                    if (!(temp instanceof Muro) && !((mostro.posX == giocatore.posX)&&(mostro.posY == giocatore.posY-1))) {
                        giocatore.posYminus();
                    } else {
                        System.out.println("Non puoi muoverti su un muro o sul mostro!");
                    }
                } else System.out.println("Puoi uscire dal labirinto solo dall'uscita :P !!!");
                break;
            case 'D':
                if(giocatore.posY < nColonne-1){
                    temp = labirinto[giocatore.posX][giocatore.posY + 1];
                    if (!(temp instanceof Muro) && !((mostro.posX == giocatore.posX)&&(mostro.posY == giocatore.posY+1))) {
                        giocatore.posYplus();
                    } else {
                        System.out.println("Non puoi muoverti su un muro o sul mostro!");
                    }
                } else System.out.println("Puoi uscire dal labirinto solo dall'uscita :P !!!");
                break;
            case 'X':
                return false;
            default:
                System.out.println("Mossa non riconosciuta!");
        }

        if(temp instanceof Vortice){
            int index;
            do{
                index = rndm.nextInt(vortici.length);
            }while(vortici[index].equals(temp));

            System.out.println("Sei entrato nel vorticeeee@@@@@");
            giocatore.setPosX(vortici[index].posX);
            giocatore.setPosY(vortici[index].posY);
        }else if(temp instanceof Uscita){
            System.out.println("Hai vintoooo!!!");
            return false;
        }
        return true;
    }

    private boolean muoviMostro(){
        if(mostro.posX > giocatore.posX && labirinto[mostro.posX-1][mostro.posY] instanceof SpazioVuoto){
            mostro.posXminus();
        }else if(mostro.posX < giocatore.posX && labirinto[mostro.posX+1][mostro.posY] instanceof SpazioVuoto){
            mostro.posXplus();
        }else if(mostro.posY > giocatore.posY && labirinto[mostro.posX][mostro.posY-1] instanceof SpazioVuoto){
            mostro.posYminus();
        }else if(mostro.posY > giocatore.posY && labirinto[mostro.posX][mostro.posY+1] instanceof SpazioVuoto){
            mostro.posYplus();
        }

        if(mostro.posX == giocatore.posX && mostro.posY == giocatore.posY){
            System.out.println("GAME OVER! Il mostro ti ha preso!!!");
            return false;
        }else return true;
    }

    public void start(){
        System.out.println("INIZIO GIOCO\n");
        boolean game = true;
        while(game){
            printLabirinto();
            System.out.println("Inserisci un carattere tra W,A,S,D per muovere il giocatore o X per uscire dal gioco: ");
            char mossa = sc.nextLine().toUpperCase().charAt(0);
            game = muoviGiocatore(mossa);
            if(game) game = muoviMostro();
        }
        printLabirinto();
        System.out.println("FINE GIOCO\n");
    }
}