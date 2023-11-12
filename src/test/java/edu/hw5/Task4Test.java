package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Task4Test {
    @Test
    @DisplayName("Contains no special characters")
    void test1() {
        assertThat(Task4.validatePassword("aboba123")).isFalse();
        assertThat(Task4.validatePassword("aboba1")).isFalse();
        assertThat(Task4.validatePassword("abo123ba")).isFalse();
        assertThat(Task4.validatePassword("abo1ba")).isFalse();
        assertThat(Task4.validatePassword("1aboba")).isFalse();
    }

    @Test
    @DisplayName("Contains one special character")
    void test2() {
        assertThat(Task4.validatePassword("hello!")).isTrue();
        assertThat(Task4.validatePassword("he!lo")).isTrue();
        assertThat(Task4.validatePassword("!hello")).isTrue();
    }

    @Test
    @DisplayName("Contains multiple special characters of one type")
    void test3() {
        assertThat(Task4.validatePassword("hello!!!")).isFalse();
        assertThat(Task4.validatePassword("hel!!!lo")).isFalse();
        assertThat(Task4.validatePassword("!!!hello")).isFalse();
        assertThat(Task4.validatePassword("h!e!l!l!o")).isFalse();
    }

    @Test
    @DisplayName("Contains different special characters")
    void test4() {
        assertThat(Task4.validatePassword("hello!#$")).isFalse();
        assertThat(Task4.validatePassword("he!#$llo")).isFalse();
        assertThat(Task4.validatePassword("!#$hello")).isFalse();
        assertThat(Task4.validatePassword("h!e#l$lo")).isFalse();
    }

    @Test
    @DisplayName("One special character")
    void test() {
        assertThat(Task4.validatePassword("!")).isTrue();
        assertThat(Task4.validatePassword("#")).isTrue();
        assertThat(Task4.validatePassword("$")).isTrue();
    }
}
