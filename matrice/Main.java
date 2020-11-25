package it.corsobackendtree.matrice;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        int[][] matrice = new int[2000][2000];
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("./it/corsobackendtree/matrice/Matricione _ Challenge2 _ Contest tree school_Backend 2020.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(br != null){
            String line;
            try{
                int i = 0;
                while ((line = br.readLine()) != null) {
                    int j = 0;
                    String[] splittedLine = line.split(";");
                    for(String stringInt : splittedLine){
                        matrice[i][j] = Integer.parseInt(stringInt);
                        j++;
                    }
                    i++;
                }
                br.close();
            }catch(IOException e){
                e.printStackTrace();
            }
        }

        //printMatrice(matrice);

        /*somma(matrice,0,1999,0,1999);
        System.out.println();*/

        //sommaDiagonale(matrice);

        //celleSei(matrice);

        //calcolaRidotta(matrice);
        calcolaRidotta2(matrice);
    }

    private static void somma(int[][] matrice,int startRow, int endRow, int startCol, int endCol){
        int ret = 0;
        for(int i=startRow; i<=endRow; i++) {
            for (int j = startCol; j <= endCol; j++) {
                ret += matrice[i][j];
            }
        }
        System.out.print(ret);
    }

    private static void sommaDiagonale(int[][] matrice){
        int ret = 0;
        for(int i=0; i<2000; i++){
            ret += matrice[i][i];
        }
        System.out.println(ret);
    }

    private static void celleSei(int[][] matrice){
        int ret = 0;
        for(int i=0; i<2000; i++) {
            for (int j = 0; j < 2000; j++) {
                if(matrice[i][j] == 6){
                    ret++;
                }
            }
        }
        System.out.println(ret);
    }

    private static void calcolaRidotta(int[][] matrice){

        /*riga 1*/
        int ret = 0;
        for(int i=0; i<500; i++){
            for(int j=0; j<500; j++){
                ret += matrice[i][j];
            }
        }
        System.out.print(ret +" | ");

        ret = 0;
        for(int i=0; i<500; i++){
            for(int j=500; j<1000; j++){
                ret += matrice[i][j];
            }
        }
        System.out.print(ret +" | ");

        ret = 0;
        for(int i=0; i<500; i++){
            for(int j=1000; j<1500; j++){
                ret += matrice[i][j];
            }
        }
        System.out.print(ret +" | ");

        ret = 0;
        for(int i=0; i<500; i++){
            for(int j=1500; j<2000; j++){
                ret += matrice[i][j];
            }
        }
        System.out.print(ret);
        System.out.println();

        /*riga 2*/
        ret = 0;
        for(int i=500; i<1000; i++){
            for(int j=0; j<500; j++){
                ret += matrice[i][j];
            }
        }
        System.out.print(ret +" | ");

        ret = 0;
        for(int i=500; i<1000; i++){
            for(int j=500; j<1000; j++){
                ret += matrice[i][j];
            }
        }
        System.out.print(ret +" | ");

        ret = 0;
        for(int i=500; i<1000; i++){
            for(int j=1000; j<1500; j++){
                ret += matrice[i][j];
            }
        }
        System.out.print(ret +" | ");

        ret = 0;
        for(int i=500; i<1000; i++){
            for(int j=1500; j<2000; j++){
                ret += matrice[i][j];
            }
        }
        System.out.print(ret);
        System.out.println();

        /*riga 3*/
        ret = 0;
        for(int i=1000; i<1500; i++){
            for(int j=0; j<500; j++){
                ret += matrice[i][j];
            }
        }
        System.out.print(ret +" | ");

        ret = 0;
        for(int i=1000; i<1500; i++){
            for(int j=500; j<1000; j++){
                ret += matrice[i][j];
            }
        }
        System.out.print(ret +" | ");

        ret = 0;
        for(int i=1000; i<1500; i++){
            for(int j=1000; j<1500; j++){
                ret += matrice[i][j];
            }
        }
        System.out.print(ret +" | ");

        ret = 0;
        for(int i=1000; i<1500; i++){
            for(int j=1500; j<2000; j++){
                ret += matrice[i][j];
            }
        }
        System.out.print(ret);
        System.out.println();

        /*riga 4*/

        ret = 0;
        for(int i=1500; i<2000; i++){
            for(int j=0; j<500; j++){
                ret += matrice[i][j];
            }
        }
        System.out.print(ret +" | ");

        ret = 0;
        for(int i=1500; i<2000; i++){
            for(int j=500; j<1000; j++){
                ret += matrice[i][j];
            }
        }
        System.out.print(ret +" | ");

        ret = 0;
        for(int i=1500; i<2000; i++){
            for(int j=1000; j<1500; j++){
                ret += matrice[i][j];
            }
        }
        System.out.print(ret +" | ");

        ret = 0;
        for(int i=1500; i<2000; i++){
            for(int j=1500; j<2000; j++){
                ret += matrice[i][j];
            }
        }
        System.out.print(ret);
        System.out.println();
    }

    private static void calcolaRidotta2(int[][] matrice){
        int ret;
        int size = matrice.length/4;
        for(int n=0; n<=3; n++){
            for(int m=0; m<=3; m++){
                somma(matrice,size * n, (size * n)+size-1, size*m, (size*m)+size-1);
                if(m<3) System.out.print(" | ");
            }
            System.out.println();
        }
    }

    private static void printMatrice(int[][] matrice){
        for(int i=0; i<2000; i++){
            for(int j=0; j<2000; j++){
                if(j == 0) System.out.print(matrice[i][j] + " |");
                else if(j == 1999) System.out.print(matrice[i][j]);
                else System.out.print(matrice[i][j] + " | ");
            }
            System.out.println();
        }
    }
}
