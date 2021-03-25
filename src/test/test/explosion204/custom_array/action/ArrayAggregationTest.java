package test.explosion204.custom_array.action;

import com.explosion204.custom_array.CustomArray;
import com.explosion204.custom_array.action.ArrayAggregation;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ArrayAggregationTest {
    private CustomArray initialArray;

    @BeforeClass
    public void setUp() {
        initialArray = new CustomArray(new int[] { 5, 17, 6, -3, -2, 126, 5, 15, 15, 4 });
    }

    @Test
    public void testFindMin() {
        int actual = ArrayAggregation.findMin(initialArray);
        int expected = -3;

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testFindMax() {
        int actual = ArrayAggregation.findMax(initialArray);
        int expected = 126;

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testFindAvg() {
        double actual = ArrayAggregation.findAvg(initialArray);
        double expected = 18.8;

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testFindSum() {
        long actual = ArrayAggregation.findSum(initialArray);
        long expected = 188;

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testFindPositivesCount() {
        int actual = ArrayAggregation.findPositivesCount(initialArray);
        int expected = 8;

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testFindNegativesCount() {
        int actual = ArrayAggregation.findNegativesCount(initialArray);
        int expected = 2;

        Assert.assertEquals(actual, expected);
    }
}