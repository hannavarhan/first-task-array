package com.epam.array.entity;

import java.util.Arrays;

public class MyIntArray {
    private int[] array;

    public MyIntArray() {    }

    public MyIntArray(int size) {
        if (size < 1) {
            throw new IllegalArgumentException("Wrong size");
        }
        this.array = new int[size];
    }

    public MyIntArray(int[] array) {
        this.array = array;
    }

    public int get(int i) {
        if (i >= 0 && i < array.length) {
            return array[i];
        } else {
            throw new IllegalArgumentException("Wrong get position");
        }
    }

    public void set(int position, int value) {
        if (position >= 0 && position <= array.length) {
            array[position] = value;
        } else {
            throw new IllegalArgumentException("Wrong set position");
        }
    }

    public int size() {
        return array.length;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyIntArray that = (MyIntArray) o;
        return Arrays.equals(array, that.array);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(array);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("MyIntArray");
        sb.append(Arrays.toString(array));
        return sb.toString();
    }
}
