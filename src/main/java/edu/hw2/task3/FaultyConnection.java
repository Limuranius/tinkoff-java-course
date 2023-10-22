package edu.hw2.task3;

public class FaultyConnection implements Connection {
    private static final double FAULT_CHANCE = 0.5;

    @Override
    public void execute(String command) {
        if (Math.random() < FAULT_CHANCE) {
            throw new ConnectionException();
        }
    }

    @Override
    public void close() throws Exception {}
}
