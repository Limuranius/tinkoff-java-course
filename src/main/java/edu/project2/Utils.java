package edu.project2;

import java.util.Random;

public class Utils {
    private Utils() {
    }

    public static int randInt(int a, int b) {
        // Random int from a to b (inclusive)
        Random rand = new Random();

        return rand.nextInt(b - a + 1) + a;
    }

    public static boolean randBool() {
        return randInt(1, 2) == 2;
    }

    public static String char2DtoStr(Character[][] charArr) {
        var sb = new StringBuilder();
        for (var row : charArr) {
            for (var cellChar : row) {
                sb.append(cellChar);
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public static boolean inBounds(int x, int y, int width, int height) {
        return (0 <= x && x < width && 0 <= y && y < height);
    }
}
