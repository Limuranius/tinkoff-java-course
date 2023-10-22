package edu.hw2.task3;

public final class PopularCommandExecutor {
    private final ConnectionManager manager;
    private final int maxAttempts;

    PopularCommandExecutor(ConnectionManager manager, int maxAttempts) {
        this.manager = manager;
        this.maxAttempts = maxAttempts;
    }

    public void updatePackages() {
        tryExecute("apt update && apt upgrade -y");
    }

    void tryExecute(String command) {
        ConnectionException cause = new ConnectionException();
        boolean success = false;
        int tryNumber = 0;
        while (!success && tryNumber < maxAttempts) {
            try {
                var connection = this.manager.getConnection();
                connection.execute(command);
                success = true;
            } catch (ConnectionException e) {
                cause = e;
            }
            tryNumber++;
        }
        if (!success) {
            throw cause;
        }
    }
}
