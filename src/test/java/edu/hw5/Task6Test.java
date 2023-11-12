package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Task6Test {
    @Test
    @DisplayName("Empty substring")
    void test1() {
        String string = "baobab";
        String substring = "";

        var result = Task6.isSubstring(substring, string);

        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("Empty string")
    void test2() {
        String string = "";
        String substring = "abc";

        var result = Task6.isSubstring(substring, string);

        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("Is substring")
    void test3() {
        String string = "baobab";
        String substring = "ab";

        var result = Task6.isSubstring(substring, string);

        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("Is not substring")
    void test4() {
        String string = "banana";
        String substring = "az";

        var result = Task6.isSubstring(substring, string);

        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("Multiple occurrences")
    void test5() {
        String string = "ababababababababab";
        String substring = "ab";

        var result = Task6.isSubstring(substring, string);

        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("Whole string")
    void test6() {
        String string = "ananas";
        String substring = "ananas";

        var result = Task6.isSubstring(substring, string);

        assertThat(result).isTrue();
    }
}
