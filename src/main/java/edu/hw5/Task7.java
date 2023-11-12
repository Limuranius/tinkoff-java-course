package edu.hw5;

public class Task7 {
    private static final String REGEX_1 = "[01]{2}0[01]*";
    private static final String REGEX_2 = "([01]).*\\1";
    private static final String REGEX_3 = "[01]{1,3}";

    private Task7() {
    }

    public static boolean matchRegex(int regexNumber, String string) {
        var regexes = new String[] {REGEX_1, REGEX_2, REGEX_3};
        return string.matches(regexes[regexNumber - 1]);
    }
}
