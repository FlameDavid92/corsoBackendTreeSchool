package it.corsobackendtree.esercizi12;

import java.util.PriorityQueue;

public class CodaSupermercatoPriorityQueue implements SupermarketQueue{
    private PriorityQueue<Cliente> coda;

    public CodaSupermercatoPriorityQueue(){
        coda = new PriorityQueue();
    }

    @Override
    public boolean arrivaCliente(Cliente c){
        if(!coda.contains(c)) return coda.offer(c); /*offer in O(log n) ma O(n) per il contains!!!*/
        else{
            return false;
        }
    }

    @Override
    public Cliente clienteInCassa(){
        return coda.poll();
    } /*O(1)*/

    @Override
    public Cliente whoIsNext(){
        return coda.peek();
    } /*O(1)*/

    @Override
    public int getNClientiInCoda(){
        return coda.size();
    } /*O(1)*/
}
