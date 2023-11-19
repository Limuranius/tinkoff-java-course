package edu.project3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public class LogParser {
    private LogParser() {
    }

    public static List<LogRecord> parseFile(Path path) {
        try (var br = new BufferedReader(new FileReader(path.toFile()))) {
            return br.lines()
                .map(LogRecord::fromString)
                .toList();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
