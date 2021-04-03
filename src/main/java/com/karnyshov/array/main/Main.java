package com.karnyshov.array.main;

import com.karnyshov.array.creator.CustomArrayCreator;
import com.karnyshov.array.entity.CustomArray;
import com.karnyshov.array.exception.CustomArrayException;
import com.karnyshov.array.parser.CustomArrayParser;
import com.karnyshov.array.reader.CustomFileReader;
import com.karnyshov.array.service.AggregationService;
import com.karnyshov.array.service.ManipulationService;
import com.karnyshov.array.service.SortService;
import com.karnyshov.array.service.impl.AggregationServiceStreamImpl;
import com.karnyshov.array.service.impl.ManipulationServiceImpl;
import com.karnyshov.array.service.impl.SortServiceMergeImpl;
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
        AggregationService aggregationService = new AggregationServiceStreamImpl();
        ManipulationService manipulationService = new ManipulationServiceImpl();
        SortService sortService = new SortServiceMergeImpl();

        ClassLoader loader = ClassLoader.getSystemClassLoader();
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

            int minValue = aggregationService.findMin(array);
            int maxValue = aggregationService.findMax(array);
            double avgValue = aggregationService.findAvg(array);
            long sum = aggregationService.findSum(array);
            long positivesCount = aggregationService.findPositivesCount(array);
            long negativesCount = aggregationService.findNegativesCount(array);
            logger.info("Min value: " + minValue);
            logger.info("Max value: " + maxValue);
            logger.info("Avg value: " + avgValue);
            logger.info("Sum: " + sum);
            logger.info("Positive elements count: " + positivesCount);
            logger.info("Negative elements count: " + negativesCount);

            manipulationService.replace(array, x -> x > 50, x -> 1);
            logger.info("All elements with value greater than 50 are replaced with 1. Modified array: "
                    + array.toString());

            sortService.sort(array);
            logger.info("Sorted array: " + array.toString());
        } catch (CustomArrayException e) {
            logger.error(e.getMessage() + ": " + e.getCause());
        }
    }
}
