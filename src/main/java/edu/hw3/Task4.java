package edu.hw3;


public class Task4 {
    private static final int[] NUMBERS = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static final String[] ROMANS = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    private Task4() {
    }

    public static String convertToRoman(int number) {
        if (number < 0) {
            throw new RuntimeException("Negative number");
        }

        StringBuilder sb = new StringBuilder();

        int remainder = number;
        for (int i = 0; i < NUMBERS.length; i++) {
            while (remainder >= NUMBERS[i]) {
                remainder -= NUMBERS[i];
                sb.append(ROMANS[i]);
            }
        }
        return sb.toString();
    }
}
