package edu.hw5;

public class Task5 {
    private static final String REGEX = "[АВЕКМНОРСТУХ]\\d{3}(?<!000)[АВЕКМНОРСТУХ]{2}\\d{3}";

    private Task5() {}

    public static boolean validateNumberPlate(String string) {
        return string.matches(REGEX);
    }
}
