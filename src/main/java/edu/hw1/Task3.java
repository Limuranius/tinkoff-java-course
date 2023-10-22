package edu.hw1;

public final class Task3 {
    private Task3() {
    }

    public static boolean isNestable(int[] a1, int[] a2) {
        if (a1.length == 0) {
            return true;
        }
        if (a2.length == 0) {
            return false;
        }
        int minA1 = min(a1);
        int maxA1 = max(a1);
        int minA2 = min(a2);
        int maxA2 = max(a2);

        return (minA1 > minA2) & (maxA1 < maxA2);
    }

    private static int min(int[] a) {
        int result = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] < result) {
                result = a[i];
            }
        }
        return result;
    }

    private static int max(int[] a) {
        int result = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] > result) {
                result = a[i];
            }
        }
        return result;
    }
}
