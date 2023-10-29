package edu.hw3;

import java.util.HashMap;
import java.util.Map;

public class Task1 {

    private Task1() {
    }

    public static String atbash(String str) {
        Map<Character, Character> encodeTable = new HashMap<>();
        for (char ch = 'A'; ch <= 'Z'; ch++) {
            char mappedChar = (char) ('Z' - (ch - 'A'));
            encodeTable.put(ch, mappedChar);
        }
        for (char ch = 'a'; ch <= 'z'; ch++) {
            char mappedChar = (char) ('z' - (ch - 'a'));
            encodeTable.put(ch, mappedChar);
        }
        StringBuilder atbashStr = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            Character strChar = str.charAt(i);
            Character encodedChar = encodeTable.getOrDefault(strChar, strChar);
            atbashStr.append(encodedChar);
        }
        return atbashStr.toString();
    }
}
