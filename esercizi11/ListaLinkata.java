package it.corsobackendtree.esercizi11;

public class ListaLinkata<T>{
    Elemento first;

    private class Elemento {
        private T valore;
        private Elemento next;

        public Elemento(T valore, Elemento next){
            this.valore = valore;
            this.next = next;
        }
    }

    public void addFirst(T value){
        first = new Elemento(value, first);
    }

    public void removeFirst(){
        first = first.next;
    }
}
