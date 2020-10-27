package it.corsobackendtree.esercizi7.listaordinata;

public class Main {
    public static void main(String[] args) {
        ListaOrdinata lo = new ListaOrdinata();
        lo.insert(40);
        lo.print();
        lo.insert(130);
        lo.print();
        lo.insert(90);
        lo.print();

        int num = 50;
        int index = lo.indexOf(num);
        testIndex(index,num);

        num = 90;
        index = lo.indexOf(num);
        testIndex(index,num);
        lo.remove(num);
        lo.print();
        index = lo.indexOf(num);
        testIndex(index,num);
    }

    private static void testIndex(int index, int num){
        if (index == -1) {
            System.out.println(num + " non è presente in libreria.");
        } else {
            System.out.println(num +" si trova all'indice: " + index);
        }
    }
}
