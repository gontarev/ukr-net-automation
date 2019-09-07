package net.ukr.automation.transformations;

import java.util.Arrays;

public class ArraySumOfElements {

    public int sumOfArrayElements(int[] arrayForSum) {

        int sum = 0;

        System.out.println("You choosed to get the sum of the elements of the array.");
        System.out.println("Predefined array is: " + Arrays.toString(arrayForSum));
        // loop to get the sum of the array elements
        for (int i : arrayForSum) {
            sum += i;
        }
        // Output of the sum of the array
        return sum;
    }
}
