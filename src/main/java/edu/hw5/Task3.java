package edu.hw5;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task3 {
    private static final DateParseChainNode PARSER = DateParseChainNode.link(
        new DateParse1(),
        new DateParse2(),
        new DateParse3(),
        new DateParse4()
    );

    private Task3() {
    }

    public static Optional<LocalDate> parseDate(String string) {
        return PARSER.check(string);
    }

    private static abstract class DateParseChainNode {
        private DateParseChainNode next;

        public static DateParseChainNode link(DateParseChainNode first, DateParseChainNode... chain) {
            DateParseChainNode head = first;
            for (DateParseChainNode nextInChain : chain) {
                head.next = nextInChain;
                head = nextInChain;
            }
            return first;
        }

        public abstract Optional<LocalDate> check(String string);

        protected Optional<LocalDate> checkNext(String string) {
            if (next == null) {
                return Optional.empty();
            } else {
                return next.check(string);
            }
        }
    }

    private static class DateParse1 extends DateParseChainNode {
        /*
        2020-10-10
        2020-12-2
         */
        private static final String PATTERN = "uuuu-M-d";
        private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern(PATTERN);

        @Override
        public Optional<LocalDate> check(String string) {
            try {
                var result = LocalDate.parse(string, FORMATTER);
                return Optional.of(result);
            } catch (DateTimeParseException e) {
                return checkNext(string);
            }
        }
    }

    private static class DateParse2 extends DateParseChainNode {
        /*
        1/3/1976
        1/3/20
         */
        private static final String PATTERN = "d/M/[uuuu][uu]";
        private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern(PATTERN);

        @Override
        public Optional<LocalDate> check(String string) {
            try {
                var result = LocalDate.parse(string, FORMATTER);
                return Optional.of(result);
            } catch (DateTimeParseException e) {
                return checkNext(string);
            }
        }
    }

    private static class DateParse3 extends DateParseChainNode {
        /*
        tomorrow
        today
        yesterday
         */
        @Override
        public Optional<LocalDate> check(String string) {
            switch (string) {
                case "tomorrow" -> {
                    LocalDate today = LocalDate.now();
                    return Optional.of(today.plusDays(1));
                }
                case "today" -> {

                    return Optional.of(LocalDate.now());
                }
                case "yesterday" -> {
                    LocalDate today = LocalDate.now();
                    return Optional.of(today.minusDays(1));
                }
                default -> {
                    return this.checkNext(string);
                }
            }
        }
    }

    private static class DateParse4 extends DateParseChainNode {
        /*
        1 day ago
        2234 days ago
         */

        private static final String REGEXP = "([0-9]+) days? ago";
        private static final Pattern PATTERN = Pattern.compile(REGEXP);

        @Override
        public Optional<LocalDate> check(String string) {
            if (string.matches(REGEXP)) {
                Matcher m = PATTERN.matcher(string);
                m.find();
                int days = Integer.parseInt(m.group(1));
                LocalDate today = LocalDate.now();
                return Optional.of(today.minusDays(days));
            } else {
                return this.checkNext(string);
            }
        }
    }
}
