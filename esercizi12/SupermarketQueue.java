package it.corsobackendtree.esercizi12;

public interface SupermarketQueue {
    public boolean arrivaCliente(Cliente c);
    public Cliente clienteInCassa();
    public Cliente whoIsNext();
    public int getNClientiInCoda();
}
