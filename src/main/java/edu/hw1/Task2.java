package edu.hw1;

public final class Task2 {
    private Task2() {}

    public static int countDigits(int number) {
        int remainingDigits = number;
        if (remainingDigits == 0) {
            return 1;
        }
        int digitCount = 0;
        final int removeLastDigitDiv = 10;
        while (remainingDigits != 0) {
            digitCount++;
            remainingDigits /= removeLastDigitDiv;
        }
        return digitCount;
    }
}
