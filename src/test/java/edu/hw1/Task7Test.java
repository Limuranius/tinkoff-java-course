package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task7Test {
    @Test
    @DisplayName("Right 8 1")
    void right_1() {
        assertThat(Task7.rotateRight(8, 1))
            .isEqualTo(4);
    }

    @Test
    @DisplayName("Right 7 123")
    void right_2() {
        assertThat(Task7.rotateRight(7, 123))
            .isEqualTo(7);
    }

    @Test
    @DisplayName("Left 16 1")
    void left_1() {
        assertThat(Task7.rotateLeft(16, 1))
            .isEqualTo(1);
    }

    @Test
    @DisplayName("Left 17 2")
    void left_2() {
        assertThat(Task7.rotateLeft(17, 2))
            .isEqualTo(6);
    }

    @Test
    @DisplayName("Negative rotate left")
    void negativeLeft() {
        assertThat(Task7.rotateLeft(55, -1))
            .isEqualTo(59);
    }

    @Test
    @DisplayName("Negative rotate right")
    void negativeRight() {
        assertThat(Task7.rotateRight(69, -2))
            .isEqualTo(22);
    }

    @Test
    @DisplayName("Rotate 0 to left")
    void rotateZeroLeft() {
        assertThat(Task7.rotateLeft(0, 5))
            .isEqualTo(0);
    }

    @Test
    @DisplayName("Rotate 0 to right")
    void rotateZeroRight() {
        assertThat(Task7.rotateRight(0, 5))
            .isEqualTo(0);
    }

    @Test
    @DisplayName("Rotate by 0 to left")
    void rotateByZeroLeft() {
        assertThat(Task7.rotateLeft(123, 0))
            .isEqualTo(123);
    }

    @Test
    @DisplayName("Rotate by 0 to right")
    void rotateByZeroRight() {
        assertThat(Task7.rotateRight(123, 0))
            .isEqualTo(123);
    }
}
