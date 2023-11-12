package edu.hw5;

//~!@#$%^&*|

public class Task4 {
    private static final String REGEX = "[^~!@#$%^&*|]*[~!@#$%^&*|][^~!@#$%^&*|]*";

    private Task4() {
    }

    public static boolean validatePassword(String password) {
        return password.matches(REGEX);
    }

}
