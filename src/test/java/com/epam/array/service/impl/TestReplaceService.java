package com.epam.array.service.impl;

import com.epam.array.entity.ArrayEntity;
import com.epam.array.exception.ArrayException;
import com.epam.array.service.ReplaceService;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestReplaceService {

    ArrayEntity myIntArray;
    ReplaceService replaceService;

    @BeforeClass
    public void setMyIntArray() {
        myIntArray = new ArrayEntity(new int[]{1, -2, 5, 2, -7});
        replaceService = new ReplaceServiceImpl();
    }

    @Test
    public void replacePositive() throws ArrayException {
        ArrayEntity actual = new ArrayEntity(new int[]{-1, -2, -5, -2, -7});
        ArrayEntity expected = replaceService.replacePositive(myIntArray);
        Assert.assertEquals(actual, expected);
    }

    @Test(expectedExceptions = ArrayException.class)
    public void testExceptionReplacePositive() throws ArrayException {
        replaceService.replacePositive(null);
    }

    @Test
    public void replaceNegative() throws ArrayException {
        ArrayEntity actual = new ArrayEntity(new int[]{1, 2, 5, 2, 7});
        ArrayEntity expected = replaceService.replaceNegative(myIntArray);
        Assert.assertEquals(actual, expected);
    }

    @Test(expectedExceptions = ArrayException.class)
    public void testExceptionReplaceNegative() throws ArrayException {
        replaceService.replaceNegative(null);
    }
}
