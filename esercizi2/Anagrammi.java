package it.corsobackendtree.esercizi2;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

public class Anagrammi {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Inserisci una stringa a: ");
        String a = sc.nextLine();
        System.out.print("Inserisci una stringa b: ");
        String b =sc.nextLine();
        anagrams(a, b);
    }

    static void anagrams(String a, String b) {
        /*Se le due stringhe hanno lunghezze differenti non sono anagrammi*/
        if(a.length() != b.length()){
            System.out.println("Non anagrammi");
            return;
        }
        /*
        Per ogni differente carattere della stringa a salvo il suo numero di occorrenze in una mappa.
        L'operazione di get e put sulla mappa sono O(1).
        La complessità del primo for è O(n) dove n è la lunghezza della stringa a (e della stringa b).
        */
        HashMap<Character, Integer> countersA = new HashMap<>();
        for(int i=0; i<a.length(); i++){
            if(countersA.get(a.charAt(i)) != null){
                countersA.put(a.charAt(i),countersA.get(a.charAt(i))+1);
            }else{
                countersA.put(a.charAt(i),1);
            }
        }

        /*Il secondo for sulla lunghezza di b
            per ogni carattere di b decrementa l' occorrenza del carattere nella mappa di 1.
          La complessità del secondo for è O(n) dove n è la lunghezza della stringa b (e della stringa a).
        */
        for(int j=0; j<b.length();j++){
            if(countersA.get(b.charAt(j)) == 0){
                System.out.println("Non anagrammi");
                return;
            }else {
                countersA.put(b.charAt(j), countersA.get(b.charAt(j)) - 1);
            }
        }

        /*Il terzo for per ogni carattere nella mappa controlla che la sua occorrenza sia a 0,
        se è diversa da 0 stampa "Non anagrammi" e conclude la funzione.
            Se l'occorrenza di un carattere nella mappa non è 0,
            allora: -se è minore di 0, b ha più occorrenze di quel carattere rispetto ad a.
                    -se è maggiore di 0,  a ha più occorrenze di quel carattere rispetto a b.
          La complessità del terzo for è O(m),
          dove m è la dimensione massima della mappa.
          Quest'ultima è limitata dal numero di caratteri differenti nella stringa a,
          poiché arriviamo al 3o for quando in b compaiono SOLO caratteri di a.
        */
        for (Map.Entry carattere : countersA.entrySet()) {
            if((int)carattere.getValue()  != 0){
                System.out.println("Non anagrammi");
                return;
            }
        }
        System.out.println("Anagrammi");
        return;
    }
}
