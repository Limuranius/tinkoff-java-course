package edu.project1;

import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Game {
    private static final int START_LIVES = 5;
    private static final String EXIT_COMMAND = "exit";
    private final static Logger LOGGER = LogManager.getLogger();

    private final WordHider wordHider;
    private final Dictionary dictionary;
    private int livesLeft;

    Game() {
        this.livesLeft = START_LIVES;
        this.dictionary = new EnglishDictionary();
        this.wordHider = new WordHider(
            dictionary.getRandomWord(),
            dictionary
        );
    }

    public void start() {
        LOGGER.info("Welcome to HANGMAN game");
        LOGGER.info("Today's word is: " + this.wordHider.getWord());

        var sc = new Scanner(System.in);
        boolean playerWon = false;
        while (!playerWon && this.livesLeft != 0) {
            LOGGER.info("Guess a letter");
            String input = sc.nextLine();
            Character letter = input.charAt(0);
            if (input.equals(EXIT_COMMAND)) {
                return;
            }
            if (input.length() != 1 || !this.dictionary.hasLetter(letter)) {
                LOGGER.info("Invalid input. Try again!");
            } else {
                switch (wordHider.guessLetter(letter)) {
                    case RIGHT_GUESS -> {
                        this.wordHider.addShownLetter(letter);
                        LOGGER.info("Correct! Now the word looks like this: " + this.wordHider.getWord());
                    }
                    case WRONG_GUESS -> {
                        this.livesLeft -= 1;
                        LOGGER.info("Incorrect! You have " + this.livesLeft + " lives left.");
                    }
                    case ALREADY_GUESSED -> {
                        LOGGER.info("You've already guessed this letter.");
                    }
                    default -> {
                    }
                }
            }
            if (wordHider.isWordFullyVisible()) {
                playerWon = true;
            }
        }
        if (playerWon) {
            LOGGER.info("You won!");
        } else {
            LOGGER.info("You lost!");
        }
    }
}
