package com.karnyshov.array.reader;

import com.karnyshov.array.exception.CustomArrayException;

public interface CustomArrayReader {
    String[] readFromFile(String filePath) throws CustomArrayException;
}
