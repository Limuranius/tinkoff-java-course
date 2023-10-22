package edu.project1;

import java.util.Random;

public class EnglishDictionary implements Dictionary {
    private static final String[] WORDS = {
        "hello",
        "java",
        "python",
        "when the impostor is sus"
    };
    private static final String STRING = "abcdefghijklmnopqrstuvwxyz";

    public String getRandomWord() {
        int randI = new Random().nextInt(WORDS.length);
        return WORDS[randI];
    }

    public boolean hasLetter(Character character) {
        return STRING.contains(character.toString());
    }

    public String getAlphabet() {
        return STRING;
    }
}
