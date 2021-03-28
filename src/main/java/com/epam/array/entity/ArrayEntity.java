package com.epam.array.entity;

import com.epam.array.exception.ArrayException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class ArrayEntity {

    private int[] array;

    private final static Logger logger = LogManager.getLogger(ArrayEntity.class);

    public ArrayEntity() {
    }

    public ArrayEntity(int size) throws ArrayException {
        if (size < 1) {
            logger.error("wrong size");
            throw new ArrayException("Wrong size");
        }
        this.array = new int[size];
    }

    public ArrayEntity(int[] array) {
        this.array = array;
    }

    public int get(int i) throws ArrayException {
        if (i < 0 || i >= array.length) {
            logger.error("wrong get position");
            throw new ArrayException("Wrong get position");
        }
        return array[i];
    }

    public void set(int position, int value) throws ArrayException {
        if (position < 0 || position >= array.length) {
            logger.error("wrong set position");
            throw new ArrayException("Wrong set position");
        }
        array[position] = value;
    }

    public int size() {
        return array.length;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArrayEntity that = (ArrayEntity) o;
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
