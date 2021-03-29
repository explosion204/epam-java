package com.karnyshov.array.parser;

import com.karnyshov.array.exception.CustomArrayException;


public interface CustomArrayParser {
    int[] parseStrings(String[] strings) throws CustomArrayException;
}
