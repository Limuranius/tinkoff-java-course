package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task4Test {
    @Test
    @DisplayName("Even length")
    void evenLength() {
        String brokenString = "123456";

        String fixedString = Task4.fixString(brokenString);

        assertThat(fixedString).isEqualTo("214365");
    }

    @Test
    @DisplayName("Odd length")
    void oddLength() {
        String brokenString = "badce";

        String fixedString = Task4.fixString(brokenString);

        assertThat(fixedString).isEqualTo("abcde");
    }

    @Test
    @DisplayName("Empty string")
    void empty() {
        String brokenString = "";

        String fixedString = Task4.fixString(brokenString);

        assertThat(fixedString).isEqualTo("");
    }

    @Test
    @DisplayName("Length 1")
    void length1() {
        String brokenString = "a";

        String fixedString = Task4.fixString(brokenString);

        assertThat(fixedString).isEqualTo("a");
    }
}
