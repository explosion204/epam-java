package test.karnyshov.array.parser.impl;

import com.karnyshov.array.parser.FileParser;
import com.karnyshov.array.parser.impl.FileParserImpl;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class FileParserImplTest {
    FileParser parser;

    @BeforeClass
    public void setUp() {
        parser = new FileParserImpl();
    }

    @DataProvider(name = "file-data-provider")
    public Object[][] fileDataProvider() {
        return new Object[][] {
                { "test_data/test_data_01.txt", new String[] { "1 faaa", "1 6 4 2 15 1 2 63"} },
                { "test_data/test_data_02.txt", new String[] { "5 6f 4 7 5", "6 7 6 86q 1 3", "4 5" } },
                { "test_data/test_data_03.txt", new String[] { "1 5 q@", "1 5 q@", "1 5 q@", "1 5 q@" } },
                { "test_data/test_data_04.txt", new String[] { "q q q 1 5 q fff" } }
        };
    }

    @Test(dataProvider = "file-data-provider")
    public void testParseData(String filePath, String[] expectedArray)
            throws IOException {
        String[] actualArray = parser.parseFile(filePath);

        Assert.assertEquals(actualArray, expectedArray);
    }
}
