package com.karnyshov.array.parser.impl;

import com.karnyshov.array.parser.FileParser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class FileParserImpl implements FileParser {
    @Override
    public String[] parseFile(String filePath) throws IOException {
        try (Stream<String> stream = Files.lines(Path.of(filePath))) {
            return stream.toArray(String[]::new);
        }
    }
}
