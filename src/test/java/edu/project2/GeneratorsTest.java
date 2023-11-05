package edu.project2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class GeneratorsTest {
    @Test
    @DisplayName("(DFS) 100 random mazes solvable")
    void test1() {
        MazeGenerator generator = new MazeGeneratorDFS(15, 15);
        MazeSolver solver = new MazeSolverDFS();
        for (int i = 0; i < 100; i++) {
            Maze maze = generator.generateMaze();
            MazeSolution solution = solver.solve(maze);
            assertThat(solution.isSolved()).isTrue();
        }
    }

    @Test
    @DisplayName("(Bin. Tree) 100 random mazes solvable")
    void test2() {
        MazeGenerator generator = new MazeGeneratorBinaryTree(15, 15);
        MazeSolver solver = new MazeSolverDFS();
        for (int i = 0; i < 100; i++) {
            Maze maze = generator.generateMaze();
            MazeSolution solution = solver.solve(maze);
            assertThat(solution.isSolved()).isTrue();
        }
    }
}
