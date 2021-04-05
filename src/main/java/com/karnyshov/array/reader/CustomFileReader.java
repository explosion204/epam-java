package com.karnyshov.array.reader;

import com.karnyshov.array.exception.CustomArrayException;
import com.karnyshov.array.validation.CustomArrayValidator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.util.stream.Stream;

public class CustomFileReader {
    public String readFromFile(String filePath) throws CustomArrayException {
        try {
            Path path = Path.of(filePath);

            try (Stream<String> stream = Files.lines(path)) {
                return stream.filter(CustomArrayValidator::validateString)
                        .findFirst()
                        .orElseThrow(() ->
                                new CustomArrayException("File (" + filePath + ") does not contain any valid data"));
            }
        } catch (InvalidPathException | IOException e) {
            throw new CustomArrayException("Unable to open file: " + filePath, e);
        }
    }
}
