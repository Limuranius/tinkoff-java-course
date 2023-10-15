package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task5Test {
    @Test
    @DisplayName("isPalindrome: numbers with even length")
    void isPalindromeEvenLen() {
        assertThat(Task5.isPalindrome(2442))
            .isEqualTo(true);
        assertThat(Task5.isPalindrome(4422))
            .isEqualTo(false);
        assertThat(Task5.isPalindrome(22))
            .isEqualTo(true);
        assertThat(Task5.isPalindrome(13))
            .isEqualTo(false);
    }

    @Test
    @DisplayName("isPalindrome: numbers with odd length")
    void isPalindromeOddLen() {
        assertThat(Task5.isPalindrome(24542))
            .isEqualTo(true);
        assertThat(Task5.isPalindrome(44122))
            .isEqualTo(false);
        assertThat(Task5.isPalindrome(232))
            .isEqualTo(true);
        assertThat(Task5.isPalindrome(113))
            .isEqualTo(false);
        assertThat(Task5.isPalindrome(1))
            .isEqualTo(true);
        assertThat(Task5.isPalindrome(0))
            .isEqualTo(true);
    }

    @Test
    @DisplayName("descend: numbers with even length")
    void descendEvenLen() {
        assertThat(Task5.descend(2244))
            .isEqualTo(48);
        assertThat(Task5.descend(1854))
            .isEqualTo(99);
        assertThat(Task5.descend(11223344))
            .isEqualTo(2468);
        assertThat(Task5.descend(55))
            .isEqualTo(10);
        assertThat(Task5.descend(567899))
            .isEqualTo(111518);
    }

    @Test
    @DisplayName("descend: numbers with odd length")
    void descendOddLen() {
        assertThat(Task5.descend(1))
            .isEqualTo(1);
        assertThat(Task5.descend(111))
            .isEqualTo(21);
        assertThat(Task5.descend(979))
            .isEqualTo(169);
        assertThat(Task5.descend(100))
            .isEqualTo(10);
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
