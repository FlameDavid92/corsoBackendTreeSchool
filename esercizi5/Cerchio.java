package it.corsobackendtree.esercizi5;

public class Cerchio {
    private int raggio;
    private Colore colore;

    public Cerchio(int raggio){
        this.raggio = raggio;
        this.colore = Colore.NERO;
    }

    public int getRaggio(){
        return this.raggio;
    }

    public double getCirconferenza(){
        return 2 * Math.PI * this.raggio;
    }

    public double getArea(){
        return Math.PI * Math.pow(this.raggio,2);
    }

    public Colore getColore(){
        return this.colore;
    }
    public void setColore(int r, int g, int b){
        try {
            this.colore = new Colore(r,g,b);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        Cerchio c = new Cerchio(5);
        System.out.println("C Raggio: "+c.getRaggio());
        System.out.println("C Circonferenza: "+c.getCirconferenza());
        System.out.println("C Area: "+c.getArea());
        System.out.println("C Colore: "+c.getColore().toString());
        c.setColore(20,20,20);
        System.out.println("C Cambio colore: "+c.getColore().toString());
    }
}
