package edu.hw1;

public class Task2 {
    public static int countDigits(int number) {
        if (number == 0) {
            return 1;
        }
        int digitCount = 0;
        while (number != 0) {
            digitCount++;
            number /= 10;
        }
        return digitCount;
    }
}
