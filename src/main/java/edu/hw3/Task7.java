package edu.hw3;

import java.util.Comparator;

public class Task7 {

    public static class TreeMapComparator<T extends Comparable<T>> implements Comparator<T> {
        public int compare(T o1, T o2) {
            if (o1 == null && o2 == null) {
                return 0;
            } else if (o1 == null) {
                return -1;
            } else if (o2 == null) {
                return 1;
            } else {
                return o1.compareTo(o2);
            }
        }
    }
}
