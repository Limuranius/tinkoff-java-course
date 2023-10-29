package edu.hw3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task3 {

    private Task3() {
    }

    public static <T> Map<T, Integer> freqDict(List<T> values) {
        Map<T, Integer> frequencies = new HashMap<>();
        for (T value : values) {
            int currentCount = frequencies.getOrDefault(value, 0);
            frequencies.put(value, currentCount + 1);
        }
        return frequencies;
    }
}
