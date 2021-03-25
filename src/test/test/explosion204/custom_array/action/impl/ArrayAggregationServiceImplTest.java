package test.explosion204.custom_array.action.impl;

import com.explosion204.custom_array.CustomArray;
import com.explosion204.custom_array.action.ArrayAggregationService;
import com.explosion204.custom_array.action.impl.ArrayAggregationServiceImpl;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ArrayAggregationServiceImplTest {
    private CustomArray initialArray;
    private ArrayAggregationService service;

    @BeforeClass
    public void setUp() {
        initialArray = new CustomArray(5, 17, 6, -3, -2, 126, 5, 15, 15, 4);
        service = new ArrayAggregationServiceImpl();
    }

    @Test
    public void testFindMin() {
        int actual = service.findMin(initialArray);
        int expected = -3;

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testFindMax() {
        int actual = service.findMax(initialArray);
        int expected = 126;

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testFindAvg() {
        double actual = service.findAvg(initialArray);
        double expected = 18.8;

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testFindSum() {
        long actual = service.findSum(initialArray);
        long expected = 188;

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testFindPositivesCount() {
        int actual = service.findPositivesCount(initialArray);
        int expected = 8;

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testFindNegativesCount() {
        int actual = service.findNegativesCount(initialArray);
        int expected = 2;

        Assert.assertEquals(actual, expected);
    }
}