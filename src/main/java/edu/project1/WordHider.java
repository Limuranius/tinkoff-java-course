package edu.project1;

import java.util.HashSet;

public class WordHider {
    private final String word;
    private HashSet<Character> shownLetters;
    private Dictionary dictionary;

    WordHider(String word, Dictionary dictionary) {
        this.shownLetters = new HashSet<Character>();
        this.word = word;
        this.dictionary = dictionary;
        this.addShownLetter(' ');
    }

    public void addShownLetter(Character letter) {
        this.shownLetters.add(letter);
    }

    public String getWord() {
        String hiddenWord = this.word;
        String alphabet = dictionary.getAlphabet();
        for (int i = 0; i < alphabet.length(); i++) {
            Character letter = alphabet.charAt(i);
            if (!this.shownLetters.contains(letter)) {
                hiddenWord = hiddenWord.replace(letter, '*');
            }
        }
        return hiddenWord;
    }

    public boolean isWordFullyVisible() {
        String hiddenWord = this.getWord();
        return !hiddenWord.contains("*");
    }

    public GuessStatus guessLetter(Character character) {
        if (this.shownLetters.contains(character)) {
            return GuessStatus.ALREADY_GUESSED;
        } else if (this.word.contains(character.toString())) {
            return GuessStatus.RIGHT_GUESS;
        } else {
            return GuessStatus.WRONG_GUESS;
        }
    }
}
