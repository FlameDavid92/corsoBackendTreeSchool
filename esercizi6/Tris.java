package it.corsobackendtree.esercizi6;

import java.util.Random;
import java.util.Scanner;

public class Tris {
    ValoreTris[][] scacchiera;
    int nPosizioniDisponibili;
    String[] giocatori;
    int[] simboloGiocatori;
    int currentPlayer;
    Scanner sc;
    Random rndm;

    public Tris(String nomeGiocatore1, String nomeGiocatore2) {
        this.giocatori = new String[2];
        this.giocatori[0] = nomeGiocatore1;
        this.giocatori[1] = nomeGiocatore2;
        this.inizializzaNuovoGioco();
    }

    public void printGame() {
        System.out.print("\n");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("  " + ((this.scacchiera[i][j] == ValoreTris.VOID) ? "-" : this.scacchiera[i][j]));
            }
            System.out.print("\n");
        }
    }

    public void inizializzaNuovoGioco() {
        this.scacchiera = new ValoreTris[3][3];
        this.nPosizioniDisponibili = 9;
        this.sc = new Scanner(System.in);
        this.rndm = new Random();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                this.scacchiera[i][j] = ValoreTris.VOID;
            }
        }
        this.scegliSimbolo(this.giocatori[0]);
        this.currentPlayer = rndm.nextInt(2);
    }

    public void scegliSimbolo(String giocatore1) {
        this.simboloGiocatori = new int[2];
        System.out.println(giocatore1 + " scegli il simbolo con cui vuoi giocare." +
                "\nInserisci 0 per O , 1 per X, 999 per uscire dal gioco: ");
        int input = -1;
        while (input != 0 && input != 1 && input != 999) {
            try {
                input = sc.nextInt();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (input == 999) {
            terminaGioco(true);
        } else {
            this.simboloGiocatori[0] = input;
            this.simboloGiocatori[1] = (input == 0) ? 1 : 0;
        }
    }

    public void gioca() {
        if (nPosizioniDisponibili != 0) {
            boolean game = true;
            while (game) {
                System.out.println("\nÈ il turno di " + giocatori[currentPlayer] + "." +
                        "\nIl tuo simbolo è " + ((this.simboloGiocatori[currentPlayer] == 0) ? "O" : "X") + ".");
                System.out.println("Posizioni disponibili: ");
                this.printGame();
                System.out.println("Inserisci gli indici di riga e colonna (i e j) corrispondenti ad una casella vuota" +
                        "\n(Inserisci 999 per uscire dal gioco).");
                int row = -1;
                int column = -1;
                boolean check = true;
                while (check && row != 999 && column != 999) {
                    try {
                        System.out.print("\ni: ");
                        row = sc.nextInt();
                        System.out.print("j: ");
                        column = sc.nextInt();

                        if (row < 3 && column < 3 && this.scacchiera[row][column] == ValoreTris.VOID) {
                            this.scacchiera[row][column] = (this.simboloGiocatori[this.currentPlayer] == 0) ? ValoreTris.O : ValoreTris.X;
                            check = false;
                        } else throw new Exception();

                    } catch (Exception e) {
                        System.out.print("\nIndici inseriti non corretti, riprova!");
                    }
                }
                System.out.println("----------------------");
                if (row == 999 || column == 999) game = terminaGioco(true);
                else {
                    this.nPosizioniDisponibili--;
                    game = this.controllaTris();
                    this.currentPlayer = (currentPlayer == 0) ? 1 : 0;
                }
            }
        }else{
            this.inizializzaNuovoGioco();
            this.gioca();
        }
    }

    public boolean controllaTris() {
        if (
                this.scacchiera[0][0] != ValoreTris.VOID && (this.scacchiera[0][0] == this.scacchiera[1][1] && this.scacchiera[0][0] == this.scacchiera[2][2]) ||
                this.scacchiera[0][0] != ValoreTris.VOID && (this.scacchiera[0][0] == this.scacchiera[0][1] && this.scacchiera[0][0] == this.scacchiera[0][2]) ||
                this.scacchiera[0][0] != ValoreTris.VOID && (this.scacchiera[0][0] == this.scacchiera[1][0] && this.scacchiera[0][0] == this.scacchiera[2][0]) ||
                this.scacchiera[0][1] != ValoreTris.VOID && (this.scacchiera[0][1] == this.scacchiera[1][1] && this.scacchiera[0][1] == this.scacchiera[2][1]) ||
                this.scacchiera[0][2] != ValoreTris.VOID && (this.scacchiera[0][2] == this.scacchiera[1][2] && this.scacchiera[0][2] == this.scacchiera[2][2]) ||
                this.scacchiera[1][0] != ValoreTris.VOID && (this.scacchiera[1][0] == this.scacchiera[1][1] && this.scacchiera[1][0] == this.scacchiera[1][2]) ||
                this.scacchiera[2][0] != ValoreTris.VOID && (this.scacchiera[2][0] == this.scacchiera[2][1] && this.scacchiera[2][0] == this.scacchiera[2][2]) ||
                this.scacchiera[2][0] != ValoreTris.VOID && (this.scacchiera[2][0] == this.scacchiera[1][1] && this.scacchiera[2][0] == this.scacchiera[0][2])
        ) {
            System.out.println("\n"+this.giocatori[currentPlayer] + " hai vinto il gioco!");
            return terminaGioco(false);
        }

        if (this.nPosizioniDisponibili == 0) {
            System.out.println("Gioco concluso in parità.");
            return terminaGioco(false);
        }
        return true;
    }

    public boolean terminaGioco(boolean op) {
        if(op) System.out.println("Hai terminato il gioco senza completarlo!");
        printGame();
        nPosizioniDisponibili = 0;
        this.sc.close();
        return false;
    }
}
