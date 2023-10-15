package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task6Test {
    @Test
    @DisplayName("6621")
    void test_1() {
        int number = 6621;

        int count = Task6.countK(number);

        assertThat(count).isEqualTo(5);
    }

    @Test
    @DisplayName("6554")
    void test_2() {
        int number = 6554;

        int count = Task6.countK(number);

        assertThat(count).isEqualTo(4);
    }

    @Test
    @DisplayName("1234")
    void test_3() {
        int number = 1234;

        int count = Task6.countK(number);

        assertThat(count).isEqualTo(3);
    }

    @Test
    @DisplayName("6174")
    void test_4() {
        int number = 6174;

        int count = Task6.countK(number);

        assertThat(count).isEqualTo(0);
    }
}
