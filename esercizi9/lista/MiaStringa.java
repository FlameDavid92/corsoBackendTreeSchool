package it.corsobackendtree.esercizi9.lista;

import java.util.Arrays;

public class MiaStringa extends ListaAbstract {

    public MiaStringa() {
        super();
    }

    @Override
    public void add(Object o) {
        if (o instanceof Character) {
            lista = Arrays.copyOf(lista, lista.length + 1);
            lista[lista.length - 1] = o;
        }
    }

    @Override
    public boolean contains(Object o) {
        if (o instanceof Character) {
            for(int i=0; i<this.lista.length;i++){
                if( ((Character) o).equals(this.lista[i]) ){
                    return true;
                }
            }
            return false;
        }else return false;
    }
}
