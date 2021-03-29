package com.epam.array.service.impl;

import com.epam.array.entity.ArrayEntity;
import com.epam.array.exception.ArrayException;
import com.epam.array.service.SearchService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SearchServiceImpl implements SearchService {

    private final static Logger logger = LogManager.getLogger(SearchServiceImpl.class);

    public int findMin(ArrayEntity arrayEntity) throws ArrayException {
        int min = arrayEntity.get(0);
        for (int i = 0; i < arrayEntity.size(); i++) {
            if (arrayEntity.get(i) < min) {
                min = arrayEntity.get(i);
            }
        }
        logger.info("min: " + min + " of: " + arrayEntity);
        return min;
    }

    public int findMax(ArrayEntity arrayEntity) throws ArrayException {
        int max = arrayEntity.get(0);
        for (int i = 0; i < arrayEntity.size(); i++) {
            if (arrayEntity.get(i) > max) {
                max = arrayEntity.get(i);
            }
        }
        logger.info("max: " + max + " of: " + arrayEntity);
        return max;
    }

    public double findAverage(ArrayEntity arrayEntity) throws ArrayException {
        logger.info("average: " + findSum(arrayEntity) / arrayEntity.size() + " of: " + arrayEntity);
        return (double) findSum(arrayEntity) / arrayEntity.size();
    }

    public int findSum(ArrayEntity arrayEntity) throws ArrayException {
        int sum = 0;
        for (int i = 0; i < arrayEntity.size(); i++) {
            sum += arrayEntity.get(i);
        }
        logger.info("sum: " + sum + " of: " + arrayEntity);
        return sum;
    }

    public int findPositiveElementsNumber(ArrayEntity arrayEntity) throws ArrayException {
        int posNumber = 0;
        for (int i = 0; i < arrayEntity.size(); i++) {
            if (arrayEntity.get(i) > 0) {
                posNumber++;
            }
        }
        logger.info("positiveElementsNumber: " + posNumber + " of: " + arrayEntity);
        return posNumber;
    }

    public int findNegativeElementsNumber(ArrayEntity arrayEntity) throws ArrayException {
        int negNumber = 0;
        for (int i = 0; i < arrayEntity.size(); i++) {
            if (arrayEntity.get(i) < 0) {
                negNumber++;
            }
        }
        logger.info("negativeElementsNumber: " + negNumber + " of: " + arrayEntity);
        return negNumber;
    }
}
