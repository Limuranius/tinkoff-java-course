package edu.hw1;

public final class Task5 {
    static final int SINGLE_DIGIT_MOVE = 10;
    static final int DOUBLE_DIGIT_MOVE = 100;
    static final int MIN_DOUBLE_DIGIT_NUM = 10;

    private Task5() {
    }

    public static boolean isPalindromeDescendant(int number) {
        if (number < 0) {
            return false;
        }
        int currNumber = number;
        do {
            if (isPalindrome(currNumber)) {
                return true;
            }
            currNumber = descend(currNumber);
        } while (currNumber >= MIN_DOUBLE_DIGIT_NUM);
        return false;
    }

    static boolean isPalindrome(int number) {
        int leftPart = number;
        int rightPart = 0;
        while (leftPart > rightPart) {
            rightPart *= SINGLE_DIGIT_MOVE;
            rightPart += leftPart % SINGLE_DIGIT_MOVE;
            leftPart /= SINGLE_DIGIT_MOVE;
        }
        return (leftPart == rightPart) || (rightPart / SINGLE_DIGIT_MOVE == leftPart);
    }

    static int descend(int number) {
        int digitCount = Task2.countDigits(number);
        int pairsCount = (digitCount + 1) / 2;
        int[] digitPairs = new int[pairsCount];
        int currNumber = number;
        if (digitCount % 2 == 1) {
            digitPairs[pairsCount - 1] = (currNumber % SINGLE_DIGIT_MOVE) * SINGLE_DIGIT_MOVE;
            currNumber /= SINGLE_DIGIT_MOVE;
        } else {
            digitPairs[pairsCount - 1] = currNumber % DOUBLE_DIGIT_MOVE;
            currNumber /= DOUBLE_DIGIT_MOVE;
        }
        for (int i = pairsCount - 2; i >= 0; i--) {
            digitPairs[i] = currNumber % DOUBLE_DIGIT_MOVE;
            currNumber /= DOUBLE_DIGIT_MOVE;
        }

        int result = 0;
        for (int digitPair : digitPairs) {
            int d1 = digitPair / SINGLE_DIGIT_MOVE;
            int d2 = digitPair % SINGLE_DIGIT_MOVE;
            int digitSum = d1 + d2;
            final int DOUBLE_DIGIT_NUMBER = 10;
            if (digitSum > DOUBLE_DIGIT_NUMBER) {
                result = result * DOUBLE_DIGIT_MOVE + digitSum;
            } else {
                result = result * SINGLE_DIGIT_MOVE + digitSum;
            }
        }
        return result;
    }
}
