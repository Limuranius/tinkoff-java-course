package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task2Test {
    @Test
    @DisplayName("Zero")
    void zero() {
        int number = 0;

        int digitsCount = Task2.countDigits(number);

        assertThat(digitsCount).isEqualTo(1);
    }

    @Test
    @DisplayName("Positive number")
    void positive() {
        int number = 123;

        int digitsCount = Task2.countDigits(number);

        assertThat(digitsCount).isEqualTo(3);
    }

    @Test
    @DisplayName("Negative number")
    void negative() {
        int number = -5971;

        int digitsCount = Task2.countDigits(number);

        assertThat(digitsCount).isEqualTo(4);
    }
}
