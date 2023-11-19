package edu.hw6;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public final class Task2 {

    private Task2() {
    }

    public static void cloneFile(Path path) throws IOException {
        File file = path.toFile();
        if (!file.createNewFile()) {
            int copyNumber = 1;
            Path copyPath = getCopyPath(path, copyNumber);
            while (!copyPath.toFile().createNewFile()) {
                copyNumber++;
                copyPath = getCopyPath(path, copyNumber);
            }
        }
    }

    private static Path getCopyPath(Path path, int copyNumber) {
        String numPart = "";
        File file = path.toFile();
        if (copyNumber > 1) {
            numPart = " (" + copyNumber + ")";
        }

        var fileParts = file.getName().split("\\.");
        String fileName = fileParts[0];
        String extension = "";
        if (fileParts.length == 2) {
            extension = "." + fileParts[1];
        }
        return Path.of(path.getParent() + "/" + fileName + " — копия" + numPart + extension);
    }
}
