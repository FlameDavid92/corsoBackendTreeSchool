package it.corsobackendtree.esercizi16.sumthread;

import java.util.stream.IntStream;

public class SumThread extends Thread{
    private int[] interi;
    private int start;
    private int end;
    private int sum;
    public SumThread(int[] interi, int start,int end){
        this.start = start;
        this.end = end;
        this.interi = interi;
        sum = 0;
    }

    public int getSum() {
        return sum;
    }

    @Override
    public void run() {
        IntStream stream = IntStream.range(start, end);
        sum = stream.reduce(0,(subtotal,element)->subtotal+interi[element]);
    }
}
