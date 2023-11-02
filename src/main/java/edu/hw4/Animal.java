package edu.hw4;

public record Animal(
    String name,
    Type type,
    Sex sex,
    int age,
    int height,
    int weight,
    boolean bites
) {
    public enum Type {
        CAT, DOG, BIRD, FISH, SPIDER
    }

    public enum Sex {
        M, F
    }

    public int paws() {
        final int NO_PAWS = 0;
        final int TWO_PAWS = 2;
        final int FOUR_PAWS = 4;
        final int EIGHT_PAWS = 8;

        return switch (type) {
            case CAT, DOG -> FOUR_PAWS;
            case BIRD -> TWO_PAWS;
            case FISH -> NO_PAWS;
            case SPIDER -> EIGHT_PAWS;
        };
    }
}
