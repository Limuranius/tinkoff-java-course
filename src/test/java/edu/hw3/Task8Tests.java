package edu.hw3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task8Tests {
    @Test
    @DisplayName("Backwards check")
    void test1() {
        var iterator = new BackwardIterator<>(List.of(4, 10, 9, 4, 11));

        assertThat(iterator.hasNext()).isTrue();
        assertThat(iterator.next()).isEqualTo(11);
        assertThat(iterator.next()).isEqualTo(4);
        assertThat(iterator.next()).isEqualTo(9);
        assertThat(iterator.next()).isEqualTo(10);
        assertThat(iterator.hasNext()).isTrue();
        assertThat(iterator.next()).isEqualTo(4);
        assertThat(iterator.hasNext()).isFalse();
    }
}
