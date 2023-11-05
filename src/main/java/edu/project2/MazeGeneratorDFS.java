package edu.project2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MazeGeneratorDFS extends MazeGenerator {

    MazeGeneratorDFS(int height, int width) {
        super(height, width);
    }

    @Override
    public Maze generateMaze() {
        var cells = new MazeCell[height][width];
        var visited = new boolean[height][width];
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                cells[y][x] = new MazeCell(x, y);
                visited[y][x] = false;
            }
        }

        var entranceCell = cells[0][0];
        var exitCell = cells[height - 1][width - 1];
        entranceCell.sideHasWall.put(Direction.LEFT, false);
        exitCell.sideHasWall.put(Direction.RIGHT, false);

        this.dfs(entranceCell.x, entranceCell.y, cells, visited);
        return new Maze(cells, entranceCell, exitCell);
    }

    private void dfs(int x, int y, MazeCell[][] cells, boolean[][] visited) {
        visited[y][x] = true;
        var neighbors = this.getNeighborsRandomOrder(x, y, cells);
        for (var neighbor : neighbors) {
            if (!visited[neighbor.y][neighbor.x]) {
                MazeCell.removeWallBetweenCells(
                    cells[y][x],
                    neighbor
                );
                dfs(neighbor.x, neighbor.y, cells, visited);
            }
        }
    }

    private List<MazeCell> getNeighborsRandomOrder(int x, int y, MazeCell[][] cells) {
        var rndDirections = Arrays.asList(Direction.values());
        Collections.shuffle(rndDirections);
        List<MazeCell> neighbors = new ArrayList<>();

        for (var direction : rndDirections) {
            int newX = x + direction.asCartesian().x;
            int newY = y + direction.asCartesian().y;

            if (Utils.inBounds(newX, newY, this.width, this.height)) {
                neighbors.add(cells[newY][newX]);
            }
        }
        return neighbors;
    }
}
