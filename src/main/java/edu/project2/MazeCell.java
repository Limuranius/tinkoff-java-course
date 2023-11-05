package edu.project2;

import java.util.HashMap;
import java.util.Map;

public class MazeCell {
    public final int x;
    public final int y;

    public Map<Direction, Boolean> sideHasWall;

    public MazeCell(int x, int y) {
        this.x = x;
        this.y = y;

        this.sideHasWall = new HashMap<>();
        this.sideHasWall.put(Direction.UP, true);
        this.sideHasWall.put(Direction.RIGHT, true);
        this.sideHasWall.put(Direction.DOWN, true);
        this.sideHasWall.put(Direction.LEFT, true);
    }

    public static void removeWallBetweenCells(MazeCell c1, MazeCell c2) {
        int dist = Math.abs(c1.x - c2.x) + Math.abs(c1.y - c2.y);
        if (dist != 1) {
            throw new RuntimeException("Cells are not neighbors");
        }
        if (c1.x < c2.x) {
            c1.sideHasWall.put(Direction.RIGHT, false);
            c2.sideHasWall.put(Direction.LEFT, false);
        } else if (c1.x > c2.x) {
            c1.sideHasWall.put(Direction.LEFT, false);
            c2.sideHasWall.put(Direction.RIGHT, false);
        } else if (c1.y < c2.y) {
            c1.sideHasWall.put(Direction.DOWN, false);
            c2.sideHasWall.put(Direction.UP, false);
        } else if (c1.y > c2.y) {
            c1.sideHasWall.put(Direction.UP, false);
            c2.sideHasWall.put(Direction.DOWN, false);
        }
    }
}
