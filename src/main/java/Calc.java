import java.util.Scanner;  // Import the Scanner class

public class Calc {

    public static void SimpleSum() {
        Integer a=1;
        Integer b=2;
        Integer sum = a + b;
        System.out.println("Your choice is just sum of 2 predefined ints.");
        System.out.println("First number is " + a + " and the second is " + b + ".");
        System.out.println("The sum is: " + sum);
    }

    public static void SimpleCalc() {
        Integer a;
        Integer b;
        Integer result;
        String operation;

        Scanner calcInput = new Scanner(System.in);  // Create a Scanner object

        System.out.println("Your choice is simple calc.");
        System.out.println("It can only operate simple operations with 2 int numbers.");
        System.out.println("Enter operation (+, -, *. /):");
        operation = calcInput.nextLine();
        System.out.println("Enter the first number:");
        a = calcInput.nextInt();
        System.out.println("Enter the second number:");
        b = calcInput.nextInt();

        switch (operation) {
            case "+":
                result = Math.addExact(a, b);
                System.out.println("Result is " + result);
                break;
            case "-":
                result = Math.subtractExact(a, b);
                System.out.println("Result is " + result);
                break;
            case "*":
                result = Math.multiplyExact(a, b);
                System.out.println("Result is " + result);
                break;
            case "/":
                result = Math.floorDiv(a, b);
                System.out.println("Result is " + result);
                break;
            default:
                System.out.println("Invalid operation.");
        }
    }

    public static void main(String[] args)
    {
        Integer keyInput;


        Scanner input = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter \"1\" if you want just sum of 2 predefined ints.");
        System.out.println("Enter \"2\" if you want simple calc.");
        System.out.println("Enter \"3\" if you want ASCII boobs.");

        keyInput = input.nextInt();

        switch (keyInput) {
            case 1:
                SimpleSum();
                break;
            case 2:
                SimpleCalc();
                break;
            default:
                System.out.println("Invalid input.");
        }
    }
}
