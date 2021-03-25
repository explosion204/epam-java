package test.explosion204.custom_array.action.impl;

import com.explosion204.custom_array.CustomArray;
import com.explosion204.custom_array.action.ArrayManipulationService;
import com.explosion204.custom_array.action.impl.ArrayManipulationServiceImpl;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class ArrayManipulationServiceImplTest {
    private ArrayManipulationService service;

    @BeforeClass
    public void setUp() {
        service = new ArrayManipulationServiceImpl();
    }

    @Test
    public void testReplace() {
        CustomArray testArray = new CustomArray(5, 17, 6, 3, 2, 126, 5, 15, 15, 4);

        Predicate<Integer> predicate = (value) -> value % 2 == 0;
        UnaryOperator<Integer> transform = (value) -> ++value;

        service.replace(testArray, predicate, transform);

        String actual = testArray.toString();
        String expected = "{ 5 17 7 3 3 127 5 15 15 5 }";
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testMergeSort() {
        CustomArray testArray = new CustomArray(5, 17, 6, 3, 2, 126, 5, 15, 15, 4);
        int testArrayLength = testArray.getLength();

        service.mergeSort(testArray, testArrayLength);

        String actual = testArray.toString();
        String expected = "{ 2 3 4 5 5 6 15 15 17 126 }";
        Assert.assertEquals(actual, expected);
    }
}