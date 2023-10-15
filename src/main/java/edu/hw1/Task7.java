package edu.hw1;

public class Task7 {
    public static int rotateRight(int number, int shiftSize) {
        int bitCount = countBits(number);
        shiftSize = ((shiftSize % bitCount) + bitCount) % bitCount;
        int remainSize = bitCount - shiftSize;

        int shiftedPartMask = (1 << shiftSize) - 1;
        int shiftedPart = number & shiftedPartMask;
        return (number >> shiftSize) | (shiftedPart << remainSize);
    }

    public static int rotateLeft(int number, int shiftSize) {
        int bitCount = countBits(number);
        shiftSize = ((shiftSize % bitCount) + bitCount) % bitCount;
        int remainSize = bitCount - shiftSize;

        int shiftedPartMask = ((1 << shiftSize) - 1) << remainSize;
        int shiftedPart = (number & shiftedPartMask) >> remainSize;
        return ((number << shiftSize) | shiftedPart) & ((1 << bitCount) - 1);
    }

    public static int countBits(int number) {
        int count = 0;
        while (number != 0) {
            number >>= 1;
            count++;
        }
        return count;
    }
}
