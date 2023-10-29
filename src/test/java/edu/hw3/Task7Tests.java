package edu.hw3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.TreeMap;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task7Tests {
    @Test
    @DisplayName("Insert null")
    void test1() {
        TreeMap<String, String> tree = new TreeMap<>(new Task7.TreeMapComparator<>());
        tree.put(null, "test");

        assertThat(tree.containsKey(null)).isTrue();
        assertThat(tree.get(null)).isEqualTo("test");
    }
}
