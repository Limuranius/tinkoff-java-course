package edu.project2;

public abstract class MazeGenerator {
    protected int height;
    protected int width;

    public MazeGenerator(int height, int width) {
        this.height = height;
        this.width = width;
        this.validateShape();
    }

    abstract Maze generateMaze();

    protected void validateShape() {
        final int minSide = 1;

        if (height < minSide || width < minSide) {
            throw new RuntimeException("Width and/or height can't be < " + minSide);
        }
    }
}
