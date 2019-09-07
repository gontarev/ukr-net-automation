package net.ukr.automation.transformations;

import java.util.Arrays;

public class ArrayEvenOddTransformation {
    public int[] overloadedEvenOddArrayTransformation(int[] arrayToTransform) {

        // definition of variables for size of arrays for even and odd elements of original array
        int arrayEvenSize = 0;
        int arrayOddSize = 0;

        System.out.println("You choosed to transform the array weirdest way.");
        System.out.println("Even elements will be placed first, and odd after them.");
        System.out.println("Predefined array is: " + Arrays.toString(arrayToTransform));
        System.out.println("It contains " + arrayToTransform.length + " elements.");

        // get number of even elements of original array to define size of array for even elements
        for (int i = 0 ; i < arrayToTransform.length ; i++) {
            if (arrayToTransform[i] % 2 == 0) {
                arrayEvenSize ++;
            }
            // get number of odd elements of original array to define size of array for odd elements
            else arrayOddSize ++;
        }

        System.out.println("Number of even elements: " + arrayEvenSize);
        System.out.println("Number of odd elements: " + arrayOddSize);

        // defining array of even elements of original array
        int arrayEven[] = new int[arrayEvenSize];
        // defining array of odd elements of original array
        int arrayOdd[] = new int[arrayOddSize];

        // temporary variables for indexes of corresponding arrays
        int tempEven = 0;
        int tempOdd = 0;

        // filling arrays with even and odd elements
        for (int i = 0 ; i < arrayToTransform.length ; i++) {
            if (arrayToTransform[i] % 2 == 0) {
                arrayEven[tempEven] = arrayToTransform[i];
                tempEven ++;
            }   else {
                arrayOdd[tempOdd] = arrayToTransform[i];
                tempOdd++;
            }
        }

        // merging even and odd arrays into original array replacing its value
        System.arraycopy(arrayEven, 0, arrayToTransform, 0, arrayEven.length);
        System.arraycopy(arrayOdd, 0, arrayToTransform, arrayEven.length, arrayOdd.length);

        return arrayToTransform;
    }

    public int[] lightEvenOddArrayTransformation(int[] arrayToTransform) {
        int temp;

        System.out.println("You choosed to transform the array weird shit way.");
        System.out.println("Even elements will be placed first, and odd after them.");
        System.out.println("Predefined array is: " + Arrays.toString(arrayToTransform));

        // array transformation with even elements placed first correctly and odd elements next at inverted order
        for (int i = 1 ; i < arrayToTransform.length ; i++) {
            for (int j = i; j > 0; j--) {
                if (arrayToTransform[j - 1] % 2 != 0) {
                    temp = arrayToTransform[j - 1];
                    arrayToTransform[j - 1] = arrayToTransform[j];
                    arrayToTransform[j] = temp;
                }
            }
        }

        // fix for inverted positions of odd elements to make their order correspond to original array order
        for (int i = 1 ; i < arrayToTransform.length ; i++) {
            for (int j = i; j > 0; j--) {
                if (arrayToTransform[j - 1] % 2 != 0) {
                    temp = arrayToTransform[j - 1];
                    arrayToTransform[j - 1] = arrayToTransform[j];
                    arrayToTransform[j] = temp;
                }
            }
        }

        return arrayToTransform;
    }
}
