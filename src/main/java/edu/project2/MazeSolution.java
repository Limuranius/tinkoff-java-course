package edu.project2;

import java.awt.Point;
import java.util.List;

public record MazeSolution(boolean isSolved, List<Point> path, int iterationsTaken) {
}
