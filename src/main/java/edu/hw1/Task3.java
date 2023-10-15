package edu.hw1;

public class Task3 {
    public static boolean isNestable(int[] a1, int[] a2) {
        if (a1.length == 0) {
            return true;
        }
        if (a2.length == 0) {
            return false;
        }
        int min_a1 = min(a1);
        int max_a1 = max(a1);
        int min_a2 = min(a2);
        int max_a2 = max(a2);

        return (min_a1 > min_a2) & (max_a1 < max_a2);
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
