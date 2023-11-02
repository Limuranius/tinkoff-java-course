package edu.hw4;

public class ValidationError extends RuntimeException {
    public ValidationError(String msg) {
        super(msg);
    }
}
