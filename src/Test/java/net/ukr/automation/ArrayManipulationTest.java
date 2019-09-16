package net.ukr.automation;

import net.ukr.automation.transformations.ArrayEvenOddTransformation;
import net.ukr.automation.transformations.ArraySumOfElements;
import org.junit.Assert;
import org.junit.Test;
import java.util.Arrays;

public class ArrayManipulationTest {

    // test data for overloadedEvenOddArrayTransformationTest
    int[] input = new int[] {1,2,3,4,5,-3,2,5,7,9,0,2,3,4,1,-10,12,14};
    int[] output = new int[] {2,4,2,0,2,4,-10,12,14,1,3,5,-3,5,7,9,3,1};
    // test data for lightEvenOddArrayTransformationTest and arraySumOfElementsTest
    int[] input2 = new int[]{28, -39, -36, 45, 49, 38, -62, -1, -8, -63, 11, 34, 80, -58, 23, 40, 32, -57, 2, 58, 41, -71, -23, 80, 54, -36, -13, -56, 95, -97};
    int[] output2 = new int[]{28, -36, 38, -62, -8, 34, 80, -58, 40, 32, 2, 58, 80, 54, -36, -56, -39, 45, 49, -1, -63, 11, 23, -57, 41, -71, -23, -13, 95, -97};
    // sum of input2 array elements
    int sum = 90;

    ArrayEvenOddTransformation at = new ArrayEvenOddTransformation();
    ArraySumOfElements as = new ArraySumOfElements();

    @Test
    public void overloadedEvenOddArrayTransformationTest()
    {
        Assert.assertEquals(Arrays.toString(output), Arrays.toString(at.overloadedEvenOddArrayTransformation(input)));
    }

    @Test
    public void lightEvenOddArrayTransformationTest()
    {
        Assert.assertEquals(Arrays.toString(output2), Arrays.toString(at.lightEvenOddArrayTransformation(input2)));
    }

    @Test
    public void ArraySumOfElementsTest()
    {
        Assert.assertEquals(Integer.toString(sum), Integer.toString(as.sumOfArrayElements(input2)));
    }
}
