package edu.project2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MazeTest {
    @Test
    @DisplayName("Invalid size")
    void test1() {
        assertThatThrownBy(() -> new MazeGeneratorDFS(-2, 10));
        assertThatThrownBy(() -> new MazeGeneratorDFS(15, -5));
        assertThatThrownBy(() -> new MazeGeneratorDFS(0, 0));
        assertThatThrownBy(() -> new MazeGeneratorDFS(0, 1));
        assertThatThrownBy(() -> new MazeGeneratorDFS(1, 0));
    }

    @Test
    @DisplayName("Pretty print")
    void test2() {
        var c1 = new MazeCell(0, 0);
        var c2 = new MazeCell(1, 0);
        var c3 = new MazeCell(0, 1);
        var c4 = new MazeCell(1, 1);

        MazeCell.removeWallBetweenCells(c1, c2);
        MazeCell.removeWallBetweenCells(c2, c4);

        var cells = new MazeCell[][] {
            {c1, c2},
            {c3, c4}
        };
        Maze maze = new Maze(cells, c1, c4);
        String expectedStr = """
█████
█...█
███.█
█.█.█
█████
            """;
        assertThat(maze.toString()).isEqualTo(expectedStr);
    }
}
