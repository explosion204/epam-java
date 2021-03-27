package test.karnyshov.array.creator.impl;

import com.karnyshov.array.creator.ArrayCreator;
import com.karnyshov.array.creator.impl.ArrayCreatorImpl;
import com.karnyshov.array.entity.CustomArray;
import com.karnyshov.array.exception.CustomArrayException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ArrayCreatorTest {
    private ArrayCreator creator;

    @BeforeClass
    public void setUp() {
        creator = new ArrayCreatorImpl();
    }

    @DataProvider(name = "valid-data-provider")
    public Object[][] validDataProvider() {
        return new Object[][] {
                { "test_data/test_data_01.txt", "{ 1 6 4 2 15 1 2 63 }" },
                { "test_data/test_data_02.txt", "{ 4 5 }" }
        };
    }

    @DataProvider(name = "invalid-data-provider")
    public Object[][] invalidDataProvider() {
        return new Object[][] {
            { "test_data/test_data_03.txt" },
            { "test_data/test_data_04.txt" }
        };
    }

    @Test(dataProvider = "valid-data-provider")
    public void testCreateFromFile(String filePath, String expectedString)
            throws CustomArrayException {
        CustomArray array = creator.createFromFile(filePath);

        String actualString = array.toString();
        Assert.assertEquals(actualString, expectedString);
    }

    @Test(dataProvider = "invalid-data-provider", expectedExceptions = CustomArrayException.class)
    public void testCreateFromFileInvalidData(String filePath)
            throws CustomArrayException {
        creator.createFromFile(filePath);
    }

    @Test(expectedExceptions = CustomArrayException.class)
    public void testCreateFromFileNotFound() throws CustomArrayException {
        creator.createFromFile("someFile");
    }
}
