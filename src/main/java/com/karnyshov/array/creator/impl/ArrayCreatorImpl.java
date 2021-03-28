package com.karnyshov.array.creator.impl;

import com.karnyshov.array.validation.ArrayValidator;
import com.karnyshov.array.creator.ArrayCreator;
import com.karnyshov.array.entity.CustomArray;
import com.karnyshov.array.exception.CustomArrayException;
import com.karnyshov.array.parser.FileParser;
import com.karnyshov.array.parser.impl.FileParserImpl;
import com.karnyshov.array.validation.impl.ArrayValidatorImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class ArrayCreatorImpl implements ArrayCreator {
    private static Logger logger = LogManager.getLogger();

    @Override
    public CustomArray createFromFile(String filePath) throws CustomArrayException {
        FileParser parser = new FileParserImpl();
        ArrayValidator validator = new ArrayValidatorImpl();
        String[] strings = null;
        int[] values = null;

        try {
            strings = parser.parseFile(filePath);

            for (String string : strings) {
                int[] valuesCandidate = validator.validate(string);

                if (valuesCandidate.length > 0) {
                    values = valuesCandidate;
                    break;
                }
            }

            if (values == null) {
                String errorMsg = "Specified file does not contain any valid data";
                logger.error(errorMsg);
                throw new CustomArrayException(errorMsg);
            }

            return CustomArray.createArrayFromValues(values);
        } catch (IOException e) {
            String errorMsg = "Unable to open file with following path: " + filePath;
            logger.error(errorMsg);
            throw new CustomArrayException(errorMsg);
        }
    }
}
