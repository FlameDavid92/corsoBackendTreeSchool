package it.corsobackendtree.esercizi7.biblioteca;

import java.util.Arrays;

public class Biblioteca {
    private int[] libri;
    public Biblioteca(int[] libri){
        this.libri = libri;
        Arrays.sort(this.libri);
    }

    public boolean esisteLibro(int lib){
        return ricercaBinaria(this.libri, 0, this.libri.length-1, lib) != -1;
    }

    private int ricercaBinaria(int[] arrayOrdinato, int start, int end, int toFind){
        if(start >= end){
            return -1;
        }else if(toFind == arrayOrdinato[(start+end)/2]){
            return (start+end)/2;
        }else if(toFind > arrayOrdinato[(start+end)/2]){
            return ricercaBinaria(arrayOrdinato, ((start+end)/2)+1, end, toFind);
        }else{
            return ricercaBinaria(arrayOrdinato, start, ((start+end)/2)-1, toFind);
        }
    }

    public int[] getIndiciLibriOrdinati(){
        /* ritorno una copia della lista */
        int[] retArray = new int[this.libri.length];
        for(int i=0; i<retArray.length;i++){
            retArray[i] = this.libri[i];
        }
        return retArray;
    }
}
