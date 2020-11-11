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
    String lastPathComputed;
    Set<String> stopWords;

    public TweetsParser(String stopWordsFilePath){
        lastPathComputed = "";
        regex = "[^\\d\\W]+"; /*all words with no digits*/
        pattern = Pattern.compile(regex);
        initializeStopWordsSet(stopWordsFilePath);
    }

    private void initializeStopWordsSet(String stopWordsFilePath){
        stopWords = new HashSet<>();
        try (BufferedReader br = new BufferedReader(new FileReader(stopWordsFilePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                stopWords.add(line.trim());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public TreeMap<Long, List<String>> mostFrequentWords(String csvFilePath) {
        computeWordsOccurences(csvFilePath);
        TreeMap<Long, List<String>> mostFrequent10 = new TreeMap<>();
        for (String key : wordsOccurrences.keySet()) {
            Long occurences = wordsOccurrences.get(key);

            if (mostFrequent10.size() <= 10) {
                if(mostFrequent10.containsKey(occurences)) mostFrequent10.get(occurences).add(key);
                else{
                    LinkedList<String> parole = new LinkedList<>();
                    parole.add(key);
                    mostFrequent10.put(occurences, parole);
                }
            } else {
                if (wordsOccurrences.get(key) > mostFrequent10.firstKey()) {
                    mostFrequent10.pollFirstEntry();
                    LinkedList<String> parole = new LinkedList<>();
                    parole.add(key);
                    mostFrequent10.put(occurences, parole);
                }else if(wordsOccurrences.get(key) == mostFrequent10.firstKey()){
                    mostFrequent10.get(occurences).add(key);
                }
            }
        }
        return mostFrequent10;
    }

    public TreeMap<Long, List<String>> leastFrequentWords(String csvFilePath) {
        computeWordsOccurences(csvFilePath);
        TreeMap<Long, List<String>> leastFrequent10 = new TreeMap<>();
        for (String key : wordsOccurrences.keySet()) {
            Long occurences = wordsOccurrences.get(key);

            if (leastFrequent10.size() <= 10) {
                if(leastFrequent10.containsKey(occurences)) leastFrequent10.get(occurences).add(key);
                else{
                    LinkedList<String> parole = new LinkedList<>();
                    parole.add(key);
                    leastFrequent10.put(occurences, parole);
                }
            } else {
                if (wordsOccurrences.get(key) < leastFrequent10.lastKey()) {
                    leastFrequent10.pollLastEntry();
                    LinkedList<String> parole = new LinkedList<>();
                    parole.add(key);
                    leastFrequent10.put(occurences, parole);
                }else if(wordsOccurrences.get(key) == leastFrequent10.lastKey()){
                    leastFrequent10.get(occurences).add(key);
                }
            }
        }
        return leastFrequent10;
    }

    private void computeWordsOccurences(String csvFilePath){
        if(csvFilePath.equals(lastPathComputed)) return;

        wordsOccurrences = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
            String line = br.readLine(); /*salta la prima riga*/
            while ((line = br.readLine()) != null) {
                String content = CSVUtils.parseLine(line).get(2);
                Matcher matcher = pattern.matcher(content);
                while(matcher.find()) {
                    String word = matcher.group();
                    if(!stopWords.contains(word.toLowerCase())){
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
    }
}
