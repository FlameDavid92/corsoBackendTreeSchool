package it.corsobackendtree.esercizi7.biblioteca;

import java.util.Arrays;

public class Biblioteca {
    private int[] libri;
    public Biblioteca(int[] libri){
        this.libri = libri;
    }

    public boolean esisteLibro(int lib){
        for(int i=0; i<this.libri.length; i++){
            if(libri[i] == lib){
                return true;
            }
        }
        return false;
    }

    public int[] getIndiciLibriOrdinati(){
        Arrays.sort(this.libri);

        /* ritorno una copia della lista */
        int[] retArray = new int[this.libri.length];
        for(int i=0; i<retArray.length;i++){
            retArray[i] = this.libri[i];
        }
        return retArray;
    }
}
