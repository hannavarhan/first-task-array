package com.epam.array.validator;

import com.epam.array.entity.ArrayEntity;
import com.epam.array.exception.ArrayException;
import com.epam.array.exception.ArrayValidatorException;

import java.util.regex.Pattern;

public class StringValidator {

    private static final String IS_NUMBER = "^([-+])?[0-9]*$";
    private static Pattern pattern = Pattern.compile(IS_NUMBER);

    public static ArrayEntity validate(String line) throws ArrayValidatorException, ArrayException {
        ArrayEntity arrayEntity = new ArrayEntity(line.split(" ").length);
        for (int i = 0; i < line.split(" ").length; i++) {
            if (pattern.matcher(line.split(" ")[i].trim()).find()) {
                arrayEntity.set(i, Integer.parseInt(line.split(" ")[i]));
            } else {
                throw new ArrayValidatorException("Line is not valid");
            }
        }
        return arrayEntity;
    }
}
