package edu.project3;

import edu.project3.stats.MostCommonResources;
import edu.project3.stats.Statistics;
import edu.project3.stats.StatusCodes;
import java.nio.file.Path;
import java.util.List;

public class Main {
    private Main() {
    }

    public static void main(String[] args) {
        Path path = Path.of("C:/Users/Gleb/Downloads/nginx_logs.txt");
        var parsedRecords = LogParser.parseFile(path);

        List<Statistics> stats = List.of(
            new MostCommonResources(),
            new StatusCodes()
        );

        for (var stat : stats) {
//            System.out.println(stat.calculate(parsedRecords) + "\n");
        }
    }
}
