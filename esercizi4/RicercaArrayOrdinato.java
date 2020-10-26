package it.corsobackendtree.esercizi4;

public class RicercaArrayOrdinato {
    public static void main(String[] args){
        RicercaArrayOrdinato rao = new RicercaArrayOrdinato();
        int resp = rao.cercaIntero(new int[] {1,2,3,45,100}, 45);
        System.out.println(resp);
        resp = rao.cercaIntero(new int[] {1,2,3,45,100,256}, 24);
        System.out.println(resp);
        System.out.println("--------");
        resp = rao.ricercaBinaria(new int[] {1,2,3,45,100}, 0, 4, 45);
        System.out.println(resp);
        resp = rao.ricercaBinaria(new int[] {1,2,3,45,100,256}, 0, 4, 24);
        System.out.println(resp);
    }

    /*O(n)*/
    private int cercaIntero(int[] arrayOrdinato, int n){
        for(int i=0; i<arrayOrdinato.length; i++){
            if(arrayOrdinato[i] == n){
                return i;
            }else if(arrayOrdinato[i] > n){
                break;
            }
        }
        return -1;
    }

    /*O(log n)*/
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
}
