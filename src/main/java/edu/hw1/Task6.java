package edu.hw1;

import java.util.Arrays;
import java.util.Collections;

public final class Task6 {
    static private final int KAPREKAR_NUMBER = 6174;
    static private final int LOWER_BOUND = 1001;
    static private final int UPPER_BOUND = 9999;
    static private final int ALL_ONES = 1111;

    private Task6() {
    }

    public static int countK(int number) {
        boolean equalDigits = number % ALL_ONES == 0;
        boolean inBounds = (number >= LOWER_BOUND) && (number <= UPPER_BOUND);
        if (equalDigits || !inBounds) {
            return -1;
        }
        return countKRecursive(number);
    }

    private static int countKRecursive(int number) {
        if (number == KAPREKAR_NUMBER) {
            return 0;
        }
        return 1 + countKRecursive(descDigits(number) - ascDigits(number));
    }

    private static Integer[] intToDigitsArr(int number) {
        String temp = Integer.toString(number);
        Integer[] arr = new Integer[temp.length()];
        for (int i = 0; i < temp.length(); i++) {
            arr[i] = temp.charAt(i) - '0';
        }
        return arr;
    }

    private static int digitsArrToInt(Integer[] digits) {
        int result = 0;
        final int MOVE_DIGIT = 10;
        for (int digit : digits) {
            result = result * MOVE_DIGIT + digit;
        }
        return result;
    }

    private static int ascDigits(int number) {
        var digitsArr = intToDigitsArr(number);
        digitsArr = fillZerosToLen4(digitsArr);
        Arrays.sort(digitsArr);
        return digitsArrToInt(digitsArr);
    }

    private static int descDigits(int number) {
        var digitsArr = intToDigitsArr(number);
        digitsArr = fillZerosToLen4(digitsArr);
        Arrays.sort(digitsArr, Collections.reverseOrder());
        return digitsArrToInt(digitsArr);
    }

    private static Integer[] fillZerosToLen4(Integer[] arr) {
        Integer[] newArr = {0, 0, 0, 0};
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        return newArr;
    }
}
