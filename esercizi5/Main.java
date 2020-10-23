package it.corsobackendtree.esercizi5;

public class Main {
    public static void main(String[] args){
        testContatore();
        System.out.println("---------");
        testCerchio();
        System.out.println("---------");
        testQuadrato();
    }
    private static void testContatore(){
        Contatore c1 = new Contatore();
        Contatore c2 = new Contatore(5);
        System.out.println("C1 costruito senza parametri: "+c1.getContatore());
        System.out.println("C2 costruito con valore iniziale 5: "+c2.getContatore());
        System.out.println("C1 increment: "+c1.increment());
        System.out.println("C2 increment: "+c2.increment());
        System.out.println("C1 reset a valore 10: "+c1.resetContatore(10));
        System.out.println("C2 reset: "+c1.reset());
    }
    private static void testQuadrato(){
        Quadrato q1 = new Quadrato(5);
        System.out.println("Lato q1: "+q1.getLato());
        System.out.println("Perimetro q1: "+q1.getPerimetro());
        q1.print();
        System.out.println("Q1 Colore: "+q1.getColore().toString());
        q1.setColore(250,250,250);
        System.out.println("Q1 Cambio colore: "+q1.getColore().toString());
    }
    private static void testCerchio(){
        Cerchio c = new Cerchio(5);
        System.out.println("C Raggio: "+c.getRaggio());
        System.out.println("C Circonferenza: "+c.getCirconferenza());
        System.out.println("C Area: "+c.getArea());
        System.out.println("C Colore: "+c.getColore().toString());
        c.setColore(20,20,20);
        System.out.println("C Cambio colore: "+c.getColore().toString());
    }
}
