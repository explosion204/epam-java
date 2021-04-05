package com.karnyshov.array.reader;

import com.karnyshov.array.exception.CustomArrayException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.net.URL;

public class CustomFileReaderTest {
    private CustomFileReader reader;

    @BeforeClass
    public void setUp() {
        reader = new CustomFileReader();
    }

    private String getResourcePath(String resourceName) {
        ClassLoader loader = getClass().getClassLoader();
        URL resource = loader.getResource(resourceName);
        return new File(resource.getFile()).getAbsolutePath();
    }

    @DataProvider(name = "valid-file-data-provider")
    public Object[][] fileValidDataProvider() {
        return new Object[][] {
                { getResourcePath("test_data/test_data_01.txt"), "1 6 4 2 15 1 2 63" },
                { getResourcePath("test_data/test_data_02.txt"), "4 5" }
        };
    }

    @DataProvider(name = "invalid-file-data-provider")
    public Object[][] fileInvalidDataProvider() {
        return new Object[][] {
                { getResourcePath("test_data/test_data_03.txt") },
                { getResourcePath("test_data/test_data_04.txt") }
        };
    }

    @Test(dataProvider = "valid-file-data-provider")
    public void testReadFromFileValid(String filePath, String expected)
            throws CustomArrayException {
        String actual = reader.readFromFile(filePath);

        Assert.assertEquals(actual, expected);
    }

    @Test(dataProvider = "invalid-file-data-provider", expectedExceptions = CustomArrayException.class)
    public void testFromFileWithInvalid(String filePath)
            throws CustomArrayException {
        reader.readFromFile(filePath);
    }
}
