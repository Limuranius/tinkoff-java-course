package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.time.Month;
import static org.assertj.core.api.Assertions.assertThat;

public class Task3Test {
    @Test
    @DisplayName("2020-10-10")
    void test1() {
        String string = "2020-10-10";

        var resultDate = Task3.parseDate(string);

        assertThat(resultDate).isNotEmpty();
        assertThat(resultDate.get()).isEqualTo(
            LocalDate.of(2020, Month.OCTOBER, 10)
        );
    }

    @Test
    @DisplayName("2020-12-2")
    void test2() {
        String string = "2020-12-2";

        var resultDate = Task3.parseDate(string);

        assertThat(resultDate).isNotEmpty();
        assertThat(resultDate.get()).isEqualTo(
            LocalDate.of(2020, Month.DECEMBER, 2)
        );
    }

    @Test
    @DisplayName("1918-1-1")
    void test3() {
        String string = "1918-1-1";

        var resultDate = Task3.parseDate(string);

        assertThat(resultDate).isNotEmpty();
        assertThat(resultDate.get()).isEqualTo(
            LocalDate.of(1918, Month.JANUARY, 1)
        );
    }

    @Test
    @DisplayName("1/3/1976")
    void test4() {
        String string = "1/3/1976";

        var resultDate = Task3.parseDate(string);

        assertThat(resultDate).isNotEmpty();
        assertThat(resultDate.get()).isEqualTo(
            LocalDate.of(1976, Month.MARCH, 1)
        );
    }

    @Test
    @DisplayName("1/3/20")
    void test5() {
        String string = "1/3/20";

        var resultDate = Task3.parseDate(string);

        assertThat(resultDate).isNotEmpty();
        assertThat(resultDate.get()).isEqualTo(
            LocalDate.of(2020, Month.MARCH, 1)
        );
    }

    @Test
    @DisplayName("01/03/20")
    void test6() {
        String string = "01/03/20";

        var resultDate = Task3.parseDate(string);

        assertThat(resultDate).isNotEmpty();
        assertThat(resultDate.get()).isEqualTo(
            LocalDate.of(2020, Month.MARCH, 1)
        );
    }

    @Test
    @DisplayName("tomorrow")
    void test7() {
        String string = "tomorrow";

        var resultDate = Task3.parseDate(string);

        assertThat(resultDate).isNotEmpty();
        assertThat(resultDate.get()).isEqualTo(
            LocalDate.now().plusDays(1)
        );
    }

    @Test
    @DisplayName("today")
    void test8() {
        String string = "today";

        var resultDate = Task3.parseDate(string);

        assertThat(resultDate).isNotEmpty();
        assertThat(resultDate.get()).isEqualTo(
            LocalDate.now()
        );
    }

    @Test
    @DisplayName("yesterday")
    void test9() {
        String string = "yesterday";

        var resultDate = Task3.parseDate(string);

        assertThat(resultDate).isNotEmpty();
        assertThat(resultDate.get()).isEqualTo(
            LocalDate.now().minusDays(1)
        );
    }

    @Test
    @DisplayName("1 day ago")
    void test10() {
        String string = "1 day ago";

        var resultDate = Task3.parseDate(string);

        assertThat(resultDate).isNotEmpty();
        assertThat(resultDate.get()).isEqualTo(
            LocalDate.now().minusDays(1)
        );
    }

    @Test
    @DisplayName("2234 days ago")
    void test11() {
        String string = "2234 days ago";

        var resultDate = Task3.parseDate(string);

        assertThat(resultDate).isNotEmpty();
        assertThat(resultDate.get()).isEqualTo(
            LocalDate.now().minusDays(2234)
        );
    }

    @Test
    @DisplayName("-5 days ago")
    void test12() {
        String string = "-5 days ago";

        var resultDate = Task3.parseDate(string);

        assertThat(resultDate).isEmpty();
    }

    @Test
    @DisplayName("DROP TABLE user;")
    void test13() {
        String string = "DROP TABLE user;";

        var resultDate = Task3.parseDate(string);

        assertThat(resultDate).isEmpty();
    }
}
