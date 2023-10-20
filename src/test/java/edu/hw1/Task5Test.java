package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task5Test {
    @Test
    @DisplayName("Palindromes with even length")
    void palindromeEvenLen() {
        assertThat(Task5.isPalindromeDescendant(2442))
            .isEqualTo(true);
        assertThat(Task5.isPalindromeDescendant(22))
            .isEqualTo(true);
        assertThat(Task5.isPalindromeDescendant(3333))
            .isEqualTo(true);
    }

    @Test
    @DisplayName("Palindromes with odd length")
    void isPalindromeOddLen() {
        assertThat(Task5.isPalindromeDescendant(24542))
            .isEqualTo(true);
        assertThat(Task5.isPalindromeDescendant(232))
            .isEqualTo(true);
        assertThat(Task5.isPalindromeDescendant(1))
            .isEqualTo(true);
        assertThat(Task5.isPalindromeDescendant(0))
            .isEqualTo(true);
    }

    @Test
    @DisplayName("Numbers with even length")
    void EvenLen() {
        assertThat(Task5.isPalindromeDescendant(11211230))
            .isEqualTo(true);
        assertThat(Task5.isPalindromeDescendant(13001120))
            .isEqualTo(true);
        assertThat(Task5.isPalindromeDescendant(23336014))
            .isEqualTo(true);
        assertThat(Task5.isPalindromeDescendant(11))
            .isEqualTo(true);
        assertThat(Task5.isPalindromeDescendant(56))
            .isEqualTo(true);
        assertThat(Task5.isPalindromeDescendant(12))
            .isEqualTo(false);
    }

    @Test
    @DisplayName("Numbers with odd length")
    void OddLen() {
        assertThat(Task5.isPalindromeDescendant(1))
            .isEqualTo(true);
        assertThat(Task5.isPalindromeDescendant(121))
            .isEqualTo(true);
        assertThat(Task5.isPalindromeDescendant(235))
            .isEqualTo(true);
        assertThat(Task5.isPalindromeDescendant(245))
            .isEqualTo(true);
        assertThat(Task5.isPalindromeDescendant(255))
            .isEqualTo(false);
    }
}
