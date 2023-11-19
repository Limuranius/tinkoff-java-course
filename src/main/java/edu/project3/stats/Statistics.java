package edu.project3.stats;

import edu.project3.LogRecord;
import java.util.List;

public interface Statistics {
    String calculate(List<LogRecord> logs);
}
