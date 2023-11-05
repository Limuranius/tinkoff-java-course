package edu.project2;

import java.awt.Point;
import java.util.Map;

public enum Direction {
    UP, RIGHT, DOWN, LEFT;

    private static final Map<Direction, Point> DIRECTIONS = Map.of(
        UP, new Point(0, -1),
        RIGHT, new Point(1, 0),
        DOWN, new Point(0, 1),
        LEFT, new Point(-1, 0)
    );

    public Point asCartesian() {
        return DIRECTIONS.get(this);
    }
}
