package edu.hw1;

public final class Task7 {
    private Task7() {
    }

    public static int rotateRight(int number, int shiftSize) {
        if (number < 0) {
            return -1;
        } else if (number == 0) {
            return 0;
        }
        int bitCount = countBits(number);
        int normalizedShiftSize = ((shiftSize % bitCount) + bitCount) % bitCount;
        int remainSize = bitCount - normalizedShiftSize;

        int shiftedPartMask = (1 << normalizedShiftSize) - 1;
        int shiftedPart = number & shiftedPartMask;
        return (number >> normalizedShiftSize) | (shiftedPart << remainSize);
    }

    public static int rotateLeft(int number, int shiftSize) {
        if (number < 0) {
            return -1;
        } else if (number == 0) {
            return 0;
        }
        int bitCount = countBits(number);
        int normalizedShiftSize = ((shiftSize % bitCount) + bitCount) % bitCount;
        int remainSize = bitCount - normalizedShiftSize;

        int shiftedPartMask = ((1 << normalizedShiftSize) - 1) << remainSize;
        int shiftedPart = (number & shiftedPartMask) >> remainSize;
        return ((number << normalizedShiftSize) | shiftedPart) & ((1 << bitCount) - 1);
    }

    private static int countBits(int number) {
        int count = 0;
        int remainingBits = number;
        while (remainingBits != 0) {
            remainingBits >>= 1;
            count++;
        }
        return count;
    }
}
