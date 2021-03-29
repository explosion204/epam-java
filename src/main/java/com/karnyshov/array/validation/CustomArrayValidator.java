package com.karnyshov.array.validation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomArrayValidator {
    private static Logger logger = LogManager.getLogger();
    private static final String NUM_PATTERN = "(\\s?-?\\d+\\s?)+";

    public static boolean validate(String line) {
        if (line == null) {
            String errorMsg = "Passed string is null";
            logger.error(errorMsg);
            return false;
        }

        Pattern pattern = Pattern.compile(NUM_PATTERN);
        Matcher matcher = pattern.matcher(line);

        return matcher.matches();
    }
}
