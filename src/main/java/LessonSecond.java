import java.util.Arrays;
import java.util.Scanner;

public class LessonSecond {

    public static void sumOfArrayElements() {

        // array of 12 elements definition
        int[] arrayForSum = new int[]{0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89};
        int sum = 0;

        System.out.println("You choosed to get the sum of the elements of the array.");
        System.out.println("Predefined array is: " + Arrays.toString(arrayForSum));
        // loop to get the sum of the array elements
        for (int i : arrayForSum) {
            sum += i;
        }
        // Output of the sum of the array
        System.out.println("The sum of the array elements is: " + sum);
    }

    public static void weirdestEvenOddArrayTransformation() {
        // array to transform definition
        int[] arrayToTransform = new int[]{3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5, 8, 9, 7, 9, 3, 2, 3, 8, 4, 6, 2, 6, 4, 3, 3, 8, 3, 2, 7, 9, 5};
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
        }

        System.out.println("Number of even elements: " + arrayEvenSize);
        // defining array of even elements of original array
        int arrayEven[] = new int[arrayEvenSize];

        // get number of odd elements of original array to define size of array for odd elements
        for (int i = 0 ; i < arrayToTransform.length ; i++) {
            if (arrayToTransform[i] % 2 == 1) {
                arrayOddSize ++;
            }
        }

        System.out.println("Number of odd elements: " + arrayOddSize);

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

        System.out.println("Transformed weirdest way array is: " + Arrays.toString(arrayToTransform));
    }

    public static void weirdEvenOddArrayTransformation() {
        // array to transform definition
        int[] arrayToTransform = new int[]{3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5, 8, 9, 7, 9, 3, 2, 3, 8, 4, 6, 2, 6, 4, 3, 3, 8, 3, 2, 7, 9, 5};
        int temp;

        System.out.println("You choosed to transform the array weird shit way.");
        System.out.println("Even elements will be placed first, and odd after them.");
        System.out.println("Predefined array is: " + Arrays.toString(arrayToTransform));

        // array transformation with even elements placed first correctly and odd elements next at inverted order
        for (int i = 1 ; i < arrayToTransform.length ; i++) {
            for (int j = i; j > 0; j--) {
                if (arrayToTransform[j - 1] % 2 == 1) {
                    temp = arrayToTransform[j - 1];
                    arrayToTransform[j - 1] = arrayToTransform[j];
                    arrayToTransform[j] = temp;
                }
            }
        }

        // fix for inverted positions of odd elements to make their order correspond to original array order
        for (int i = 1 ; i < arrayToTransform.length ; i++) {
            for (int j = i; j > 0; j--) {
                if (arrayToTransform[j - 1] % 2 == 1) {
                    temp = arrayToTransform[j - 1];
                    arrayToTransform[j - 1] = arrayToTransform[j];
                    arrayToTransform[j] = temp;
                }
            }
        }

        System.out.println("Transformed weird shit way array is: " + Arrays.toString(arrayToTransform));
    }

    public static void main(String[] args) {
        // Variables initialization
        Integer keyInput;

        // Creation of a Scanner object
        Scanner input = new Scanner(System.in);

        // Promt of an option
        System.out.println("Enter \"1\" if you want to get the sum of the elements of the predefined array.");
        System.out.println("Enter \"2\" if you want to make \"even-odd\" transformation of predefined array weird shit way.");
        System.out.println("Enter \"3\" if you want to make \"even-odd\" transformation of predefined array weirdest shit way.");
        System.out.println("Enter \"4\" if you want to die.");

        keyInput = input.nextInt();

        // Calling a method depending on selected option
        switch (keyInput) {
            case 1:
                sumOfArrayElements();
                break;
            case 2:
                weirdEvenOddArrayTransformation();
                break;
            case 3:
                weirdestEvenOddArrayTransformation();
                break;
            case 4:
                System.exit(0);
                break;
            default:
                System.out.println("Invalid input.");
        }
    }
}