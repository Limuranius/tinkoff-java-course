package edu.hw1;

public class Task1 {
    public static int minutesToSeconds(String timeStr) {
        var timeParts = timeStr.split(":");
        int minutes = Integer.parseInt(timeParts[0]);
        int seconds = Integer.parseInt(timeParts[1]);
        if (seconds >= 60 || seconds < 0 || minutes < 0) {
            return -1;
        }
        return minutes * 60 + seconds;
    }
}
