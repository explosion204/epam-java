package test.karnyshov.array.action.impl;

import com.karnyshov.array.entity.CustomArray;
import com.karnyshov.array.action.ArrayAggregationService;
import com.karnyshov.array.action.impl.ArrayAggregationServiceImpl;
import com.karnyshov.array.exception.CustomArrayException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ArrayAggregationServiceImplTest {
    private CustomArray initialArray;
    private ArrayAggregationService service;

    @BeforeClass
    public void setUp() {
        initialArray = CustomArray.createArrayFromValues(5, 17, 6, -3, -2, 126, 5, 15, 15, 4);
        service = new ArrayAggregationServiceImpl();
    }

    @Test
    public void testFindMin() throws CustomArrayException {
        int actual = service.findMin(initialArray);
        int expected = -3;

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testFindMax() throws CustomArrayException {
        int actual = service.findMax(initialArray);
        int expected = 126;

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testFindAvg() throws CustomArrayException {
        double actual = service.findAvg(initialArray);
        double expected = 18.8;

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testFindSum() throws CustomArrayException {
        long actual = service.findSum(initialArray);
        long expected = 188;

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testFindPositivesCount() throws CustomArrayException {
        long actual = service.findPositivesCount(initialArray);
        long expected = 8;

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testFindNegativesCount() throws CustomArrayException {
        long actual = service.findNegativesCount(initialArray);
        long expected = 2;

        Assert.assertEquals(actual, expected);
    }
}