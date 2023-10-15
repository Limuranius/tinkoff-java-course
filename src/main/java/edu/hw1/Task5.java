package edu.hw1;

public class Task5 {
    public static boolean isPalindromeDescendant(int number) {
        if (number < 0) {
            return false;
        }
        do {
            if (isPalindrome(number)) {
                return true;
            }
            number = descend(number);
        } while (number > 9);
        return false;
    }

    static boolean isPalindrome(int number) {
        int leftPart = number;
        int rightPart = 0;
        while (leftPart > rightPart) {
            rightPart *= 10;
            rightPart += leftPart % 10;
            leftPart /= 10;
        }
        return (leftPart == rightPart) || (rightPart / 10 == leftPart);
    }

    static int descend(int number) {
        int digitCount = Task2.countDigits(number);
        int pairsCount = (digitCount + 1) / 2;
        int[] digitPairs = new int[pairsCount];
        if (digitCount % 2 == 1) {
            digitPairs[pairsCount - 1] = (number % 10) * 10;
            number /= 10;
        } else {
            digitPairs[pairsCount - 1] = number % 100;
            number /= 100;
        }
        for (int i = pairsCount - 2; i >= 0; i--) {
            digitPairs[i] = number % 100;
            number /= 100;
        }

        int result = 0;
        for (int digitPair : digitPairs) {
            int d1 = digitPair / 10;
            int d2 = digitPair % 10;
            int digitSum = d1 + d2;
            if (digitSum > 10) {
                result = result * 100 + digitSum;
            } else {
                result = result * 10 + digitSum;
            }
        }
        return result;
    }
}
