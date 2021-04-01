package com.epam.array.parser;

import com.epam.array.entity.ArrayEntity;
import com.epam.array.exception.ArrayException;

public class StringParser {

    final String SPACE_REGEX = "\\s+";

    public ArrayEntity parse(String numberString) throws ArrayException { //return просто массив
        String[] lineElements = numberString.split(SPACE_REGEX);
        ArrayEntity arrayEntity = new ArrayEntity(lineElements.length);
        for (int i = 0; i < lineElements.length; i++) {
            arrayEntity.set(i, Integer.parseInt(lineElements[i]));
        }
        return arrayEntity;
    }
}
