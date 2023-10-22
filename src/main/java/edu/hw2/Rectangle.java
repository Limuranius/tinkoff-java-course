package edu.hw2;

public class Rectangle {
    private final int width;
    private final int height;

    Rectangle(int height, int width) {
        this.height = height;
        this.width = width;
    }

    double area() {
        return width * height;
    }
}
