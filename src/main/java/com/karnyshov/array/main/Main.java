package com.karnyshov.array.main;

import com.karnyshov.array.creator.CustomArrayCreator;
import com.karnyshov.array.entity.CustomArray;
import com.karnyshov.array.exception.CustomArrayException;
import com.karnyshov.array.parser.CustomArrayParser;
import com.karnyshov.array.reader.CustomFileReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.net.URL;
import java.util.Arrays;

public class Main {
    private static Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        CustomFileReader reader = new CustomFileReader();
        CustomArrayParser parser = new CustomArrayParser();
        CustomArrayCreator creator = new CustomArrayCreator();

        ClassLoader loader = Main.class.getClassLoader();
        URL resource = loader.getResource("data/data.txt");
        assert resource != null;
        String filePath = new File(resource.getFile()).getAbsolutePath();
        logger.info("File path: " + filePath);

        try {
            String rawString = reader.readFromFile(filePath);
            logger.info("String read from file: " + rawString);

            int[] parsedValues = parser.parseString(rawString);
            logger.info("Parsed values: " + Arrays.toString(parsedValues));

            CustomArray array = creator.createFromValues(parsedValues);
            logger.info("Created array: " + array.toString());
        } catch (CustomArrayException e) {
            logger.error(e.getMessage() + ": " + e.getCause());
        }
    }
}
