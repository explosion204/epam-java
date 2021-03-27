package com.karnyshov.array.parser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

public interface FileParser {
    String[] parseFile(String filePath) throws IOException;
}
