package com.karnyshov.array.service;

import com.karnyshov.array.creator.CustomArrayCreator;
import com.karnyshov.array.entity.CustomArray;
import com.karnyshov.array.exception.CustomArrayException;
import com.karnyshov.array.service.impl.SortServiceInsertionImpl;
import com.karnyshov.array.service.impl.SortServiceMergeImpl;
import com.karnyshov.array.service.impl.SortServiceQuickImpl;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SortServiceTest {
    private SortService quickSortService;
    private SortService mergeSortService;
    private SortService insertionSortService;

    @BeforeClass
    public void setUp() {
        quickSortService = new SortServiceQuickImpl();
        mergeSortService = new SortServiceMergeImpl();
        insertionSortService = new SortServiceInsertionImpl();
    }

    @DataProvider(name = "data-provider")
    public Object[][] serviceProvider() throws CustomArrayException, CloneNotSupportedException {
        CustomArrayCreator creator = new CustomArrayCreator();
        CustomArray testArray = creator.createFromValues(5, 17, 6, 3, 2, 126, 5, 15, 15, 4);

        return new Object[][] {
                { quickSortService, testArray },
                { mergeSortService, testArray.clone() },
                { insertionSortService, testArray.clone() }
        };
    }

    @Test(dataProvider = "data-provider")
    public void testSort(SortService sortService, CustomArray testArray) throws CustomArrayException {
        sortService.sort(testArray);

        String actual = testArray.toString();
        String expected = "{ 2 3 4 5 5 6 15 15 17 126 }";
        Assert.assertEquals(actual, expected);
    }
}
