package edu.hw5;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class Task2 {
    private static final int THIRTEENTH_DAY = 13;

    private Task2() {
    }

    public static List<Calendar> findAllFriday13(int year) {
        Calendar currDate = new GregorianCalendar(year, Calendar.JANUARY, THIRTEENTH_DAY);
        List<Calendar> result = new ArrayList<>();
        while (currDate.get(Calendar.YEAR) == year) {
            if (currDate.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY) {
                result.add((Calendar) currDate.clone());
            }
            currDate.add(Calendar.MONTH, 1);
        }
        return result;
    }

    public static class NextFriday13 implements TemporalAdjuster {

        @Override
        public Temporal adjustInto(Temporal temporal) {
            LocalDate currDate = LocalDate.of(
                temporal.get(ChronoField.YEAR),
                temporal.get(ChronoField.MONTH_OF_YEAR),
                THIRTEENTH_DAY
            );
            if (temporal.get(ChronoField.DAY_OF_MONTH) >= THIRTEENTH_DAY) {
                currDate = currDate.plusMonths(1);
            }
            while (currDate.getDayOfWeek() != DayOfWeek.FRIDAY) {
                currDate = currDate.plusMonths(1);
            }
            return currDate;
        }
    }
}
