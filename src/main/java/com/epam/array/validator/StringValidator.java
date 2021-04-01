package com.epam.array.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringValidator {

    final static String IS_VALID_STRING = "^([-+])?\\d+(\\s(([-+])?\\d+))*$";

    public static boolean validate(String line) {
        Pattern pattern = Pattern.compile(IS_VALID_STRING);
        Matcher matcher = pattern.matcher(line.trim());
        return matcher.matches();
    }
}
