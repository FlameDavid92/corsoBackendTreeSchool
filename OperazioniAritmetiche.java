package it.corsobackendtree;
import java.util.Scanner;
 
public class OperazioniAritmetiche {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Inserisci un intero a: ");
        int a=sc.nextInt();
        System.out.print("Inserisci un intero b: ");
        int b=sc.nextInt();
        try {
			computeValues(a, b);
		} catch (Exception e) {
			e.printStackTrace();
		}
        sc.close();
    }

	/**
	 * Metodo computeValues(int a, int b)
	 *
	 * input: due interi a e b.
	 * computeValues: stampa la somma, sottrazione, moltiplicazione tra a e b,
	 * se b è 0 lancia un'eccezione e non effettua la divisione per 0.
	 * output: -
	 */
    private static void computeValues(int a, int b) throws Exception {
    	System.out.println("a+b: "+(a+b));
    	System.out.println("a-b: "+(a-b));
    	System.out.println("a*b: "+(a*b));
    	if(b != 0) {
    		System.out.println("a/b: "+(a/b));
    	}else {
    		throw new Exception("Non puoi dividere per 0!!!");
    	}
    }
}