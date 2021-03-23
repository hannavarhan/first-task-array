package com.epam.array.service.impl;

import com.epam.array.entity.MyIntArray;
import com.epam.array.service.ReplaceService;
import com.epam.array.service.SearchService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ReplaceServiceImpl implements ReplaceService {

    private final static Logger logger = LogManager.getLogger(ReplaceServiceImpl.class);

    public MyIntArray replacePositive(MyIntArray myIntArray) {
        MyIntArray newMyIntArray = new MyIntArray(myIntArray.size());
        for(int i = 0; i < myIntArray.size(); i++) {
            newMyIntArray.set(i, myIntArray.get(i) > 0 ? -myIntArray.get(i) : myIntArray.get(i));
        }
        logger.info("positive mas: " + newMyIntArray + ", before: " + myIntArray);
        return newMyIntArray;
    }

    public MyIntArray replaceNegative(MyIntArray myIntArray) {
        MyIntArray newMyIntArray = new MyIntArray(myIntArray.size());
        for(int i = 0; i < myIntArray.size(); i++) {
            newMyIntArray.set(i, myIntArray.get(i) < 0 ? -myIntArray.get(i) : myIntArray.get(i));
        }
        logger.info("negative mas: " + newMyIntArray + ", before: " + myIntArray);
        return newMyIntArray;
    }
}
