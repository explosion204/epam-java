package test.karnyshov.array.validation.impl;

import com.karnyshov.array.exception.CustomArrayException;
import com.karnyshov.array.validation.CustomArrayValidator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CustomArrayValidatorImplTest {
    @DataProvider(name = "valid-data")
    public Object[][] validDataProvider() {
        return new Object[][] {
                {"1 2 3 4 154 6 2 3"},
                {"-1 5 4 5 6 4 5 74 4"},
                {"5 334 5 54 -2 -65 -4"}
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
    public void testValidateWithValidData(String line)
            throws CustomArrayException {
        boolean actual = CustomArrayValidator.validate(line);

        Assert.assertTrue(actual);
    }

    @Test(dataProvider = "invalid-data")
    public void testValidateWithInvalidData(String line)
            throws CustomArrayException {
        boolean actual = CustomArrayValidator.validate(line);

        Assert.assertFalse(actual);
    }
}
