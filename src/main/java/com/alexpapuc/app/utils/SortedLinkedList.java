package com.alexpapuc.app.utils;

import java.util.LinkedList;

public class SortedLinkedList<T extends Comparable<T>> extends LinkedList<T> {
    @Override
    public boolean add(T element) {
        if (isEmpty() || element.compareTo(getFirst()) <= 0) {
            super.addFirst(element);
            return true;
        }

        for (int i = 0; i < size(); i++) {
            if (element.compareTo(get(i)) <= 0) {
                super.add(i, element);
                return true;
            }
        }

        super.addLast(element);
        return true;
    }
}