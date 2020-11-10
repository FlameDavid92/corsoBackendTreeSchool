package it.corsobackendtree.esercizi13;

public class Main {
    public static void main(String[] args) {
        Dictionary nuovoDizioanrio = new Dictionary();

        Parola calcio = null;
        Parola carota = null;
        Parola caffeina = null;
        try {
            calcio = new Parola("calcio", "sport");
            carota = new Parola("carota", "ortaggio");
            caffeina = new Parola("caffeina", "alcaloide naturale");
        } catch (MalformedSignificatoException e) {
            System.out.println(e.getMessage());
        }

        try {
            calcio.addSignificato("elemento chimico");
        } catch (MalformedSignificatoException e) {
            System.out.println(e.getMessage());
        } catch (NullPointerException e2) {
            System.out.println("Null Pointer Exception!!!!!!!");
        }

        try {
            nuovoDizioanrio.inserisciParola(calcio);
        } catch (MalformedWordException e) {
            System.out.println(e.getMessage());
        } catch (NullPointerException e2) {
            System.out.println("Null Pointer Exception!!!!!!!");
        }

        try {
            nuovoDizioanrio.inserisciParola(carota);
        } catch (MalformedWordException e) {
            System.out.println(e.getMessage());
        } catch (NullPointerException e2) {
            System.out.println("Null Pointer Exception!!!!!!!");
        }

        try {
            nuovoDizioanrio.inserisciParola(caffeina);
        } catch (MalformedWordException e) {
            System.out.println(e.getMessage());
        } catch (NullPointerException e2) {
            System.out.println("Null Pointer Exception!!!!!!!");
        }

        try {
            nuovoDizioanrio.printDictionary();
        } catch (VoidDictionaryException e) {
            System.out.println(e.getMessage());
        } catch (NullPointerException e2) {
            System.out.println("Null Pointer Exception!!!!!!!");
        }
    }
}
