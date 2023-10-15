package edu.hw1;

public class Task4 {
    public static String fixString(String brokenString) {
        int n = brokenString.length();
        char[] fixedCharArray = new char[n];
        for (int i = 1; i < n; i += 2) {
            fixedCharArray[i-1] = brokenString.charAt(i);
            fixedCharArray[i] = brokenString.charAt(i-1);
        }
        if (n % 2 == 1) {
            fixedCharArray[n-1] = brokenString.charAt(n-1);
        }
        return new String(fixedCharArray);
    }
}
