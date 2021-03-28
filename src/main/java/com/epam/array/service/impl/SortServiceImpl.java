package com.epam.array.service.impl;

import com.epam.array.entity.ArrayEntity;
import com.epam.array.exception.ArrayException;
import com.epam.array.service.SearchService;
import com.epam.array.service.SortService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;

public class SortServiceImpl implements SortService {

    private final static Logger logger = LogManager.getLogger(SortServiceImpl.class);

    private Random rand = new Random();

    public ArrayEntity quickSort(ArrayEntity arrayEntity) throws ArrayException {
        ArrayEntity result;
        result = recursiveQuickSort(arrayEntity, 0, arrayEntity.size() - 1);
        logger.info("Quick sort finished. Sorted array is:" + result);
        return result;
    }

    @Override
    public ArrayEntity countingSort(ArrayEntity arrayEntity) throws ArrayException {
        ArrayEntity result = new ArrayEntity(arrayEntity.size());
        int maxElement = 1_000_000;
        SearchService searchService = new SearchServiceImpl();
        int realMaxElement = searchService.findMax(arrayEntity);
        int realMinElement = searchService.findMin(arrayEntity);
        if (realMaxElement - realMinElement > maxElement) {
            logger.error("Elements are too large");
            throw new ArrayException("Elements are too large");
        }
        int[] countingArr = new int[realMaxElement - realMinElement + 1];
        for (int i = 0; i < arrayEntity.size(); i++) {
            countingArr[arrayEntity.get(i) - realMinElement]++;
        }
        int l = 0;
        for (int i = 0; i <= realMaxElement - realMinElement; i++) {
            for (int j = 0; j < countingArr[i]; j++) {
                result.set(l++, i + realMinElement);
            }
        }
        logger.info("Sorted array is:" + result);
        return result;
    }

    @Override
    public ArrayEntity mergeSort(ArrayEntity arrayEntity) throws ArrayException {
        ArrayEntity result = new ArrayEntity(arrayEntity.size());
        recursiveMergeSort(arrayEntity, result, 0, arrayEntity.size() - 1);
        logger.info("Merge sort finished. Sorted array is:" + result);
        return result;
    }

    private ArrayEntity recursiveQuickSort(ArrayEntity array, int currentL, int currentR) throws ArrayException {
        int l = currentL, r = currentR;
        int c = rand.nextInt(r - l);
        int median = array.get(l + c);
        while (l <= r) {
            while (array.get(l) < median) {
                l++;
            }
            while (array.get(r) > median) {
                r--;
            }
            if (l <= r) {
                int tmp = array.get(l);
                array.set(l, array.get(r));
                array.set(r, tmp);
                l++;
                r--;
            }
        }
        if (currentL < r) {
            recursiveQuickSort(array, currentL, r);
        }
        if (currentR > l) {
            recursiveQuickSort(array, l, currentR);
        }
        return array;
    }

    private void recursiveMergeSort(ArrayEntity array, ArrayEntity result, int l, int r) throws ArrayException {
        if (l > r) return;
        if (l == r) return;
        if (l + 1 == r) {
            if (array.get(l) > array.get(r)) {
                int tmp = array.get(l);
                array.set(l, array.get(r));
                array.set(r, tmp);
            }
            return;
        }
        int c = (r + l) / 2;

        recursiveMergeSort(array, result, l, c);
        recursiveMergeSort(array, result, c + 1, r);

        int ml = l;
        int l1 = l;
        int l2 = c + 1;

        while (l1 <= c || l2 <= r) {
            if (l1 <= c && l2 <= r) {
                if (array.get(l1) < array.get(l2)) {
                    result.set(ml++, array.get(l1++));
                } else {
                    result.set(ml++, array.get(l2++));
                }
            } else if (l1 <= c) {
                result.set(ml++, array.get(l1++));
            } else {
                result.set(ml++, array.get(l2++));
            }
        }
    }
}
