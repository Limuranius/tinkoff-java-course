package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task1Test {
    @Test
    @DisplayName("01:00")
    void validValues_1() {
        String time = "01:00";

        int seconds = Task1.minutesToSeconds(time);

        assertThat(seconds).isEqualTo(60);
    }

    @Test
    @DisplayName("13:56")
    void validValues_2() {
        String time = "13:56";

        int seconds = Task1.minutesToSeconds(time);

        assertThat(seconds).isEqualTo(836);
    }

    @Test
    @DisplayName("999:59")
    void validValues_3() {
        String time = "999:59";

        int seconds = Task1.minutesToSeconds(time);

        assertThat(seconds).isEqualTo(59999);
    }

    @Test
    @DisplayName("10:60")
    void nonValidValues_1() {
        String time = "10:60";

        int seconds = Task1.minutesToSeconds(time);

        assertThat(seconds).isEqualTo(-1);
    }

    @Test
    @DisplayName("-5:30")
    void nonValidValues_2() {
        String time = "-5:30";

        int seconds = Task1.minutesToSeconds(time);

        assertThat(seconds).isEqualTo(-1);
    }

    @Test
    @DisplayName("6:-05")
    void nonValidValues_3() {
        String time = "6:-05";

        int seconds = Task1.minutesToSeconds(time);

        assertThat(seconds).isEqualTo(-1);
    }
}
