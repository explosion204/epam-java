package com.karnyshov.array.parser;

import java.io.IOException;

public interface FileParser {
    String[] parseFile(String filePath) throws IOException;
}
