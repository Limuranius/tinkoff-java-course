package edu.hw3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task1Tests {
    @Test
    @DisplayName("Uppercase letters")
    void uppercaseLetters() {
        String s = "ABCDEZZZWWWAMOGUS";

        String sAtbash = Task1.atbash(s);

        assertThat(sAtbash)
            .isEqualTo("ZYXWVAAADDDZNLTFH");
    }

    @Test
    @DisplayName("Lowercase letters")
    void lowercaseLetters() {
        String s = "abcdezzzwwwamogus";

        String sAtbash = Task1.atbash(s);

        assertThat(sAtbash)
            .isEqualTo("zyxwvaaadddznltfh");
    }

    @Test
    @DisplayName("Other characters")
    void otherChars() {
        String s = "Ку,чё дел??:)0_0%(";

        String sAtbash = Task1.atbash(s);

        assertThat(sAtbash)
            .isEqualTo("Ку,чё дел??:)0_0%(");
    }

    @Test
    @DisplayName("Mixed characters")
    void mixedChars() {
        String s = "Hello world!";

        String sAtbash = Task1.atbash(s);

        assertThat(sAtbash)
            .isEqualTo("Svool dliow!");
    }
}
