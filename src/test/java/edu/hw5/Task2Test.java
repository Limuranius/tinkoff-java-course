package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.time.Month;
import java.util.Calendar;
import static org.assertj.core.api.Assertions.assertThat;

public class Task2Test {
    @Test
    @DisplayName("2012 (3 months)")
    void test1() {
        int year = 2012;

        var dates = Task2.findAllFriday13(year);

        assertThat(dates)
            .hasSize(3)
            .extracting((calendar -> calendar.get(Calendar.MONTH)))
            .containsExactlyInAnyOrder(
                Calendar.JANUARY,
                Calendar.APRIL,
                Calendar.JULY
            );

        assertThat(dates)
            .extracting((calendar -> calendar.get(Calendar.DAY_OF_MONTH)))
            .containsExactlyInAnyOrder(
                13,
                13,
                13
            );
    }

    @Test
    @DisplayName("2010 (1 month)")
    void test2() {
        int year = 2010;

        var dates = Task2.findAllFriday13(year);

        assertThat(dates)
            .hasSize(1)
            .extracting((calendar -> calendar.get(Calendar.MONTH)))
            .containsExactlyInAnyOrder(
                Calendar.AUGUST
            );

        assertThat(dates)
            .extracting((calendar -> calendar.get(Calendar.DAY_OF_MONTH)))
            .containsExactlyInAnyOrder(
                13
            );
    }

    @Test
    @DisplayName("Closest to 01.01.2011")
    void test3() {
        LocalDate date = LocalDate.of(2011, Month.JANUARY, 1);
        var nextDate = date.with(new Task2.NextFriday13());

        assertThat(nextDate).isEqualTo(
            LocalDate.of(2011, Month.MAY, 13)
        );
    }

    @Test
    @DisplayName("Closest to 20.12.2011")
    void test4() {
        LocalDate date = LocalDate.of(2011, Month.DECEMBER, 20);
        var nextDate = date.with(new Task2.NextFriday13());

        assertThat(nextDate).isEqualTo(
            LocalDate.of(2012, Month.JANUARY, 13)
        );
    }
}
