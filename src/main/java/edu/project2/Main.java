package edu.project2;

public class Main {
    private Main() {
    }

    public static void main(String[] args) {
        final int height = 1;
        final int width = 10;

        MazeGenerator generator = new MazeGeneratorBinaryTree(height, width);
        Maze maze = generator.generateMaze();
//        System.out.println(maze.toString());

        MazeSolver solver = new MazeSolverDFS();
        MazeSolution solution = solver.solve(maze);
//        System.out.println(maze.toString(solution));
    }
}
