package it.corsobackendtree.esercizi14.tweetsparser;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        TweetsParser tp = new TweetsParser();
        TreeMap<Long, List<String>> mostFrequent = tp.mostFrequent10Words("./it/corsobackendtree/esercizi14/tweetsparser/realdonaldtrump.csv");
        TreeMap<Long, List<String>> leastFrequent = tp.leastFrequentWords("./it/corsobackendtree/esercizi14/tweetsparser/realdonaldtrump.csv");

        System.out.println("MOST FREQUENT - realdonaldtrump.csv (numOccurences=[words])");
        for (int i = 0; i < 10; i++) {
            System.out.println(mostFrequent.pollLastEntry());
        }
        System.out.println("------");
        System.out.println("LEAST FREQUENT - realdonaldtrump.csv (numOccurences=[words])");
        for (int i = 0; i < 10; i++) {
            System.out.println(leastFrequent.pollFirstEntry());
        }

        System.out.println("------\n------");

        mostFrequent = tp.mostFrequent10Words("./it/corsobackendtree/esercizi14/tweetsparser/trumptweets.csv");
        leastFrequent = tp.leastFrequentWords("./it/corsobackendtree/esercizi14/tweetsparser/trumptweets.csv");

        System.out.println("MOST FREQUENT - trumptweets.csv (numOccurences=[words])");
        for (int i = 0; i < 10; i++) {
            System.out.println(mostFrequent.pollLastEntry());
        }
        System.out.println("------");
        System.out.println("LEAST FREQUENT - trumptweets.csv (numOccurences=[words])");
        for (int i = 0; i < 10; i++) {
            System.out.println(leastFrequent.pollFirstEntry());
        }
    }
}
