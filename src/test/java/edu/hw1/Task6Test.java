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

    @Test
    @DisplayName("1111")
    void test_5() {
        int number = 1111;

        int count = Task6.countK(number);

        assertThat(count).isEqualTo(-1);
    }

    @Test
    @DisplayName("9999")
    void test_6() {
        int number = 9999;

        int count = Task6.countK(number);

        assertThat(count).isEqualTo(-1);
    }

    @Test
    @DisplayName("9998")
    void test_7() {
        int number = 9998;

        int count = Task6.countK(number);

        assertThat(count).isEqualTo(5);
    }

    @Test
    @DisplayName("1000")
    void test_8() {
        int number = 1000;

        int count = Task6.countK(number);

        assertThat(count).isEqualTo(-1);
    }

    @Test
    @DisplayName("999")
    void test_9() {
        int number = 999;

        int count = Task6.countK(number);

        assertThat(count).isEqualTo(-1);
    }

    @Test
    @DisplayName("50")
    void test_10() {
        int number = 50;

        int count = Task6.countK(number);

        assertThat(count).isEqualTo(-1);
    }

    @Test
    @DisplayName("1")
    void test_11() {
        int number = 1;

        int count = Task6.countK(number);

        assertThat(count).isEqualTo(-1);
    }

    @Test
    @DisplayName("0")
    void test_12() {
        int number = 0;

        int count = Task6.countK(number);

        assertThat(count).isEqualTo(-1);
    }

    @Test
    @DisplayName("-100")
    void test_13() {
        int number = -100;

        int count = Task6.countK(number);

        assertThat(count).isEqualTo(-1);
    }

    @Test
    @DisplayName("-5694")
    void test_14() {
        int number = -5694;

        int count = Task6.countK(number);

        assertThat(count).isEqualTo(-1);
    }
}
