package edu.hw6;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.zip.Adler32;
import java.util.zip.CheckedOutputStream;

public final class Task4 {
    private Task4() {
    }

    public static void outputStreamChain(Path path) {
        try (
            var outputStream = new PrintWriter(
                new OutputStreamWriter(
                    new BufferedOutputStream(
                        new CheckedOutputStream(
                            Files.newOutputStream(
                                path
                            ),
                            new Adler32()
                        )
                    ),
                    StandardCharsets.UTF_8
                )
            )
        ) {
            outputStream.write("Programming is learned by writing programs. ― Brian Kernighan");
        } catch (IOException ignored) {
        }
    }
}
