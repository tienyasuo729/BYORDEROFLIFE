package model;

import java.util.HashMap;
import java.util.Map;

public class WordAndCharacterCounter {
    private String inputString;
    private Map<String, Integer> wordCountMap;
    private Map<Character, Integer> charCountMap;

    public WordAndCharacterCounter(String inputString) {
        this.inputString = inputString;
        this.wordCountMap = new HashMap<>();
        this.charCountMap = new HashMap<>();
    }

    public void countWordsAndCharacters() {
        String[] words = inputString.split("\\s+");
        for (String word : words) {
            wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
            for (char c : word.toCharArray()) {
                charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
            }
        }
    }

    public void displayResults() {
        System.out.print("{");
        for (String word : wordCountMap.keySet()) {
            System.out.print(word + "=" + wordCountMap.get(word) + ", ");
        }
        System.out.println("}");
        System.out.print("{");
        for (char c : charCountMap.keySet()) {
            System.out.print(c + " = " + charCountMap.get(c) + ", ");
        }
        System.out.println("}");
    }
}