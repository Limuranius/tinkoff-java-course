package edu.project2;

public class MazeGeneratorBinaryTree extends MazeGenerator {
    private static final Direction[] CARVE_SIDES = new Direction[] {Direction.UP, Direction.LEFT};

    MazeGeneratorBinaryTree(int height, int width) {
        super(height, width);
    }

    @Override
    public Maze generateMaze() {
        var cells = new MazeCell[height][width];
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                cells[y][x] = new MazeCell(x, y);
            }
        }

        var entranceCell = cells[0][0];
        var exitCell = cells[height - 1][width - 1];
        entranceCell.sideHasWall.put(Direction.LEFT, false);
        exitCell.sideHasWall.put(Direction.RIGHT, false);

        for (int y = 1; y < height; y++) {
            MazeCell.removeWallBetweenCells(cells[y][0], cells[y - 1][0]);
        }
        for (int x = 1; x < width; x++) {
            MazeCell.removeWallBetweenCells(cells[0][x], cells[0][x - 1]);
        }

        for (int y = 1; y < height; y++) {
            for (int x = 1; x < width; x++) {
                var rndSide = CARVE_SIDES[Utils.randInt(0, 1)];
                if (rndSide == Direction.UP) {
                    MazeCell.removeWallBetweenCells(cells[y][x], cells[y - 1][x]);
                } else {
                    MazeCell.removeWallBetweenCells(cells[y][x], cells[y][x - 1]);
                }
            }
        }

        return new Maze(cells, entranceCell, exitCell);
    }
}
