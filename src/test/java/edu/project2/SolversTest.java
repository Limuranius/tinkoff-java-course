package edu.project2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.awt.Point;
import static org.assertj.core.api.Assertions.assertThat;

public class SolversTest {
    @Test
    @DisplayName("DFS Solver solvable")
    void test1() {
        var c1 = new MazeCell(0, 0);
        var c2 = new MazeCell(1, 0);
        var c3 = new MazeCell(0, 1);
        var c4 = new MazeCell(1, 1);
        MazeCell.removeWallBetweenCells(c1, c2);
        MazeCell.removeWallBetweenCells(c2, c4);
        MazeCell.removeWallBetweenCells(c1, c3);
        var cells = new MazeCell[][] {
            {c1, c2},
            {c3, c4}
        };
        Maze maze = new Maze(cells, c1, c4);

        MazeSolver solver = new MazeSolverDFS();
        MazeSolution solution = solver.solve(maze);

        assertThat(solution.isSolved()).isTrue();
        assertThat(solution.path())
            .hasSize(3)
            .containsExactly(
                new Point(0, 0),
                new Point(1, 0),
                new Point(1, 1)
                );
    }

    @Test
    @DisplayName("DFS Solver unsolvable")
    void test2() {
        var c1 = new MazeCell(0, 0);
        var c2 = new MazeCell(1, 0);
        var c3 = new MazeCell(0, 1);
        var c4 = new MazeCell(1, 1);
        MazeCell.removeWallBetweenCells(c1, c2);
        MazeCell.removeWallBetweenCells(c1, c3);
        var cells = new MazeCell[][] {
            {c1, c2},
            {c3, c4}
        };
        Maze maze = new Maze(cells, c1, c4);

        MazeSolver solver = new MazeSolverDFS();
        MazeSolution solution = solver.solve(maze);

        assertThat(solution.isSolved()).isFalse();
    }
}
