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
    @DisplayName("35791393:00")
    void validValues_4() {
        String time = "35791393:00";

        int seconds = Task1.minutesToSeconds(time);

        assertThat(seconds).isEqualTo(2147483580);
    }

    @Test
    @DisplayName("35791393:59")
    void validValues_5() {
        String time = "35791393:59";

        int seconds = Task1.minutesToSeconds(time);

        assertThat(seconds).isEqualTo(2147483639);
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

    @Test
    @DisplayName("6:-5")
    void nonValidValues_4() {
        String time = "6:-5";

        int seconds = Task1.minutesToSeconds(time);

        assertThat(seconds).isEqualTo(-1);
    }

    @Test
    @DisplayName("99999999999999999:00")
    void nonValidValues_5() {
        String time = "99999999999999999:00";

        int seconds = Task1.minutesToSeconds(time);

        assertThat(seconds).isEqualTo(-1);
    }

    @Test
    @DisplayName("5dfdfdf9:30")
    void nonValidValues_6() {
        String time = "5dfdfdf9:30";

        int seconds = Task1.minutesToSeconds(time);

        assertThat(seconds).isEqualTo(-1);
    }

    @Test
    @DisplayName("10:a3")
    void nonValidValues_7() {
        String time = "10:a3";

        int seconds = Task1.minutesToSeconds(time);

        assertThat(seconds).isEqualTo(-1);
    }

    @Test
    @DisplayName("10:3a")
    void nonValidValues_8() {
        String time = "10:3a";

        int seconds = Task1.minutesToSeconds(time);

        assertThat(seconds).isEqualTo(-1);
    }

    @Test
    @DisplayName("10:10:10")
    void nonValidValues_9() {
        String time = "10:10:10";

        int seconds = Task1.minutesToSeconds(time);

        assertThat(seconds).isEqualTo(-1);
    }

    @Test
    @DisplayName("1010")
    void nonValidValues_10() {
        String time = "1010";

        int seconds = Task1.minutesToSeconds(time);

        assertThat(seconds).isEqualTo(-1);
    }

    @Test
    @DisplayName("2147483647:00")
    void nonValidValues_11() {
        String time = "2147483647:12";

        int seconds = Task1.minutesToSeconds(time);

        assertThat(seconds).isEqualTo(-1);
    }

    @Test
    @DisplayName("35791394:00")
    void nonValidValues_12() {
        String time = "35791394:00";

        int seconds = Task1.minutesToSeconds(time);

        assertThat(seconds).isEqualTo(-1);
    }
}
