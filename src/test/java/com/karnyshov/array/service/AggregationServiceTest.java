package com.karnyshov.array.service;

import com.karnyshov.array.creator.CustomArrayCreator;
import com.karnyshov.array.service.impl.AggregationServiceImpl;
import com.karnyshov.array.entity.CustomArray;
import com.karnyshov.array.service.impl.AggregationServiceStreamImpl;
import com.karnyshov.array.exception.CustomArrayException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AggregationServiceTest {
    private CustomArray initialArray;
    private AggregationService defaultServiceImpl;
    private AggregationService streamServiceImpl;

    @BeforeClass
    public void setUp() throws CustomArrayException {
        CustomArrayCreator creator = new CustomArrayCreator();
        initialArray = creator.createFromValues(5, 17, 6, -3, -2, 126, 5, 15, 15, 4);
        defaultServiceImpl = new AggregationServiceImpl();
        streamServiceImpl = new AggregationServiceStreamImpl();
    }

    @DataProvider(name = "service-provider")
    public Object[][] serviceProvider() {
        return new Object[][] {
                { defaultServiceImpl },
                { streamServiceImpl }
        };
    }

    @Test(dataProvider = "service-provider")
    public void testFindMin(AggregationService service) throws CustomArrayException {
        int actual = service.findMin(initialArray);
        int expected = -3;

        Assert.assertEquals(actual, expected);
    }

    @Test(dataProvider = "service-provider")
    public void testFindMax(AggregationService service) throws CustomArrayException {
        int actual = service.findMax(initialArray);
        int expected = 126;

        Assert.assertEquals(actual, expected);
    }

    @Test(dataProvider = "service-provider")
    public void testFindAvg(AggregationService service) throws CustomArrayException {
        double actual = service.findAvg(initialArray);
        double expected = 18.8;

        Assert.assertEquals(actual, expected);
    }

    @Test(dataProvider = "service-provider")
    public void testFindSum(AggregationService service) throws CustomArrayException {
        long actual = service.findSum(initialArray);
        long expected = 188;

        Assert.assertEquals(actual, expected);
    }

    @Test(dataProvider = "service-provider")
    public void testFindPositivesCount(AggregationService service) throws CustomArrayException {
        long actual = service.findPositivesCount(initialArray);
        long expected = 8;

        Assert.assertEquals(actual, expected);
    }

    @Test(dataProvider = "service-provider")
    public void testFindNegativesCount(AggregationService service) throws CustomArrayException {
        long actual = service.findNegativesCount(initialArray);
        long expected = 2;

        Assert.assertEquals(actual, expected);
    }
}