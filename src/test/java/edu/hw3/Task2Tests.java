package edu.hw3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task2Tests {
    @Test
    @DisplayName("Empty string")
    void test1() {
        String s = "";

        var clusters = Task2.clusterize(s);

        assertThat(clusters.size())
            .isEqualTo(0);
    }

    @Test
    @DisplayName(")(")
    void test2() {
        String s = ")(";

        var clusters = Task2.clusterize(s);

        assertThat(clusters.size())
            .isEqualTo(0);
    }

    @Test
    @DisplayName("))()")
    void test3() {
        String s = "))()";

        var clusters = Task2.clusterize(s);

        assertThat(clusters.size()).isEqualTo(1);
        assertThat(clusters.get(0)).isEqualTo("()");
    }

    @Test
    @DisplayName("(())")
    void test4() {
        String s = "(())";

        var clusters = Task2.clusterize(s);

        assertThat(clusters.size()).isEqualTo(1);
        assertThat(clusters.get(0)).isEqualTo("(())");
    }

    @Test
    @DisplayName("()()")
    void test5() {
        String s = "()()";

        var clusters = Task2.clusterize(s);

        assertThat(clusters.size()).isEqualTo(2);
        assertThat(clusters.get(0)).isEqualTo("()");
        assertThat(clusters.get(1)).isEqualTo("()");
    }

    @Test
    @DisplayName(")()()(")
    void test6() {
        String s = ")()()(";

        var clusters = Task2.clusterize(s);

        assertThat(clusters.size()).isEqualTo(2);
        assertThat(clusters.get(0)).isEqualTo("()");
        assertThat(clusters.get(1)).isEqualTo("()");
    }

    @Test
    @DisplayName("(abc)   (a(b)c)")
    void test7() {
        String s = "(abc)   (a(b)c)";

        var clusters = Task2.clusterize(s);

        assertThat(clusters.size()).isEqualTo(2);
        assertThat(clusters.get(0)).isEqualTo("()");
        assertThat(clusters.get(1)).isEqualTo("(())");
    }
}
