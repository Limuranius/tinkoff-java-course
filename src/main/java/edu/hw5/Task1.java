package edu.hw5;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Task1 {
    private static final String INTERVAL_STR_REGEX =
        "\\d{4}-\\d{2}-\\d{2}, \\d{2}:\\d{2} - \\d{4}-\\d{2}-\\d{2}, \\d{2}:\\d{2}";
    private static final String DATE_TIME_FORMAT = "yyyy-MM-dd, HH:mm";
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern(DATE_TIME_FORMAT);

    private Task1() {
    }

    private static void validateInterval(String intervalStr) {
        boolean regexMatch = intervalStr.matches(INTERVAL_STR_REGEX);
        if (!regexMatch) {
            throw new RuntimeException("Date does not match format");
        }

        Interval interval = Interval.fromString(intervalStr);
        boolean timeOrdered = interval.to.isAfter(interval.from) || interval.to.isEqual(interval.from);
        if (!timeOrdered) {
            throw new RuntimeException("Second time comes before first");
        }
    }

    private static Duration getDuration(String intervalStr) {
        return Interval.fromString(intervalStr).duration;
    }

    public static Duration calculateAverageDuration(List<String> intervalStrings) {
        long totalMinutes = 0;
        for (var intervalStr : intervalStrings) {
            validateInterval(intervalStr);
            Duration duration = getDuration(intervalStr);
            totalMinutes += duration.toMinutes();
        }

        long avgMinutes;
        if (intervalStrings.isEmpty()) {
            avgMinutes = 0;
        } else {
            avgMinutes = totalMinutes / intervalStrings.size();
        }
        return Duration.ofMinutes(avgMinutes);
    }

    private record Interval(LocalDateTime from, LocalDateTime to, Duration duration) {
        static Interval fromString(String intervalStr) {
            var dateStrings = intervalStr.split(" - ");
            LocalDateTime from = LocalDateTime.parse(dateStrings[0], DATE_TIME_FORMATTER);
            LocalDateTime to = LocalDateTime.parse(dateStrings[1], DATE_TIME_FORMATTER);
            Duration duration = Duration.between(from, to);
            return new Interval(from, to, duration);
        }
    }
}
