package it.corsobackendtree.esercizi13;

public class Main {
    public static void main(String[] args) {
        Dictionary nuovoDizioanrio = new Dictionary();
        Parola calcio = new Parola("calcio", "sport");
        calcio.addSignificato("elemento chimico");
        Parola carota = new Parola("carota","ortaggio");
        Parola caffeina = new Parola("caffeina","alcaloide naturale");
        nuovoDizioanrio.inserisciParola(calcio);
        nuovoDizioanrio.inserisciParola(carota);
        nuovoDizioanrio.inserisciParola(caffeina);
        nuovoDizioanrio.printDictionary();
    }
}
