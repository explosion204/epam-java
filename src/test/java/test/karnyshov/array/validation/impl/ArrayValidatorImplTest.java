package test.karnyshov.array.validation.impl;

import com.karnyshov.array.validation.ArrayValidator;
import com.karnyshov.array.validation.impl.ArrayValidatorImpl;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ArrayValidatorImplTest {
    private ArrayValidator validator;

    @BeforeClass
    public void setUp() {
        validator = new ArrayValidatorImpl();
    }

    @DataProvider(name = "valid-data")
    public Object[][] validDataProvider() {
        return new Object[][] {
                {"1 2 3 4 154 6 2 3", new int[] { 1, 2, 3, 4, 154, 6, 2, 3 }},
                {"-1 5 4 5 6 4 5 74 4", new int[] { -1, 5, 4, 5, 6, 4, 5, 74, 4 }},
                {"5 334 5 54 -2 -65 -4", new int[] { 5, 334, 5, 54, -2, -65, -4 }}
        };
    }

    @DataProvider(name = "invalid-data")
    public Object[][] invalidDataProvider() {
        return new Object[][] {
                {"1 15f 4 scd$ 4 5 45 %"},
                {"2 --5 +6 4 52 ff"},
                {"1.* 1.0 8 41"}
        };
    }

    @Test(dataProvider = "valid-data")
    public void testValidateWithValidData(String line, int[] expectedArray) {
        int[] actualArray = validator.validate(line);

        Assert.assertEquals(actualArray, expectedArray);
    }

    @Test(dataProvider = "invalid-data")
    public void testValidateWithInvalidData(String line) {
        int[] array = validator.validate(line);

        Assert.assertEquals(array.length, 0);
    }
}
