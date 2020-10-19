package it.corsobackendtree.esercizi1;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ComparaStringhe {
	public static void main(String[] args) {
        String a = "ciao come va ?";
        String b = "cIao come vA ?";
        String c = "ciao come va ";
        System.out.println("2".equals(""+compareStrings(a, b, c)));
        a = "ciao come va ?";
        b = "cIaoo come vA ?";
        c = "ciao come va a";
        System.out.println("1".equals(""+compareStrings(a, b, c)));
        a = "ciao come va ?";
        b = "cIao come va ?";
        c = "ciao come vA ?";
        System.out.println("3".equals(""+compareStrings(a, b, c)));

        System.out.println("--------------------------------------");

        ArrayList<String> tanteStringhe = new ArrayList<>();
        for(int i=1; i<=1000000;i++){
            tanteStringhe.addAll(List.of("1","2","3","4","587","2","5","2","322","6","2","5"));
        }
        compareStringsArray(tanteStringhe);
    }

    /**
     * Metodo compareStrings(String a, String b, String c)
     *
     * input: tre stringhe a, b e c.
     * output: il numero massimo di stringhe uguali tra loro tra le stringhe in input.
     */
    private static int compareStrings(String a, String b, String c) {
        //inserite il vostro codice qui
    	a = a.toLowerCase();
    	b = b.toLowerCase();
    	c = c.toLowerCase();
        return a.equals(b) && b.equals(c)  ? 3 : ( ( a.equals(b) || a.equals(c) || b.equals(c) ) ? 2 : 1 );
    }

    /* Esercizio+ */
    /**
     * Metodo compareStringsArray(ArrayList<String> strings)
     *
     * input: un array di stringhe.
     * compareStringsArray: stampa il numero massimo di stringhe uguali tra loro
     *                      tra le stringhe dell'array in input.
     */
    private static void compareStringsArray(ArrayList<String> strings) {
    	int ret = 1;
    	int tmp;
    	HashMap<String, Integer> counters = new HashMap<>();
    	for(String str : strings) {
    		if(counters.get(str) != null) {
    			tmp = counters.get(str) + 1;
    			if(tmp > ret) ret = tmp;
    			counters.put(str, tmp);
    		}else {
    			counters.put(str, 1);
    		}
    	}
    	/*System.out.println("\nMap: "+counters.toString());*/
    	System.out.println("\n"+ret);
    }
}