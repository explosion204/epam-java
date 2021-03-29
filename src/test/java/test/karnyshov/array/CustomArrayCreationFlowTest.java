package test.karnyshov.array;

import com.karnyshov.array.exception.CustomArrayException;
import com.karnyshov.array.parser.CustomArrayParser;
import com.karnyshov.array.parser.impl.CustomArrayParserImpl;
import com.karnyshov.array.reader.CustomArrayReader;
import com.karnyshov.array.reader.impl.CustomArrayReaderImpl;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CustomArrayCreationFlowTest {
    private String[] strings;

    @Test
    public void testReadFromFile() throws CustomArrayException {
        CustomArrayReader reader = new CustomArrayReaderImpl();
        strings = reader.readFromFile("test_data/test_data_01.txt");
    }

    @Test(dependsOnMethods = "testReadFromFile")
    public void testParse() throws CustomArrayException {
        CustomArrayParser parser = new CustomArrayParserImpl();

        int[] expectedArray = { 1, 6, 4, 2, 15, 1, 2, 63 };
        int[] actualArray = parser.parseStrings(strings);

        Assert.assertEquals(actualArray, expectedArray);
    }
}
