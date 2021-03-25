package test.explosion204.custom_array;

import com.explosion204.custom_array.CustomArray;

import com.explosion204.custom_array.exception.CustomArrayException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CustomArrayTest {
    private CustomArray firstArray;
    private CustomArray secondArray;
    private CustomArray thirdArray;
    private CustomArray fourthArray;

    @BeforeClass
    public void setUp() {
        firstArray = new CustomArray(new int[] { 5, 17, 6 });
        secondArray = new CustomArray(new int[] { 5, 17, 6 });
        thirdArray = new CustomArray(new int[] { 5, 17, 1 });
        fourthArray = new CustomArray(new int [] { 5, 2 });
    }

    @Test
    public void testGet() throws CustomArrayException {
        int actual = fourthArray.get(1);

        int expected = 2;
        Assert.assertEquals(actual, expected);
    }

    @Test(expectedExceptions = CustomArrayException.class)
    public void testGetException() throws CustomArrayException {
        fourthArray.get(2);
    }

    @Test
    public void testSet() throws CustomArrayException {
        fourthArray.set(0, 1);

        int actual = fourthArray.get(0);
        int expected = 1;

        Assert.assertEquals(actual, expected);
    }

    @Test(expectedExceptions = CustomArrayException.class)
    public void testSetException() throws CustomArrayException {
        fourthArray.set(2, 1);
    }

    @Test
    public void testGetCopyObjectEquality() {
        CustomArray arrayCopy = firstArray.getCopy();
        boolean comparison = firstArray.equals(arrayCopy);

        Assert.assertTrue(comparison);
    }

    @Test
    public void testGetCopyHashCodeEquality() {
        CustomArray arrayCopy = firstArray.getCopy();

        int actualHashCode = arrayCopy.hashCode();
        int expectedHashCode = firstArray.hashCode();

        Assert.assertEquals(actualHashCode, expectedHashCode);
    }

    @Test
    public void testHashCodeWhenObjectsEqual() {
        int firstHashCode = firstArray.hashCode();
        int secondHashCode = secondArray.hashCode();

        Assert.assertEquals(firstHashCode, secondHashCode);
    }

    @Test
    public void testHashCodeWhenObjectsNotEqual() {
        int firstHashCode = firstArray.hashCode();
        int thirdHashCode = thirdArray.hashCode();

        Assert.assertNotEquals(firstHashCode, thirdHashCode);
    }

    @Test
    public void testEqualsWhenObjectsEqual() {
        boolean comparison = firstArray.equals(secondArray);

        Assert.assertTrue(comparison);
    }

    @Test
    public void testEqualsWhenObjectsNotEqual() {
        boolean comparison = secondArray.equals(thirdArray);

        Assert.assertFalse(comparison);
    }

    @Test
    public void testEqualsWithNull() {
        boolean comparison = firstArray.equals(null);

        Assert.assertFalse(comparison);
    }

    @Test
    public void testEqualsWhenObjectsSame() {
        boolean comparison = firstArray.equals(firstArray);

        Assert.assertTrue(comparison);
    }

    @Test
    public void testEqualsWithInvalidType() {
        boolean comparison = firstArray.equals(new int[] { 1 });

        Assert.assertFalse(comparison);
    }

    @Test
    public void testEqualsWithDifferentLengths() {
        boolean comparison = firstArray.equals(fourthArray);

        Assert.assertFalse(comparison);
    }

    @Test
    public void testToString() {
        String actual = firstArray.toString();
        String expected = "{ 5 17 6 }";

        Assert.assertEquals(actual, expected);
    }
}