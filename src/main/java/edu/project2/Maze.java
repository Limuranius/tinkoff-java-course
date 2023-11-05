package edu.project2;

public class Maze {
    public final int height;
    public final int width;
    private final MazeCell[][] maze;
    public final MazeCell entrance;
    public final MazeCell exit;
    private static final Character FREE_CELL_CHAR = '.';
    private static final Character WALL_CHAR = '█';
    private static final Character SOLUTION_CHAR = '#';

    public Maze(MazeCell[][] maze, MazeCell entry, MazeCell exit) {
        this.height = maze.length;
        this.width = maze[0].length;
        this.maze = maze;
        this.entrance = entry;
        this.exit = exit;
    }

    public MazeCell getCell(int x, int y) {
        return this.maze[y][x];
    }

    private Character[][] getMazeChars() {
        int charsArrWidth = this.width * 2 + 1;
        int charArrHeight = this.height * 2 + 1;
        var mazeChars = new Character[charArrHeight][charsArrWidth];

        for (int y = 0; y < this.height; y++) {
            for (int x = 0; x < this.width; x++) {
                var cell = this.maze[y][x];
                mazeChars[y * 2][x * 2] = WALL_CHAR;
                mazeChars[y * 2][x * 2 + 1] = getCellSideChar(cell, Direction.UP);
                mazeChars[y * 2][x * 2 + 2] = WALL_CHAR;
                mazeChars[y * 2 + 1][x * 2] = getCellSideChar(cell, Direction.LEFT);
                mazeChars[y * 2 + 1][x * 2 + 1] = FREE_CELL_CHAR;
                mazeChars[y * 2 + 1][x * 2 + 2] = getCellSideChar(cell, Direction.RIGHT);
                mazeChars[y * 2 + 2][x * 2] = WALL_CHAR;
                mazeChars[y * 2 + 2][x * 2 + 1] = getCellSideChar(cell, Direction.DOWN);
                mazeChars[y * 2 + 2][x * 2 + 2] = WALL_CHAR;
            }
        }
        return mazeChars;
    }

    @Override
    public String toString() {
        return Utils.char2DtoStr(this.getMazeChars());
    }

    public String toString(MazeSolution solution) {
        var mazeChars = this.getMazeChars();
        var path = solution.path();
        int x = path.get(0).x;
        int y = path.get(0).y;
        int dx;
        int dy;

        for (var pathPoint : solution.path()) {
            dx = pathPoint.x - x;
            dy = pathPoint.y - y;
            mazeChars[y * 2 + 1][x * 2 + 1] = SOLUTION_CHAR;
            mazeChars[y * 2 + 1 + dy][x * 2 + 1 + dx] = SOLUTION_CHAR;
            mazeChars[y * 2 + 1 + dy * 2][x * 2 + 1 + dx * 2] = SOLUTION_CHAR;
            x = pathPoint.x;
            y = pathPoint.y;
        }
        return Utils.char2DtoStr(mazeChars);
    }

    private Character getCellSideChar(MazeCell cell, Direction side) {
        if (cell.sideHasWall.get(side)) {
            return WALL_CHAR;
        } else {
            return FREE_CELL_CHAR;
        }
    }
//    public static Maze fromString(String mazeStr) {
//        return "";
//    }
}
