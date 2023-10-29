package edu.hw3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task3Tests {
    @Test
    @DisplayName("All values equal")
    void test1() {
        var arr = List.of("az", "az", "az", "az");

        var counter = Task3.freqDict(arr);

        assertThat(counter.size()).isEqualTo(1);
        assertThat(counter.get("az")).isEqualTo(4);
    }

    @Test
    @DisplayName("All values unique")
    void test2() {
        var arr = List.of(1, 2, 3, 4, 5, 6);

        var counter = Task3.freqDict(arr);

        assertThat(counter.size()).isEqualTo(6);
        assertThat(counter.get(1)).isEqualTo(1);
        assertThat(counter.get(2)).isEqualTo(1);
        assertThat(counter.get(3)).isEqualTo(1);
        assertThat(counter.get(4)).isEqualTo(1);
        assertThat(counter.get(5)).isEqualTo(1);
        assertThat(counter.get(6)).isEqualTo(1);
    }

    @Test
    @DisplayName("Empty list")
    void test3() {
        ArrayList<Integer> arr = new ArrayList<>();

        var counter = Task3.freqDict(arr);

        assertThat(counter.size()).isEqualTo(0);
    }
}
