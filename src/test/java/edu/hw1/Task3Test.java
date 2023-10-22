package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task3Test {
    @Test
    @DisplayName("a1 Nestable")
    void nestable() {
        int[] a1 = {1, 2, 3, 4};
        int[] a2 = {0, 6};

        boolean isNestable = Task3.isNestable(a1, a2);

        assertThat(isNestable).isTrue();
    }

    @Test
    @DisplayName("Borders are equal")
    void bordersEqual() {
        int[] a1 = {1, 2, 3, 4};
        int[] a2 = {1, 4};

        boolean isNestable = Task3.isNestable(a1, a2);

        assertThat(isNestable).isFalse();
    }

    @Test
    @DisplayName("a1 borders are bigger than a2's")
    void bordersBigger() {
        int[] a1 = {-1, 2, 3, 7};
        int[] a2 = {0, 6};

        boolean isNestable = Task3.isNestable(a1, a2);

        assertThat(isNestable).isFalse();
    }

    @Test
    @DisplayName("Empty a1")
    void emptyA1() {
        int[] a1 = {};
        int[] a2 = {0, 6};

        boolean isNestable = Task3.isNestable(a1, a2);

        assertThat(isNestable).isTrue();
    }

    @Test
    @DisplayName("Empty a2")
    void emptyA2() {
        int[] a1 = {1, 2, 3, 4};
        int[] a2 = {};

        boolean isNestable = Task3.isNestable(a1, a2);

        assertThat(isNestable).isFalse();
    }
}
