package it.corsobackendtree.esercizi14.tweetsparser;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TweetsParser {
    Map<String, Long> wordsOccurrences;
    String regex;
    Pattern pattern;

    public TweetsParser(){
        regex = "[^\\d\\W]+"; /*all words with no digits*/
        pattern = Pattern.compile(regex);
    }

    public TreeMap<Long, String> mostFrequent10Words(String csvFilePath) {
        wordsOccurrences = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
            String line = br.readLine();
            while ((line = br.readLine()) != null) {
                String content = CSVUtils.parseLine(line).get(2);
                if (!content.contains("pic.twitter") && !content.contains("http")) {
                    Matcher matcher = pattern.matcher(line);
                    while(matcher.find()) {
                        String word = matcher.group();
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
