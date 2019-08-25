import java.util.Scanner;  // Import the Scanner class

public class Calc {
    // Method for simple addition of two predefined numbers
    public static void SimpleSum() {
        // Variables definition
        Integer a=1;
        Integer b=2;
        Integer sum = a + b;

        // Output
        System.out.println("Your choice is just sum of 2 predefined ints.");
        System.out.println("First number is " + a + " and the second is " + b + ".");
        System.out.println("The sum is: " + sum);
    }
    // Method for a simple calc
    public static void SimpleCalc() {
        // Variables initialization
        Integer a;
        Integer b;
        Integer result;
        String operation;

        // Creation of a Scanner object
        Scanner calcInput = new Scanner(System.in);

        // Output
        System.out.println("Your choice is a simple calc.");
        System.out.println("It can only operate simple operations with 2 int numbers.");
        // Prompt for a required operation
        System.out.println("Enter operation (+, -, *. /):");
        operation = calcInput.nextLine();
        // Prompt for a first number
        System.out.println("Enter a first number:");
        a = calcInput.nextInt();
        // Prompt for a second number
        System.out.println("Enter a second number:");
        b = calcInput.nextInt();

        // Operation perform
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
    // Method to call boobs
    public static void Boobs() {
        // Variables initialization
        String answer;

        // Creation of a Scanner object
        Scanner boobsInput = new Scanner(System.in);

        // Prompt for an answer
        System.out.println("Your choice is ASCII boobs.");
        System.out.println("Would you give me \"A\" grade for the first task? (y/n)");
        answer = boobsInput.nextLine();

        // Processing of an answer
        switch (answer) {
            case "y":
                System.out.println("( . ) ( . )");
                break;
            case "n":
                System.out.println("No boobs for you!");
                break;
            default:
                System.out.println("Invalid input.");
        }
    }

    public static void main(String[] args)
    {
        // Variables initialization
        Integer keyInput;

        // Creation of a Scanner object
        Scanner input = new Scanner(System.in);

        // Promt of an option
        System.out.println("Enter \"1\" if you want just sum of 2 predefined ints.");
        System.out.println("Enter \"2\" if you want simple calc.");
        System.out.println("Enter \"3\" if you want ASCII boobs.");
        keyInput = input.nextInt();

        // Calling a method depending on selected option
        switch (keyInput) {
            case 1:
                SimpleSum();
                break;
            case 2:
                SimpleCalc();
                break;
            case 3:
                Boobs();
                break;
            default:
                System.out.println("Invalid input.");
        }
    }
}
