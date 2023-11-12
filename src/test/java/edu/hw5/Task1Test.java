package edu.hw5;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.Duration;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class Task1Test {
    @Test
    @DisplayName("Valid intervals")
    void test1() {
        List<String> intervals = List.of(
            "2022-03-12, 20:20 - 2022-03-12, 23:50",    // 210
            "2022-04-01, 21:30 - 2022-04-02, 01:20"     // 230
        );

        Duration duration = Task1.calculateAverageDuration(intervals);

        Assertions.assertThat(duration.toMinutes()).isEqualTo(220);
    }

    @Test
    @DisplayName("One interval")
    void test2() {
        List<String> intervals = List.of(
            "2022-03-12, 20:20 - 2022-03-12, 23:50"    // 210
        );

        Duration duration = Task1.calculateAverageDuration(intervals);

        Assertions.assertThat(duration.toMinutes()).isEqualTo(210);
    }

    @Test
    @DisplayName("Empty")
    void test3() {
        List<String> intervals = List.of(
        );

        Duration duration = Task1.calculateAverageDuration(intervals);

        Assertions.assertThat(duration.toMinutes()).isEqualTo(0);
    }

    @Test
    @DisplayName("First date is after second date")
    void test4() {
        List<String> intervals = List.of(
            "2022-03-12, 20:20 - 2022-03-12, 23:50",
            "2022-04-02, 01:20 - 2022-04-01, 21:30"
        );

        assertThatThrownBy(() -> Task1.calculateAverageDuration(intervals));
    }

    @Test
    @DisplayName("Invalid date format")
    void test5() {
        List<String> intervals = List.of(
            "2022-03-12, 20:20 - 2022-03-12, 23:50",
            "DROP TABLE users;",
            "2022-04-01, 21:30 - 2022-04-02, 01:20"
        );

        assertThatThrownBy(() -> Task1.calculateAverageDuration(intervals));
    }
}
