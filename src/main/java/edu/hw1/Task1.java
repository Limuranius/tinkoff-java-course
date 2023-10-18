package edu.hw1;

public final class Task1 {
    private static final int SECONDS_IN_MINUTE = 60;

    private Task1() {}

    public static int minutesToSeconds(String timeStr) {
        var timeParts = timeStr.split(":");
        int minutes = Integer.parseInt(timeParts[0]);
        int seconds = Integer.parseInt(timeParts[1]);
        if (seconds >= SECONDS_IN_MINUTE || seconds < 0 || minutes < 0) {
            return -1;
        }
        return minutes * SECONDS_IN_MINUTE + seconds;
    }
}
