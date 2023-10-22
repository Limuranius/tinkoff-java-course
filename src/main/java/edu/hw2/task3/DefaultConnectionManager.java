package edu.hw2.task3;

public class DefaultConnectionManager implements ConnectionManager {
    private static final double FAULT_CONNECTION_CHANCE = 0.2;

    @Override
    public Connection getConnection() {
        if (Math.random() < FAULT_CONNECTION_CHANCE) {
            return new FaultyConnection();
        } else {
            return new StableConnection();
        }
    }
}
