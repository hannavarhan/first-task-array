package com.epam.array.service;

import com.epam.array.entity.ArrayEntity;
import com.epam.array.exception.ArrayException;

public interface SortService {

    void quickSort(ArrayEntity arrayEntity) throws ArrayException;

    void countingSort(ArrayEntity arrayEntity) throws ArrayException;

    void mergeSort(ArrayEntity arrayEntity) throws ArrayException;
}
