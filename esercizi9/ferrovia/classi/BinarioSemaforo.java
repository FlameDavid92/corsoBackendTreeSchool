package it.corsobackendtree.esercizi9.ferrovia.classi;

public class BinarioSemaforo extends Binario {
    int durataMillisec;
    boolean semaforoRosso;
    Thread t1;

    public BinarioSemaforo(int durataMillisec, Binario successivo) {
        super(successivo);
        this.durataMillisec = durataMillisec;
        this.semaforoRosso = true;
        t1 = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(durataMillisec);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                semaforoRosso = !semaforoRosso;
            }
        });
        t1.start();
    }
    public int getDurataMillisec() {
        return durataMillisec;
    }

    @Override
    public Binario percorri(Treno t) {
        if (t instanceof FrecciaRossa || !semaforoRosso) {
            return getSuccessivo();
        } else {
            System.out.println("Semaforo rosso!");
            return this;
        }
    }
}
