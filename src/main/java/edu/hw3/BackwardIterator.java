package edu.hw3;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class BackwardIterator<T> implements Iterator<T> {

    private final ListIterator<T> listIterator;

    public BackwardIterator(List<T> list) {
        this.listIterator = list.listIterator(list.size());
    }

    @Override
    public boolean hasNext() {
        return this.listIterator.hasPrevious();
    }

    @Override
    public T next() {
        return this.listIterator.previous();
    }
}
