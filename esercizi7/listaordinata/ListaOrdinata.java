package it.corsobackendtree.esercizi7.listaordinata;

import java.util.Arrays;

public class ListaOrdinata {
    private Integer[] arrayOrdinato;
    private int lastFreeIndex;
    private int cancellazioni;

    public ListaOrdinata() {
        this.arrayOrdinato = new Integer[5];
        this.lastFreeIndex = 0;
        this.cancellazioni = 0;
    }

    public void insert(int x) {
        /*Ogni 10 cancellazioni elimino i possibili null interni dovuti alle cancellazioni.*/
        if (this.cancellazioni == 10) {
            clean();
        }
        /*Se non ho più spazio nell'array per l'inserimento, raddoppio lo spazio disponibile.*/
        if (this.lastFreeIndex == this.arrayOrdinato.length - 1) {
            doubleSpace();
        }
        /*------*/
        int temp = -1;
        boolean indexFound = false;
        for (int i = 0; i < lastFreeIndex + 1; i++) {
            if (!indexFound && i < lastFreeIndex && this.arrayOrdinato[i] == null) {
                continue;
            } else if (!indexFound && i == lastFreeIndex && this.arrayOrdinato[i] == null) {
                this.arrayOrdinato[i] = x;
                indexFound = true;
                break;
            } else if (!indexFound && x < this.arrayOrdinato[i]) {
                temp = this.arrayOrdinato[i];
                this.arrayOrdinato[i] = x;
                indexFound = true;
            } else if (indexFound) {
                if (this.arrayOrdinato[i] == null) {
                    this.arrayOrdinato[i] = temp;
                    break;
                } else {
                    int temp2 = this.arrayOrdinato[i];
                    this.arrayOrdinato[i] = temp;
                    temp = temp2;
                }
            }
        }
        lastFreeIndex++;
    }

    public int indexOf(int x) {
        /*Eseguo un clean così non ho null interni.*/
        if (this.cancellazioni != 0) {
            clean();
        }
        return ricercaBinaria(this.arrayOrdinato,
                0, this.lastFreeIndex - 1, x);
    }

    private int ricercaBinaria(Integer[] arrayOrdinato, int start, int end, int toFind) {
        if (start >= end) {
            return -1;
        } else if (toFind == arrayOrdinato[(start + end) / 2]) {
            return (start + end) / 2;
        } else if (toFind > arrayOrdinato[(start + end) / 2]) {
            return ricercaBinaria(arrayOrdinato, ((start + end) / 2) + 1, end, toFind);
        } else {
            return ricercaBinaria(arrayOrdinato, start, ((start + end) / 2) - 1, toFind);
        }
    }

    public void remove(int x) {
        for (int i = 0; i < lastFreeIndex; i++) {
            if (this.arrayOrdinato[i] == null) {
                continue;
            }
            if (this.arrayOrdinato[i] == x) {
                this.arrayOrdinato[i] = null;
            }
        }
        this.cancellazioni++;
    }

    public void print() {
        System.out.print("[");
        for (int i = 0; i < lastFreeIndex; i++) {
            if (arrayOrdinato[i] == null) continue;

            if (i == lastFreeIndex - 1) System.out.print(arrayOrdinato[i]);
            else System.out.print(arrayOrdinato[i] + ",");
        }
        System.out.print("]\n");
    }

    public void clean() {
        int length = this.arrayOrdinato.length;
        Integer[] newArrayOrdinato = new Integer[length];
        int j = 0;
        for (int i = 0; i < this.lastFreeIndex; i++) {
            if (this.arrayOrdinato[i] != null) {
                newArrayOrdinato[j] = this.arrayOrdinato[i];
                j++;
            }
        }
        this.arrayOrdinato = newArrayOrdinato;
        this.lastFreeIndex = j;
    }

    public void doubleSpace() {
        int length = this.arrayOrdinato.length;
        Integer[] newArrayOrdinato = new Integer[length * 2];
        for (int i = 0; i < length; i++) {
            newArrayOrdinato[i] = this.arrayOrdinato[i];
        }
        this.lastFreeIndex = length;
        this.arrayOrdinato = newArrayOrdinato;
    }
}
