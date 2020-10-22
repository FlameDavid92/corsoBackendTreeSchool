package it.corsobackendtree.esercizi3;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class NewTombola {
    public static void main(String[] args) {
        NewTombola nt = new NewTombola();
        int[][] cartella = nt.generaCartella();
        nt.printCartella(cartella);
        String resp = nt.controllaCartella(85, cartella);
        System.out.println(resp);
    }

    private void printCartella(int[][] cartella){
        for(int i=0; i<cartella.length; i++){
            for(int j=0; j<cartella[0].length; j++){
                if(cartella[i][j] == 0) System.out.print("\t"+"/");
                else System.out.print("\t"+cartella[i][j]);
            }
            System.out.print("\n");
        }
    }

    private int[][] generaCartella() {
        Random rand = new Random();
        int[][] cartella = new int[3][9];
        Set<Integer> cols;
        Set<Integer> nums = new HashSet<Integer>();
        /*per ogni riga scelgo dove inserire i 5 numeri*/
        for(int i=0; i<3; i++){
            cols = new HashSet<Integer>();
            for(int j=0; j<5; j++){ /*devo inserire 5 numeri randomici nella riga non ripetuti*/
                int col;
                do{
                    col = rand.nextInt(9);
                }while(cols.contains(col));
                cols.add(col);
                int num;
                do{
                    if(col == 0){
                        num = 1+rand.nextInt(9);
                    }else if(col == 8){
                        num = 80+rand.nextInt(11);
                    }else{
                        num = (col*10)+rand.nextInt(10);
                    }
                }while(nums.contains(num));
                nums.add(num);
                cartella[i][col] = num;
            }
        }
        return cartella;
    }

    private String controllaCartella(int numeriDaEstrarre, int[][] cartella){
        Random rand = new Random();
        Set<Integer> a = new HashSet<Integer>();
        int[] righe = {0, 0, 0};
        for(int i=0; i<numeriDaEstrarre; i++){
            int check = a.size();
            int estratto = 0;
            while(check == a.size()){
                estratto = 1+rand.nextInt(90);
                a.add(estratto);
            }
            for(int j=0; j<9; j++){ /*ciclo sulle 9 colonne della cartella e controllo le 3 righe*/
                if(estratto == cartella[0][j]){
                    righe[0]++;
                    break;
                }else if(estratto == cartella[1][j]){
                    righe[1]++;
                    break;
                }else if(estratto == cartella[2][j]){
                    righe[2]++;
                    break;
                }
            }
            if(righe[0] == 5 && righe[1] == 5 && righe[2] == 5){
                System.out.println("\nESTRATTI: "+a.toString()+"\n");
                return "TOMBOLA!!";
            }
        }
        int ambi = 0, terni = 0, quaterne = 0, cinquine = 0;
        for(int c : righe){
            switch (c){
                case 2:
                    ambi++;
                    break;
                case 3:
                    terni++;
                    break;
                case 4:
                    quaterne++;
                    break;
                case 5:
                    cinquine++;
                    break;
            }
        }
        System.out.println("\nESTRATTI: "+a.toString()+"\n");
        return "Il giocatore ha totalizzato\n"+
                "ambi: "+ambi+"\n"+
                "terni: "+terni+"\n"+
                "quaterne: "+quaterne+"\n"+
                "cinquine: "+cinquine;
    }
}
