package test.karnyshov.array.action.impl;

import com.karnyshov.array.entity.CustomArray;
import com.karnyshov.array.action.ArrayManipulationService;
import com.karnyshov.array.action.impl.ArrayManipulationServiceImpl;
import com.karnyshov.array.exception.CustomArrayException;
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
    public void testReplace() throws CustomArrayException {
        CustomArray testArray = CustomArray.createArrayFromValues(5, 17, 6, 3, 2, 126, 5, 15, 15, 4);
        Predicate<Integer> predicate = (value) -> value % 2 == 0;
        UnaryOperator<Integer> transform = (value) -> ++value;

        service.replace(testArray, predicate, transform);

        String actual = testArray.toString();
        String expected = "{ 5 17 7 3 3 127 5 15 15 5 }";
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testMergeSort() throws CustomArrayException {
        CustomArray testArray = CustomArray.createArrayFromValues(5, 17, 6, 3, 2, 126, 5, 15, 15, 4);
        service.mergeSort(testArray);

        String actual = testArray.toString();
        String expected = "{ 2 3 4 5 5 6 15 15 17 126 }";
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testQuickSort() throws CustomArrayException {
        CustomArray testArray = CustomArray.createArrayFromValues(5, 17, 6, 3, 2, 126, 5, 15, 15, 4);
        service.quickSort(testArray);

        String actual = testArray.toString();
        String expected = "{ 2 3 4 5 5 6 15 15 17 126 }";
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testInsertionSort() throws CustomArrayException {
        CustomArray testArray = CustomArray.createArrayFromValues(5, 17, 6, 3, 2, 126, 5, 15, 15, 4);
        service.insertionSort(testArray);

        String actual = testArray.toString();
        String expected = "{ 2 3 4 5 5 6 15 15 17 126 }";
        Assert.assertEquals(actual, expected);
    }
}