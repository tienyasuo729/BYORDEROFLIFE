package com.example.exercise_hrm.util;

import java.util.Comparator;

public class ComparatorUtil<E extends Comparable<E>> implements Comparator<E> {
    @Override
    public int compare(E o1, E o2) {
        return o1.compareTo(o2);
    }
}
