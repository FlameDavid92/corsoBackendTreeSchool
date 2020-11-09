package it.corsobackendtree.esercizi12;

import java.util.TreeSet;

public class CodaSupermercatoTreeSet implements SupermarketQueue{
    private TreeSet<Cliente> codaSupermercato;

    public CodaSupermercatoTreeSet() {
        codaSupermercato = new TreeSet<>();
    }

    @Override
    public boolean arrivaCliente(Cliente c) {
        return codaSupermercato.add(c); /*O(log n)*/
    }

    @Override
    public Cliente clienteInCassa() {
        return codaSupermercato.pollFirst(); /*O(1)*/
    }

    @Override
    public Cliente whoIsNext() {
        return codaSupermercato.first(); /*O(1)*/
    }

    @Override
    public int getNClientiInCoda() {
        return codaSupermercato.size(); /*O(1)*/
    }
}
