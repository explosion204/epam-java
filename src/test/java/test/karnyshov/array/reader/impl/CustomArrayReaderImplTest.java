package test.karnyshov.array.reader.impl;

import com.karnyshov.array.exception.CustomArrayException;
import com.karnyshov.array.reader.CustomArrayReader;
import com.karnyshov.array.reader.impl.CustomArrayReaderImpl;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.net.URL;

public class CustomArrayReaderImplTest {
    private CustomArrayReader reader;

    @BeforeClass
    public void setUp() {
        reader = new CustomArrayReaderImpl();
    }

    private String getResourcePath(String resourceName) {
        ClassLoader loader = getClass().getClassLoader();
        URL resource = loader.getResource(resourceName);
        return new File(resource.getFile()).getAbsolutePath();
    }

    @DataProvider(name = "file-data-provider")
    public Object[][] fileDataProvider() {
        return new Object[][] {
                {
                    getResourcePath("test_data/test_data_01.txt"),
                    new String[] { "1 faaa", "1 6 4 2 15 1 2 63" }
                },
                {
                    getResourcePath("test_data/test_data_02.txt"),
                    new String[] { "5 6f 4 7 5", "6 7 6 86q 1 3", "4 5" }
                },
                {
                    getResourcePath("test_data/test_data_03.txt"),
                    new String[] { "1 5 q@", "1 5 q@", "1 5 q@", "1 5 q@" }
                },
                {
                    getResourcePath("test_data/test_data_04.txt"),
                    new String[] { "q q q 1 5 q fff" }
                }
        };
    }

    @Test(dataProvider = "file-data-provider")
    public void testFromFile(String filePath, String[] expectedArray)
            throws CustomArrayException {
        String[] actualArray = reader.readFromFile(filePath);

        Assert.assertEquals(actualArray, expectedArray);
    }

    @Test(expectedExceptions = CustomArrayException.class)
    public void testFromFileWithInvalidPath()
            throws CustomArrayException {
        reader.readFromFile("wrongPath");
    }
}
