package edu.project3.stats;

import edu.project3.LogRecord;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MostCommonResources implements Statistics {
    private static final int TOP_LIMIT = 5;

    @Override
    public String calculate(List<LogRecord> logs) {
        final StringBuilder sb = new StringBuilder();
        var counts = logs.stream()
            .collect(
                Collectors.groupingBy(
                    LogRecord::requestedResource,
                    Collectors.summingInt((r) -> 1)
                )
            ).entrySet();
        counts.stream()
            .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
            .limit(TOP_LIMIT)
            .forEach((e) -> sb
                .append(e.getKey())
                .append("   ")
                .append(e.getValue())
                .append("\n")
            );
        return sb.toString();
    }
}
