package it.corsobackendtree.esercizi3;

public class CercaParole {
    public static void main(String[] args) {
        CercaParole cp = new CercaParole();
        char[][] cruciPuzzle = new char[][]{
                {'h', 'd', 'g', 'u', 'p', 'y', 's', 'p', 'a', 'o'},
                {'t', 's', 'a', 'k', 'o', 'y', 'o', 'l', 'p', 's'},
                {'r', 'c', 'm', 'c', 'n', 'r', 'i', 'a', 'a', 'b'},
                {'i', 'o', 'b', 'a', 'i', 's', 'c', 't', 'l', 'a'},
                {'g', 'r', 'e', 'l', 'f', 'a', 'c', 'e', 'o', 'l'},
                {'l', 'f', 'r', 'a', 'l', 'l', 'u', 's', 'i', 'e'},
                {'i', 'a', 'e', 'm', 'e', 'm', 'l', 's', 'l', 'n'},
                {'a', 'n', 't', 'a', 'd', 'o', 'c', 'a', 'g', 'a'},
                {'j', 'o', 't', 'r', 'b', 'n', 'd', 'g', 'o', 'd'},
                {'l', 'y', 'o', 'o', 'u', 'e', 's', 'm', 's', 'm'}
        };
        cp.printPuzzle(cruciPuzzle);

        cp.trovaParola(cruciPuzzle, "LUCCIO");
        System.out.println("---------");
        cp.trovaParola(cruciPuzzle, "DELFINO");
        System.out.println("---------");
        cp.trovaParola(cruciPuzzle, "SALMONE");
        System.out.println("---------");
        cp.trovaParola(cruciPuzzle, "CALAMARO");
        System.out.println("---------");
        cp.trovaParola(cruciPuzzle, "GAMBERETTO");
        System.out.println("---------");
        cp.trovaParola(cruciPuzzle, "BALENA");
        System.out.println("---------");
        cp.trovaParola(cruciPuzzle, "SOGLIOLA");
        System.out.println("---------");
        cp.trovaParola(cruciPuzzle, "SCORFANO");
        System.out.println("---------");
        cp.trovaParola(cruciPuzzle, "TRIGLIA");
        System.out.println("---------");
        cp.trovaParola(cruciPuzzle, "PLATESSA");
    }

    private void printPuzzle(char[][] puzzle) {
        for (int i = 0; i < puzzle.length; i++) {
            for (int j = 0; j < puzzle[0].length; j++) {
                System.out.print("\t" + puzzle[i][j]);
            }
            System.out.print("\n");
        }
    }

