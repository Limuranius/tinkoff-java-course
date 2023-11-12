package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Task7Test {
    @Test
    @DisplayName("Regex 1: len < 3")
    void test0() {
        String string = "01";
        int regexNumber = 1;

        var result = Task7.matchRegex(regexNumber, string);

        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("Regex 1: 3rd != 0")
    void test1() {
        String string = "10101";
        int regexNumber = 1;

        var result = Task7.matchRegex(regexNumber, string);

        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("Regex 1: string is valid")
    void test2() {
        String string = "01010000101";
        int regexNumber = 1;

        var result = Task7.matchRegex(regexNumber, string);

        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("Regex 2: len = 0")
    void test3() {
        String string = "";
        int regexNumber = 2;

        var result = Task7.matchRegex(regexNumber, string);

        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("Regex 2: len = 2")
    void test4() {
        String string = "11";
        int regexNumber = 2;

        var result = Task7.matchRegex(regexNumber, string);

        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("Regex 2: start and end not equal")
    void test5() {
        String string = "10101010";
        int regexNumber = 2;

        var result = Task7.matchRegex(regexNumber, string);

        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("Regex 2: start and end equal")
    void test6() {
        String string = "1111111111111";
        int regexNumber = 2;

        var result = Task7.matchRegex(regexNumber, string);

        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("Regex 3: len = 0")
    void test7() {
        String string = "";
        int regexNumber = 3;

        var result = Task7.matchRegex(regexNumber, string);

        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("Regex 3: len = 1")
    void test8() {
        String string = "1";
        int regexNumber = 3;

        var result = Task7.matchRegex(regexNumber, string);

        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("Regex 3: len = 2")
    void test9() {
        String string = "01";
        int regexNumber = 3;

        var result = Task7.matchRegex(regexNumber, string);

        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("Regex 3: len = 3")
    void test10() {
        String string = "101";
        int regexNumber = 3;

        var result = Task7.matchRegex(regexNumber, string);

        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("Regex 3: len = 4")
    void test11() {
        String string = "1010";
        int regexNumber = 3;

        var result = Task7.matchRegex(regexNumber, string);

        assertThat(result).isFalse();
    }
}
