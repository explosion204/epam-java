package test.explosion204.custom_array.action;

import com.explosion204.custom_array.CustomArray;
import com.explosion204.custom_array.action.ArrayManipulation;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class ArrayManipulationTest {
    private CustomArray initialArray;

    @BeforeClass
    public void setUp() {
        initialArray = new CustomArray(new int[] { 5, 17, 6, 3, 2, 126, 5, 15, 15, 4 });
    }

    @Test
    public void testReplace() {
        CustomArray testArray = initialArray.getCopy();
        Predicate<Integer> predicate = (value) -> value % 2 == 0;
        UnaryOperator<Integer> transform = (value) -> ++value;

        ArrayManipulation.replace(testArray, predicate, transform);

        String actual = testArray.toString();
        String expected = "{ 5 17 7 3 3 127 5 15 15 5 }";
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testMergeSort() {
        CustomArray testArray = initialArray.getCopy();
        int testArrayLen = initialArray.getLength();

        ArrayManipulation.mergeSort(testArray, testArrayLen);

        String actual = testArray.toString();
        String expected = "{ 2 3 4 5 5 6 15 15 17 126 }";
        Assert.assertEquals(actual, expected);
    }
}