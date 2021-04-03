package com.karnyshov.array.validation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Pattern;

public class CustomArrayValidator {
    private static Logger logger = LogManager.getLogger();
    private static final String NUM_PATTERN = "(\\s?-?\\d+\\s?)+";

    public static boolean validateString(String string) {
        if (string == null) {
            String errorMsg = "CustomArrayValidator: Passed string is null";
            logger.error(errorMsg);
            return false;
        }

        boolean validationResult = Pattern.matches(NUM_PATTERN, string);
        logger.debug("Validation result: string '" + string + "' is " + (validationResult ? "valid" : "invalid"));
        return validationResult;
    }
}
