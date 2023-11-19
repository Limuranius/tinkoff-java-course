package edu.project3;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public record LogRecord(
    String remoteAddr,
    String remoteUser,
    OffsetDateTime timeLocal,
    String requestType,
    String requestedResource,
    int status,
    int bodyBytesSent
) {
    private static final Pattern LOG_PATTERN = Pattern.compile(
        "([^ ]+) - ([^ ]+) \\[([^]]+)] \"([A-Z]+) ([^\" ]+) [^\"]+\" (\\d+) (\\d+) \"[^\"]*\" \"([^\"]*)\"");
    private static final String DATE_FORMAT = "dd/MMM/yyyy:HH:mm:ss Z";

    private static final int REMOTEADDRINDEX = 1;
    private static final int REMOTEUSERINDEX = 2;
    private static final int TIMELOCALINDEX = 3;
    private static final int REQUESTTYPEINDEX = 4;
    private static final int REQUESTEDRESOURCEINDEX = 5;
    private static final int STATUSINDEX = 6;
    private static final int BODYBYTESSENTINDEX = 7;

    public static LogRecord fromString(String string) {
        Matcher matcher = LOG_PATTERN.matcher(string);
        if (matcher.find()) {
            return new LogRecord(
                matcher.group(REMOTEADDRINDEX),
                matcher.group(REMOTEUSERINDEX),
                OffsetDateTime.parse(
                    matcher.group(TIMELOCALINDEX),
                    DateTimeFormatter.ofPattern(DATE_FORMAT, Locale.US)
                ),
                matcher.group(REQUESTTYPEINDEX),

                matcher.group(REQUESTEDRESOURCEINDEX),
                Integer.parseInt(matcher.group(STATUSINDEX)),
                Integer.parseInt(matcher.group(BODYBYTESSENTINDEX))
            );
        } else {
            throw new RuntimeException("Unknown log format");
        }
    }
}
