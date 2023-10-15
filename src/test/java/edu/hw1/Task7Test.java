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
}
