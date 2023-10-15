package edu.hw1;

public class Task8 {
    static int[][] knightDirections = {
        {-1, 2},
        {1, 2},
        {2, 1},
        {2, -1},
        {1, -2},
        {-1, -2},
        {-2, -1},
        {-2, 1}
    };
    public static boolean knightBoardCapture(int[][] board) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == 1) {
                    for (var direction: knightDirections) {
                        int new_i = i + direction[0];
                        int new_j = j + direction[1];
                        if ((new_i >= 0) & (new_i < 8) & (new_j >= 0) & (new_j < 8)) {
                            if (board[new_i][new_j] == 1)
                                return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
