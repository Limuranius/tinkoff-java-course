package edu.project2;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MazeSolverDFS implements MazeSolver {
    @Override
    public MazeSolution solve(Maze maze) {
        var visited = new boolean[maze.height][maze.width];
        for (var row : visited) {
            Arrays.fill(row, false);
        }
        List<Point> path = new ArrayList<>();
        boolean isSolved = dfs(
            maze.entrance.x,
            maze.entrance.y,
            maze,
            visited,
            path
        );
        Collections.reverse(path);
        int iterationsTaken = 0;
        for (var row : visited) {
            for (boolean cellVisited : row) {
                if (cellVisited) {
                    iterationsTaken++;
                }
            }
        }

        return new MazeSolution(isSolved, path, iterationsTaken);
    }

    private boolean dfs(int x, int y, Maze maze, boolean[][] visited, List<Point> path) {
        visited[y][x] = true;
        if (x == maze.exit.x && y == maze.exit.y) {
            path.add(new Point(x, y));
            return true;
        }
        var cell = maze.getCell(x, y);
        for (var direction : Direction.values()) {
            if (!cell.sideHasWall.get(direction)) {
                int newX = x + direction.asCartesian().x;
                int newY = y + direction.asCartesian().y;
                if (Utils.inBounds(newX, newY, maze.width, maze.height) && !visited[newY][newX]) {
                    boolean isSolved = dfs(newX, newY, maze, visited, path);
                    if (isSolved) {
                        path.add(new Point(x, y));
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
