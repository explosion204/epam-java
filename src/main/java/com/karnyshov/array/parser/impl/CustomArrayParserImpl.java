package com.karnyshov.array.parser.impl;

import com.karnyshov.array.exception.CustomArrayException;
import com.karnyshov.array.parser.CustomArrayParser;
import com.karnyshov.array.validation.CustomArrayValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.stream.Stream;

public class CustomArrayParserImpl implements CustomArrayParser {
    private static Logger logger = LogManager.getLogger();
    private final String SPLIT_PATTERN = "\\s+";

    @Override
    public int[] parseStrings(String[] strings) throws CustomArrayException {
        if (strings == null || strings.length < 1) {
            String errorMsg = "Array of strings is empty or null";
            logger.error(errorMsg);
            throw new CustomArrayException(errorMsg);
        }

        for (String line : strings) {
            boolean isValid = CustomArrayValidator.validate(line);

            if (isValid) {
                String[] stringValues = line.split(SPLIT_PATTERN);

                return Stream.of(stringValues)
                        .mapToInt(Integer::decode)
                        .toArray();
            }

            logger.warn("Skipped invalid string: " + line);
        }

        String errorMsg = "Array of strings does not contain any valid data";
        logger.error(errorMsg);
        throw new CustomArrayException(errorMsg);
    }
}
