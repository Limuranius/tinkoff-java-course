package edu.hw1;

public final class Task1 {
    private static final int SECONDS_IN_MINUTE = 60;
    private static final int MAX_MINUTES_VALUE = Integer.MAX_VALUE / SECONDS_IN_MINUTE - 1;
    private static final String MAX_MINUTES_STR = Integer.toString(MAX_MINUTES_VALUE);

    private Task1() {}

    public static int minutesToSeconds(String timeStr) {
        var timeParts = timeStr.split(":");

        if (timeParts.length != 2) {
            return -1;
        }

        String minutesStr = timeParts[0];
        String secondsStr = timeParts[1];

        boolean minutesValid = minutesStr.matches("[0-9]*");
        boolean secondsValid = secondsStr.matches("([0-5][0-9]|[0-9])");
        boolean minutesOverflow = (
            (MAX_MINUTES_STR.length() == minutesStr.length() && minutesStr.compareTo(MAX_MINUTES_STR) > 0)
            || (minutesStr.length() > MAX_MINUTES_STR.length())
        );
        if (!minutesValid || !secondsValid || minutesOverflow) {
            return -1;
        }

        int minutes = Integer.parseInt(minutesStr);
        int seconds = Integer.parseInt(secondsStr);
        return minutes * SECONDS_IN_MINUTE + seconds;
    }
}
