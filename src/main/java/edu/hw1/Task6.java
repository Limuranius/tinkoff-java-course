package edu.hw1;

import java.util.Arrays;
import java.util.Collections;

public class Task6 {
    public static int countK(int number) {
        if (number == 6174) {
            return 0;
        }
        return 1 + countK(descDigits(number) - ascDigits(number));
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
        for (int digit: digits) {
            result = result * 10 + digit;
        }
        return result;
    }

    private static int ascDigits(int number) {
        var digitsArr = intToDigitsArr(number);
        Arrays.sort(digitsArr);
        return digitsArrToInt(digitsArr);
    }

    private static int descDigits(int number) {
        var digitsArr = intToDigitsArr(number);
        Arrays.sort(digitsArr, Collections.reverseOrder());
        return digitsArrToInt(digitsArr);
    }
}
