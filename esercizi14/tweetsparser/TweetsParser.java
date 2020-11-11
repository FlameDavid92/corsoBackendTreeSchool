package it.corsobackendtree.esercizi14.tweetsparser;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class TweetsParser {
    Map<String, Long> wordsOccurrences;

    public TreeMap<Long, String> mostFrequent10Words(String csvFilePath) {
        wordsOccurrences = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
            String line = br.readLine();
            while ((line = br.readLine()) != null) {
                String content = line.split(",")[2];
                String[] words = content.split("\\W+"); /*!*/
                for (String word : words) {
                    if (word.length() > 0) {
                        if (wordsOccurrences.containsKey(word)) {
                            wordsOccurrences.put(word, wordsOccurrences.get(word) + 1);
                        } else {
                            wordsOccurrences.put(word, 1L);
                        }
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        TreeMap<Long, String> mostFrequent10 = new TreeMap<>();
        for (String key : wordsOccurrences.keySet()) {
            if (mostFrequent10.size() < 10) {
                mostFrequent10.put(wordsOccurrences.get(key), key);
            } else {
                if (wordsOccurrences.get(key) > mostFrequent10.firstKey()) {
                    mostFrequent10.pollFirstEntry();
                    mostFrequent10.put(wordsOccurrences.get(key), key);
                }
            }
        }
        return mostFrequent10;
    }
}
