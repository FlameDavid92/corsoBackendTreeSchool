package it.corsobackendtree.esercizi7.minimomassimoricorsivo;

public class Main {
    public static void main(String[] args){
        int[] array = new int[]{54,2,68,5,67,34,9};
        int[] minMax = minimoMassimoRicorsivo(array);
        System.out.println("minimo:"+minMax[0]+" MASSIMO:"+minMax[1]);
    }

    public static int[] minimoMassimoRicorsivo(int[] array){
        return getMinMaxricorsivo(array, Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
    }

    private static int[] getMinMaxricorsivo(int[] array, int currentMin, int currentMax, int currentIndex){
        if(currentIndex == array.length){
            return new int[]{currentMin,currentMax};
        }else{
            return getMinMaxricorsivo(array,
                    (array[currentIndex]<currentMin) ? array[currentIndex] : currentMin,
                    (array[currentIndex]>currentMax) ? array[currentIndex] : currentMax,
                    currentIndex+1);
        }
    }
}
