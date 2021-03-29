package com.epam.array.reader;

import com.epam.array.entity.ArrayEntity;
import com.epam.array.exception.ArrayReaderException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestArrayReader {

    ArrayReader reader;

    @BeforeClass
    public void setMyIntArray() {
        reader = new ArrayReader();
    }

    @Test
    public void testReadFromEmptyFile() throws ArrayReaderException {
        ArrayEntity actual = null;
        ArrayEntity expected = reader.readArrayFromFile("src\\main\\resources\\file\\array.txt");
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testReadFromValidFile() throws ArrayReaderException {
        ArrayEntity actual = new ArrayEntity(new int[]{52, -7, 5, 6, 1, 5});
        ArrayEntity expected = reader.readArrayFromFile("src\\main\\resources\\file\\array2.txt");
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testReadFromNotValidFile() throws ArrayReaderException {
        ArrayEntity actual = null;
        ArrayEntity expected = reader.readArrayFromFile("src\\main\\resources\\file\\array3.txt");
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testReadFirstNotValidString() throws ArrayReaderException {
        ArrayEntity actual = new ArrayEntity(new int[]{7, 8, 3, -8, 3, 4, -5});
        ArrayEntity expected = reader.readArrayFromFile("src\\main\\resources\\file\\array4.txt");
        Assert.assertEquals(actual, expected);
    }
}