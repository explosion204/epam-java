package com.karnyshov.array.parser;

import com.karnyshov.array.exception.CustomArrayException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CustomArrayParserTest {
    CustomArrayParser parser;

    @BeforeClass
    public void setUp() {
        parser = new CustomArrayParser();
    }

    @DataProvider(name = "valid-data-provider")
    public Object[][] validDataProvider() {
        return new Object[][] {
                { "1 6 4 2 15 1 2 63", new int[] { 1, 6, 4, 2, 15, 1, 2, 63 } },
                { "4 5", new int[] { 4, 5 } }
        };
    }

    @DataProvider(name = "invalid-data-provider")
    public Object[][] invalidDataProvider() {
        return new Object[][] {
                { "1 5 q@" }, { "q q q 1 5 q fff" }
        };
    }

    @Test(dataProvider = "valid-data-provider")
    public void testParseString(String string, int[] expectedArray) throws CustomArrayException {
        int[] actualArray = parser.parseString(string);

        Assert.assertEquals(actualArray, expectedArray);
    }

    @Test(dataProvider = "invalid-data-provider", expectedExceptions = CustomArrayException.class)
    public void testParseStringWithInvalidData(String string) throws CustomArrayException {
        parser.parseString(string);
    }
}
