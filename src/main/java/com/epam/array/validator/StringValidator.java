package com.epam.array.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringValidator {

    public static boolean validate(String line) {
        final String IS_VALID_STRING = "^([-+])?[0-9]+(\\s(([-+])?[0-9]+))*$";
        Pattern pattern = Pattern.compile(IS_VALID_STRING);
        Matcher matcher = pattern.matcher(line.trim());
        return matcher.find();
    }
}
