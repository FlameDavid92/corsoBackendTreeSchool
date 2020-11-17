package it.corsobackendtree.esercizi16.sumthread;

public class UtilThread extends Thread{
    boolean op;
    int[] interi;
    int length;
    int sum;

    public UtilThread(boolean op, int[] interi){
        this.op = op;
        this.interi = interi;
        length = interi.length;
    }

    public int getSum() {
        return sum;
    }

    @Override
    public void run() {
        SumThread st1;
        SumThread st2;
        if(op){
            st1 = new SumThread(interi, 0,length/4);
            st2 = new SumThread(interi, length/4,length/2);
        }else{
            st1 = new SumThread(interi,length/2,length/2+length/4);
            st2 = new SumThread(interi,length/2+length/4,length);
        }
        st1.start();
        st2.start();

        try {
            st1.join();
            st2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        sum = st1.getSum()+st2.getSum();
    }
}
