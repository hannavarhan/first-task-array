package com.epam.array.service.impl;

import com.epam.array.entity.MyIntArray;
import com.epam.array.service.SearchService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SearchServiceImpl implements SearchService {

    private final static Logger logger = LogManager.getLogger(SearchServiceImpl.class);

    public int findMin(MyIntArray myIntArray) {
        int min = myIntArray.get(0);
        for (int i = 0; i < myIntArray.size(); i++) {
            if (myIntArray.get(i) < min) {
                min = myIntArray.get(i);
            }
        }
        logger.info("min: " + min + " of: " + myIntArray);
        return min;
    }

    public int findMax(MyIntArray myIntArray) {
        int max = myIntArray.get(0);
        for (int i = 0; i < myIntArray.size(); i++) {
            if (myIntArray.get(i) > max) {
                max = myIntArray.get(i);
            }
        }
        logger.info("max: " + max + " of: " + myIntArray);
        return max;
    }

    public double findAverage(MyIntArray myIntArray) {
        logger.info("average: " + findSum(myIntArray) / myIntArray.size() + " of: " + myIntArray);
        return (double)findSum(myIntArray) / myIntArray.size();
    }

    public int findSum(MyIntArray myIntArray) {
        int sum = 0;
        for (int i = 0; i < myIntArray.size(); i++) {
            sum += myIntArray.get(i);
        }
        logger.info("sum: " + sum + " of: " + myIntArray);
        return sum;
    }

    public int findPositiveElementsNumber(MyIntArray myIntArray) {
        int posNumber = 0;
        for (int i = 0; i < myIntArray.size(); i++) {
            if (myIntArray.get(i) > 0) {
                posNumber++;
            }
        }
        logger.info("positiveElementsNumber: " + posNumber + " of: " + myIntArray);
        return posNumber;
    }

    public int findNegativeElementsNumber(MyIntArray myIntArray) {
        int negNumber = 0;
        for (int i = 0; i < myIntArray.size(); i++) {
            if (myIntArray.get(i) < 0) {
                negNumber++;
            }
        }
        logger.info("negativeElementsNumber: " + negNumber + " of: " + myIntArray);
        return negNumber;
    }
}
