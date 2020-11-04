package it.corsobackendtree.esercizi10.labirinto2.classi;

import java.util.ArrayList;
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

    private enum StatoPostMossa { FINE, MOSSA, ERRORE }

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
        } while ((labirinto[posXMostro][posYMostro] instanceof Muro) || ((posXGiocatore == posXMostro) && (posYGiocatore == posYMostro)));
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
                if (i == mostro.posX && j == mostro.posY) {
                    System.out.print("\t" + mostro);
                } else if (i == giocatore.posX && j == giocatore.posY) {
                    System.out.print("\t" + giocatore);
                } else {
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

    private StatoPostMossa muoviGiocatore(char op) {
        EntitaLabirinto temp = null;
        switch (op) {
            case 'W':
                if (giocatore.posX > 0) {
                    temp = labirinto[giocatore.posX - 1][giocatore.posY];
                    if (!(temp instanceof Muro) && !((mostro.posX == giocatore.posX - 1) && (mostro.posY == giocatore.posY))) {
                        giocatore.posXminus();
                    } else {
                        System.out.println("Non puoi muoverti su un muro o sul mostro!");
                        return StatoPostMossa.ERRORE;
                    }
                } else{
                    System.out.println("Puoi uscire dal labirinto solo dall'uscita :P !!!");
                    return StatoPostMossa.ERRORE;
                }
                break;
            case 'S':
                if (giocatore.posX < nRighe - 1) {
                    temp = labirinto[giocatore.posX + 1][giocatore.posY];
                    if (!(temp instanceof Muro) && !((mostro.posX == giocatore.posX + 1) && (mostro.posY == giocatore.posY))) {
                        giocatore.posXplus();
                    } else {
                        System.out.println("Non puoi muoverti su un muro o sul mostro!");
                        return StatoPostMossa.ERRORE;
                    }
                } else {
                    System.out.println("Puoi uscire dal labirinto solo dall'uscita :P !!!");
                    return StatoPostMossa.ERRORE;
                }
                break;
            case 'A':
                if (giocatore.posY > 0) {
                    temp = labirinto[giocatore.posX][giocatore.posY - 1];
                    if (!(temp instanceof Muro) && !((mostro.posX == giocatore.posX) && (mostro.posY == giocatore.posY - 1))) {
                        giocatore.posYminus();
                    } else {
                        System.out.println("Non puoi muoverti su un muro o sul mostro!");
                        return StatoPostMossa.ERRORE;
                    }
                } else {
                    System.out.println("Puoi uscire dal labirinto solo dall'uscita :P !!!");
                    return StatoPostMossa.ERRORE;
                }
                break;
            case 'D':
                if (giocatore.posY < nColonne - 1) {
                    temp = labirinto[giocatore.posX][giocatore.posY + 1];
                    if (!(temp instanceof Muro) && !((mostro.posX == giocatore.posX) && (mostro.posY == giocatore.posY + 1))) {
                        giocatore.posYplus();
                    } else {
                        System.out.println("Non puoi muoverti su un muro o sul mostro!");
                        return StatoPostMossa.ERRORE;
                    }
                } else {
                    System.out.println("Puoi uscire dal labirinto solo dall'uscita :P !!!");
                    return StatoPostMossa.ERRORE;
                }
                break;
            case 'X':
                return StatoPostMossa.FINE;
            default:
                System.out.println("Mossa non riconosciuta!");
                return StatoPostMossa.ERRORE;
        }

        if (temp instanceof Vortice) {
            int index;
            do {
                index = rndm.nextInt(vortici.length);
            } while (vortici[index].equals(temp));

            System.out.println("Sei entrato nel vorticeeee@@@@@");
            giocatore.setPosX(vortici[index].posX);
            giocatore.setPosY(vortici[index].posY);
        } else if (temp instanceof Uscita) {
            System.out.println("Hai vintoooo!!!");
            return StatoPostMossa.FINE;
        }
        return StatoPostMossa.MOSSA;
    }

    /*Un mostro non può teletrasportarsi sui vortici!!!*/
    private boolean muoviMostro() {
        if (mostro.posX > giocatore.posX && labirinto[mostro.posX - 1][mostro.posY] instanceof SpazioVuoto) {
            mostro.posXminus();
        } else if (mostro.posX < giocatore.posX && labirinto[mostro.posX + 1][mostro.posY] instanceof SpazioVuoto) {
            mostro.posXplus();
        } else if (mostro.posY > giocatore.posY && labirinto[mostro.posX][mostro.posY - 1] instanceof SpazioVuoto) {
            mostro.posYminus();
        } else if (mostro.posY < giocatore.posY && labirinto[mostro.posX][mostro.posY + 1] instanceof SpazioVuoto) {
            mostro.posYplus();
        } else {
            ArrayList<int[]> ael = new ArrayList<>();
            if ((mostro.posX - 1 >= 0) && labirinto[mostro.posX - 1][mostro.posY] instanceof SpazioVuoto)
                ael.add(new int[]{mostro.posX - 1, mostro.posY});
            if ((mostro.posX + 1 < nRighe) && labirinto[mostro.posX + 1][mostro.posY] instanceof SpazioVuoto)
                ael.add(new int[]{mostro.posX + 1, mostro.posY});
            if ((mostro.posY - 1 >= 0) && labirinto[mostro.posX][mostro.posY - 1] instanceof SpazioVuoto)
                ael.add(new int[]{mostro.posX, mostro.posY - 1});
            if ((mostro.posY + 1 < nColonne) && labirinto[mostro.posX][mostro.posY + 1] instanceof SpazioVuoto)
                ael.add(new int[]{mostro.posX, mostro.posY + 1});

            if (ael.size() > 0) {
                int choice = rndm.nextInt(ael.size());
                mostro.setPosX(ael.get(choice)[0]);
                mostro.setPosY(ael.get(choice)[1]);
            } else {
                System.out.println("Che fortuna, il mostro è bloccato!");
            }
        }
        if (mostro.posX == giocatore.posX && mostro.posY == giocatore.posY) {
            System.out.println("GAME OVER! Il mostro ti ha preso!!!");
            return false;
        } else return true;
    }

    public void start() {
        System.out.println("INIZIO GIOCO\n");
        System.out.println(" W : Muro\n - : Spazio\n @ : Vortice\n E : Uscita\n § : Mostro\n\n");
        boolean printLab = true;

        while (true) {
            if(printLab) printLabirinto();
            printLab = true;

            String input = "";
            do {
                System.out.println("Inserisci un solo carattere tra W,A,S,D per muovere il giocatore o X per uscire dal gioco: ");
                input = sc.nextLine();
            } while (input.length() != 1);

            char mossa = input.toUpperCase().charAt(0);
            if (mossa == 'W' || mossa != 'A' || mossa != 'S' || mossa != 'D' || mossa != 'X') {
                StatoPostMossa spm = muoviGiocatore(mossa);
                if(spm.equals(StatoPostMossa.FINE)) break;
                else if (spm.equals(StatoPostMossa.MOSSA)) muoviMostro();
                else printLab = false;
            }else{
                System.out.println("Il carattere inserito non corrisponde a nessuna scelta!");
            }
        }

        printLabirinto();
        System.out.println("FINE GIOCO\n");
    }
}
