package it.corsobackendtree.esercizi1;
import java.util.Scanner;
 
public class RimpiazzaIntrusi {
 
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Inserisci stringa a: ");
        String a=sc.nextLine();
        System.out.print("Inserisci stringa b: ");
        String b=sc.nextLine();
        System.out.print("Inserisci stringa c: ");
        String c=sc.nextLine();
        c = replaceIntruder(a, b, c);
        System.out.print(c);
        sc.close();
    }

    /**
     * Metodo replaceIntruder(String a, String b , String c)
     *
     * input:   tre stringhe a, b e c
     * output:  ritorna una stringa uguale alla stringa c tranne per la seconda "parola"
     *          nella quale le occorrenze della sottostringa a
     *          vengono sostituite con la sottostringa b.
     */
    private static String replaceIntruder(String a, String b , String c) {
    	String[] split = c.split(" ");
    	if(split.length == 3) {
    		return split[0]+" "+split[1].replaceAll(a, b)+" "+split[2];
    	}else {
    		return c;
    	}
    }
    
}
