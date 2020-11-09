package it.corsobackendtree.esercizi12;

import java.util.PriorityQueue;

public class CodaSupermercato {
    private PriorityQueue<Cliente> coda;

    public CodaSupermercato(){
        coda = new PriorityQueue();
    }

    public boolean arrivaCliente(Cliente c){
        if(!coda.contains(c)) return coda.offer(c);
        else{
            System.out.println("Cliente già in coda!");
            return false;
        }
    }
    public Cliente clienteInCassa(){
        return coda.poll();
    }
    public Cliente whoIsNext(){
        return coda.peek();
    }
    public int getNClientiInCoda(){
        return coda.size();
    }
}
