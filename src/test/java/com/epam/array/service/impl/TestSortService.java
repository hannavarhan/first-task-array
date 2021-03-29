package com.epam.array.service.impl;

import com.epam.array.entity.ArrayEntity;
import com.epam.array.exception.ArrayException;
import com.epam.array.service.SortService;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestSortService {

    SortService sortService;

    @BeforeClass
    public void setMyIntArray() {
        sortService = new SortServiceImpl();
    }

    @Test
    public void testQuickSort() throws ArrayException {
        ArrayEntity actual = new ArrayEntity(new int[]{-4, -2, 1, 3, 5});
        ArrayEntity expected = new ArrayEntity(new int[]{1, -2, 3, -4, 5});
        sortService.quickSort(expected);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testCountingSort() throws ArrayException {
        ArrayEntity actual = new ArrayEntity(new int[]{-40, -6, -5, -2, 2, 3, 4, 4, 5, 8, 25});
        ArrayEntity expected = new ArrayEntity(new int[]{-2, 4, 5, -40, 25, 3, 4, 8, -5, -6, 2});
        sortService.countingSort(expected);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testMergeSort() throws ArrayException {
        ArrayEntity actual = new ArrayEntity(new int[]{-4, -2, 1, 3, 5});
        ArrayEntity expected = new ArrayEntity(new int[]{1, -2, 3, -4, 5});
        sortService.mergeSort(expected);
        Assert.assertEquals(actual, expected);
    }

}
