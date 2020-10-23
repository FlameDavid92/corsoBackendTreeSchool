package it.corsobackendtree.esercizi5;

public class Contatore {
    private int contatore;

    public Contatore(){
        this.contatore = 0;
    }
    public Contatore(int valoreIniziale){
        this.contatore = valoreIniziale;
    }

    public int getContatore(){
        return this.contatore;
    }
    public void setContatore(int value){
        this.contatore = value;
    }
    public int increment(){
        setContatore(this.contatore + 1);
        return getContatore();
    }
    public int reset(){
        setContatore(0);
        return getContatore();
    }
    public int resetContatore(int value){
        setContatore(value);
        return getContatore();
    }


    public static void main(String[] args){
        Contatore c1 = new Contatore();
        Contatore c2 = new Contatore(5);
        System.out.println("C1 costruito senza parametri: "+c1.getContatore());
        System.out.println("C2 costruito con valore iniziale 5: "+c2.getContatore());
        System.out.println("C1 increment: "+c1.increment());
        System.out.println("C2 increment: "+c2.increment());
        System.out.println("C1 reset a valore 10: "+c1.resetContatore(10));
        System.out.println("C2 reset: "+c1.reset());

    }
}
