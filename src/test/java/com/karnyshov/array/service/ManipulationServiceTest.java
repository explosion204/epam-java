package com.karnyshov.array.service;

import com.karnyshov.array.creator.CustomArrayCreator;
import com.karnyshov.array.entity.CustomArray;
import com.karnyshov.array.service.ManipulationService;
import com.karnyshov.array.service.impl.ManipulationServiceImpl;
import com.karnyshov.array.exception.CustomArrayException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class ManipulationServiceTest {
    @Test
    public void testReplace() throws CustomArrayException {
        ManipulationService service = new ManipulationServiceImpl();
        CustomArrayCreator creator = new CustomArrayCreator();
        CustomArray testArray = creator.createFromValues(5, 17, 6, 3, 2, 126, 5, 15, 15, 4);
        Predicate<Integer> predicate = (value) -> value % 2 == 0;
        UnaryOperator<Integer> transform = (value) -> ++value;

        service.replace(testArray, predicate, transform);

        String actual = testArray.toString();
        String expected = "{ 5 17 7 3 3 127 5 15 15 5 }";
        Assert.assertEquals(actual, expected);
    }
}