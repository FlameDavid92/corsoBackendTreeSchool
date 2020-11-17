package it.corsobackendtree.esercizi16.sumthread;

import java.util.Random;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        int dim = 10000000;
        IntStream stream = IntStream.range(0, dim);
        Random random = new Random();
        int[] interi = new int[dim];
        stream.forEach(i -> interi[i] = (random.nextInt(21)-10));

        System.out.println("--Inizio Parallelo1--");
        long startTime = System.currentTimeMillis();
        int parSum1 = parallel1(interi);
        long par1Millis = System.currentTimeMillis() - startTime;
        System.out.println("--Parallelo1 terminato--");

        System.out.println("--Inizio Parallelo2--");
        startTime = System.currentTimeMillis();
        int parSum2 = parallel2(interi);
        long par2Millis = System.currentTimeMillis() - startTime;
        System.out.println("--Parallelo2 terminato--");

        System.out.println("--Inizio sequenziale--");
        startTime = System.currentTimeMillis();
        int seqSum = sequential(interi);
        long seqMillis = System.currentTimeMillis() - startTime;
        System.out.println("--Sequenziale terminato--");

        System.out.println("Tempo parallelo1: "+par1Millis+" millisecondi.");
        System.out.println("Tempo parallelo2: "+par2Millis+" millisecondi.");
        System.out.println("Tempo sequenziale: "+seqMillis+" millisecondi.");

        System.out.println("TEST CORRETTEZZA: "+((parSum1==parSum2)&&(parSum2 == seqSum)));
    }

    public static int parallel1(int[] interi){
        int length = interi.length;
        SumThread st1 = new SumThread(interi, 0,length/2);
        SumThread st2 = new SumThread(interi, length/2,length);
        st1.start();
        st2.start();
        try {
            st1.join();
            st2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return st1.getSum()+st2.getSum();
    }

    public static int parallel2(int[] interi){
        int length = interi.length;
        SumThread st1 = new SumThread(interi, 0,length/4);
        SumThread st2 = new SumThread(interi, length/4,length/2);
        SumThread st3 = new SumThread(interi,length/2,length/2+length/4);
        SumThread st4 = new SumThread(interi,length/2+length/4,length);
        st1.start();
        st2.start();
        st3.start();
        st4.start();
        try {
            st1.join();
            st2.join();
            st3.join();
            st4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return st1.getSum()+st2.getSum()+st3.getSum()+st4.getSum();
    }

    public static int sequential(int[] interi){
        SumThread st1 = new SumThread(interi, 0,interi.length);
        st1.run();
        return st1.getSum();
    }
}