    private boolean trovaParola(char[][] puzzle, String parola) {
        if (parola.length() < 2) return false; /*La parola da ricercare deve avere almeno due caratteri*/
        parola = parola.toLowerCase();
        int wordLength = parola.length();
        for (int i = 0; i < puzzle.length; i++) {
            for (int j = 0; j < puzzle[0].length; j++) {
                if (puzzle[i][j] == parola.charAt(0)) {
                    /*LEFTUP*/
                    if (i>0 && j>0 && puzzle[i - 1][j - 1] == parola.charAt(1)) {
                        if((i - wordLength +1) >= 0 && (j - wordLength +1) >= 0){
                            int ind = 1;
                            while (ind<wordLength && puzzle[i - ind][j - ind] == parola.charAt(ind)) {
                                ind++;
                            }
                            if (ind == wordLength) {
                                System.out.println("PAROLA: "+parola+"\nDIREZIONE: leftUp\nInizio: i=" + i + " j=" + j);
                                return true;
                            }
                        }
                    }
                    /*UP*/
                    if(i>0 && puzzle[i - 1][j]  == parola.charAt(1)){
                        if((i - wordLength +1) >= 0){
                            int ind = 1;
                            while (ind<wordLength && puzzle[i - ind][j] == parola.charAt(ind)) {
                                ind++;
                            }
                            if (ind == wordLength) {
                                System.out.println("PAROLA: "+parola+"\nDIREZIONE: Up\nInizio: i=" + i + " j=" + j);
                                return true;
                            }
                        }
                    }
                    /*RIGHTUP*/
                    if((i > 0 && (j < puzzle[0].length-1) && (puzzle[i - 1][j + 1] == parola.charAt(1)))){
                        if((i - wordLength +1) >= 0 && (j + wordLength -1) <= puzzle[0].length-1){
                            int ind = 1;
                            while (ind<wordLength && puzzle[i - ind][j + ind] == parola.charAt(ind)) {
                                ind++;
                            }
                            if (ind == wordLength) {
                                System.out.println("PAROLA: "+parola+"\nDIREZIONE: rigthUp\nInizio: i=" + i + " j=" + j);
                                return true;
                            }
                        }
                    }
                    /*LEFT*/
                    if (j>0 && puzzle[i][j - 1] == parola.charAt(1)) {
                        if((j - wordLength +1) >= 0){
                            int ind = 1;
                            while (ind<wordLength && puzzle[i][j - ind] == parola.charAt(ind)) {
                                ind++;
                            }
                            if (ind == wordLength) {
                                System.out.println("PAROLA: "+parola+"\nDIREZIONE: left\nInizio: i=" + i + " j=" + j);
                                return true;
                            }
                        }
                    }
                    /*RIGHT*/
                    if ((j < puzzle[0].length-1) && puzzle[i][j + 1] == parola.charAt(1)) {
                        if((j + wordLength -1) <= puzzle[0].length-1){
                            int ind = 1;
                            while (ind<wordLength && puzzle[i][j + ind] == parola.charAt(ind)) {
                                ind++;
                            }
                            if (ind == wordLength) {
                                System.out.println("PAROLA: "+parola+"\nDIREZIONE: right\nInizio: i=" + i + " j=" + j);
                                return true;
                            }
                        }
                    }
                    /*LEFTDOWN*/
                    if ((i < puzzle.length-1) && j>0 && puzzle[i + 1][j - 1] == parola.charAt(1)) {
                        if((i + wordLength -1) <= puzzle.length-1 && (j - wordLength +1) >= 0){
                            int ind = 1;
                            while (ind<wordLength && puzzle[i + ind][j - ind] == parola.charAt(ind)) {
                                ind++;
                            }
                            if (ind == wordLength) {
                                System.out.println("PAROLA: "+parola+"\nDIREZIONE: leftDown\nInizio: i=" + i + " j=" + j);
                                return true;
                            }
                        }
                    }
                    /*DOWN*/
                    if ((i < puzzle.length-1) && puzzle[i + 1][j] == parola.charAt(1)) {
                        if((i + wordLength -1) <= puzzle.length-1){
                            int ind = 1;
                            while (ind<wordLength && puzzle[i + ind][j] == parola.charAt(ind)) {
                                ind++;
                            }
                            if (ind == wordLength) {
                                System.out.println("PAROLA: "+parola+"\nDIREZIONE: Down\nInizio: i=" + i + " j=" + j);
                                return true;
                            }
                        }
                    }
                    /*RIGHTDOWN*/
                    if ((i < puzzle.length-1) && (j < puzzle[0].length-1) && puzzle[i + 1][j + 1] == parola.charAt(1)) {
                        if((i + wordLength -1) <= puzzle.length-1 && (j + wordLength -1) <= puzzle[0].length-1){
                            int ind = 1;
                            while (ind<wordLength && puzzle[i + ind][j+ ind] == parola.charAt(ind)) {
                                ind++;
                            }
                            if (ind == wordLength) {
                                System.out.println("PAROLA: "+parola+"\nDIREZIONE: rightDown\nInizio: i=" + i + " j=" + j);
                                return true;
                            }
                        }
                    }
                }
            }
        }
        System.out.println("Parola non trovata!");
        return false;
    }
}
