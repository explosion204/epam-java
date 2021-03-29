package com.karnyshov.array.reader.impl;

import com.karnyshov.array.exception.CustomArrayException;
import com.karnyshov.array.reader.CustomArrayReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class CustomArrayReaderImpl implements CustomArrayReader {
    private static Logger logger = LogManager.getLogger();

    @Override
    public String[] readFromFile(String filePath) throws CustomArrayException {
        Path pathObj = Path.of(filePath);
        try (Stream<String> stream = Files.lines(pathObj)) {
            return stream.toArray(String[]::new);
        } catch (IOException e) {
            String errorMsg = "Unable to open file: " + filePath;
            logger.error(errorMsg);
            throw new CustomArrayException(errorMsg, e);
        }
    }
}
