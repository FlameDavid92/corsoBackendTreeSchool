package it.corsobackendtree.esercizi14.tweetsparser;

import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        TweetsParser tp = new TweetsParser();
        TreeMap<Long,String> mostFrequent10 = tp.mostFrequent10Words("./it/corsobackendtree/esercizi14/tweetsparser/realdonaldtrump.csv");
        for (int i = 0; i < 10; i++) {
            System.out.println(mostFrequent10.pollLastEntry());
        }
        System.out.println("------");

        mostFrequent10 = tp.mostFrequent10Words("./it/corsobackendtree/esercizi14/tweetsparser/trumptweets.csv");
        for (int i = 0; i < 10; i++) {
            System.out.println(mostFrequent10.pollLastEntry());
        }
    }
}
