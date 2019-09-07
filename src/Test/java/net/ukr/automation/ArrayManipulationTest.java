package net.ukr.automation;

import net.ukr.automation.transformations.ArrayEvenOddTransformation;
import net.ukr.automation.transformations.ArraySumOfElements;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class ArrayManipulationTest {

    int[] input = new int[] {1,2,3,4,5,-3,2,5,7,9,0,2,3,4,1,-10,12,14};
    int[] output = new int[] {2,4,2,0,2,4,-10,12,14,1,3,5,-3,5,7,9,3,1};
    int sum = 61;

    ArrayEvenOddTransformation at = new ArrayEvenOddTransformation();
    ArraySumOfElements as = new ArraySumOfElements();

    @Test
    public void overloadedEvenOddArrayTransformationTest()
    {
        Assert.assertEquals(Arrays.toString(at.overloadedEvenOddArrayTransformation(input)), Arrays.toString(output));
    }

    @Test
    public void lightEvenOddArrayTransformationTest()
    {
        Assert.assertEquals(Arrays.toString(at.lightEvenOddArrayTransformation(input)), Arrays.toString(output));
    }

    @Test
    public void ArraySumOfElementsTest()
    {
        Assert.assertEquals(Integer.toString(as.sumOfArrayElements(input)), Integer.toString(sum));
    }
}
