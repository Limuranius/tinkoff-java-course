package edu.hw1;

public final class Task8 {
    private Task8() {
    }

    static final int[][] KNIGHT_DIRECTIONS = {
        {-1, 2},
        {1, 2},
        {2, 1},
        {2, -1},
        {1, -2},
        {-1, -2},
        {-2, -1},
        {-2, 1}
    };
    static final int BOARD_SIZE = 8;

    public static boolean knightBoardCapture(int[][] board) {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (board[i][j] == 1) {
                    for (var direction : KNIGHT_DIRECTIONS) {
                        int newI = i + direction[0];
                        int newJ = j + direction[1];
                        if ((newI >= 0) & (newI < BOARD_SIZE) & (newJ >= 0) & (newJ < BOARD_SIZE)) {
                            if (board[newI][newJ] == 1) {
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}
