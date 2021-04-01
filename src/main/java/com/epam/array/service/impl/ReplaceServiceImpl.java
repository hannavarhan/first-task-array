package com.epam.array.service.impl;

import com.epam.array.entity.ArrayEntity;
import com.epam.array.exception.ArrayException;
import com.epam.array.service.ReplaceService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ReplaceServiceImpl implements ReplaceService {

    private final static Logger logger = LogManager.getLogger(ReplaceServiceImpl.class);

    public ArrayEntity replacePositive(ArrayEntity arrayEntity) throws ArrayException {
        if (arrayEntity == null) {
            logger.error("Array is null in replacePositive method");
            throw new ArrayException("Array is null");
        }
        ArrayEntity newMyIntArray = new ArrayEntity(arrayEntity.size());
        for (int i = 0; i < arrayEntity.size(); i++) {
            newMyIntArray.set(i, arrayEntity.get(i) > 0 ? -arrayEntity.get(i) : arrayEntity.get(i));
        }
        logger.info("positive mas: " + newMyIntArray + ", before: " + arrayEntity);
        return newMyIntArray;
    }

    public ArrayEntity replaceNegative(ArrayEntity arrayEntity) throws ArrayException {
        if (arrayEntity == null) {
            logger.error("Array is null in replaceNegative method");
            throw new ArrayException("Array is null");
        }
        ArrayEntity newMyIntArray = new ArrayEntity(arrayEntity.size());
        for (int i = 0; i < arrayEntity.size(); i++) {
            newMyIntArray.set(i, arrayEntity.get(i) < 0 ? -arrayEntity.get(i) : arrayEntity.get(i));
        }
        logger.info("negative mas: " + newMyIntArray + ", before: " + arrayEntity);
        return newMyIntArray;
    }
}
