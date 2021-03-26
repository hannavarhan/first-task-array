package com.epam.array.service.impl;

import com.epam.array.entity.ArrayEntity;

import com.epam.array.exception.ArrayException;
import com.epam.array.service.SearchService;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestSearchService {

    ArrayEntity myIntArray;
    SearchService searchService;

    @BeforeClass
    public void setMyIntArray() {
        myIntArray = new ArrayEntity(new int[]{1, -2, 5, 2, -7});
        searchService = new SearchServiceImpl();
    }

    @Test(expectedExceptions =ArrayException.class)
    public void testCreation() throws ArrayException {
        ArrayEntity arrayEntity = new ArrayEntity(-1);
    }

    @Test(expectedExceptions =ArrayException.class)
    public void testGet() throws ArrayException {
        myIntArray.get(-5);
    }

    @Test(expectedExceptions =ArrayException.class)
    public void testSet() throws ArrayException {
        myIntArray.set(-5, 8);
    }

    @Test
    public void findMin() throws ArrayException {
        int actual = -7;
        int expected = searchService.findMin(myIntArray);
        Assert.assertEquals(actual, expected, 0, "Test failed as...");
    }

    @Test
    public void findMax() throws ArrayException {
        int actual = 5;
        int expected = searchService.findMax(myIntArray);
        Assert.assertEquals(actual, expected, 0, "Test failed as...");
    }

    @Test
    public void findAverage() throws ArrayException {
        double actual = -0.2;
        double expected = searchService.findAverage(myIntArray);
        Assert.assertEquals(actual, expected, "Test failed as...");
    }

    @Test
    public void findSum() throws ArrayException {
        int actual = -1;
        int expected = searchService.findSum(myIntArray);
        Assert.assertEquals(actual, expected, "Test failed as...");
    }

    @Test
    public void findPositiveElementsNumber() throws ArrayException {
        int actual = 3;
        int expected = searchService.findPositiveElementsNumber(myIntArray);
        Assert.assertEquals(actual, expected, "Test failed as...");
    }

    @Test
    public void findNegativeElementsNumber() throws ArrayException {
        int actual = 2;
        int expected = searchService.findNegativeElementsNumber(myIntArray);
        Assert.assertEquals(actual, expected, "Test failed as...");
    }
}