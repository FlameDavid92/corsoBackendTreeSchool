package it.corsobackendtree.esercizi2;

import java.util.Arrays;

public class DaDispariAPari {
    public static void main(String[] args){
        DaDispariAPari dp = new DaDispariAPari();
        int[] ret = dp.noOdds(new int[] {1,2,3,4,5,6});
        System.out.println(Arrays.toString(ret));
    }

    private int[] noOdds(int[] array){
        int [] toRet = new int[array.length];
        for(int i=0; i<array.length; i++){
            toRet[i] = (array[i]%2 == 0) ? array[i] : (array[i]*2);
        }
        return toRet;
    }
}
