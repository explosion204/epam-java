package test.karnyshov.array.parser.impl;

import com.karnyshov.array.exception.CustomArrayException;
import com.karnyshov.array.parser.CustomArrayParser;
import com.karnyshov.array.parser.impl.CustomArrayParserImpl;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CustomArrayParserImplTest {
    CustomArrayParser parser;

    @BeforeClass
    public void setUp() {
        parser = new CustomArrayParserImpl();
    }

    @DataProvider(name = "valid-data-provider")
    public Object[][] validDataProvider() {
        return new Object[][] {
                { new String[] { "1 faaa", "1 6 4 2 15 1 2 63" }, new int[] { 1, 6, 4, 2, 15, 1, 2, 63 } },
                { new String[] { "5 6f 4 7 5", "6 7 6 86q 1 3", "4 5" }, new int[] { 4, 5 } }
        };
    }

    @DataProvider(name = "invalid-data-provider")
    public Object[][] invalidDataProvider() {
        return new Object[][] {
                { new String[] { "1 5 q@", "1 5 q@", "1 5 q@", "1 5 q@" } },
                { new String[] { "q q q 1 5 q fff" } }
        };
    }

    @Test(dataProvider = "valid-data-provider")
    public void testParseStrings(String[] strings, int[] expectedArray) throws CustomArrayException {
        int[] actualArray = parser.parseStrings(strings);

        Assert.assertEquals(actualArray, expectedArray);
    }

    @Test(dataProvider = "invalid-data-provider", expectedExceptions = CustomArrayException.class)
    public void testParseStringsWithInvalidData(String[] strings) throws CustomArrayException {
        parser.parseStrings(strings);
    }
}
