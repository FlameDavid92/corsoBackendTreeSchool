package it.corsobackendtree.esercizi7.listaordinata;

public class ListaOrdinata {
    private Integer[] arrayOrdinato;
    private int lastFreeIndex;

    public ListaOrdinata() {
        this.arrayOrdinato = new Integer[5];
        this.lastFreeIndex = 0;
    }

    public void insert(int x) {
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
        int index = indexOf(x);
        if (index < lastFreeIndex-1) {
            this.arrayOrdinato[index] = this.arrayOrdinato[index + 1];
            for (int i = index + 1; i < lastFreeIndex; i++) {
                if (i == lastFreeIndex - 1) this.arrayOrdinato[i] = null;
                else {
                    this.arrayOrdinato[i] = this.arrayOrdinato[i + 1];
                }
            }
        }else this.arrayOrdinato[lastFreeIndex-1] = null;
        lastFreeIndex--;
    }

    public void print() {
        System.out.print("[");
        for (int i = 0; i < lastFreeIndex; i++) {
            if (i == lastFreeIndex - 1) System.out.print(arrayOrdinato[i]);
            else System.out.print(arrayOrdinato[i] + ",");
        }
        System.out.print("]\n");
    }

    public void doubleSpace() {
        int length = this.arrayOrdinato.length;
        Integer[] newArrayOrdinato = new Integer[length * 2];
        for (int i = 0; i < lastFreeIndex; i++) {
            newArrayOrdinato[i] = this.arrayOrdinato[i];
        }
        this.lastFreeIndex = length;
        this.arrayOrdinato = newArrayOrdinato;
    }
}
