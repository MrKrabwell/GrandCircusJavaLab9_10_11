import java.util.Scanner;

/**
 * Class for taking in user input, and validating if necessary
 * Created by yosuk on 2/10/2017.
 */
public class InputValidator {
    // Static members used often
    private static Scanner scnr = new Scanner(System.in);          // Scanner object for user input

    /**
     * This method will take user input and validate whether it is an integer input
     * @return int of user input
     */
    public static int getValidInteger() {

        // This keeps looping until integer input is received.
        while (!scnr.hasNextInt()) {
            scnr.nextLine();         // clear the buffer
            System.out.print("Please enter an integer! ");
        }

        int integerNum = scnr.nextInt();
        scnr.nextLine();

        return integerNum;
    }


    /**
     * This method will take user input and validate whether it is at least input min
     * @param min minimum integer that input needs to be
     * @return int of user input
     */
    public static int getValidInteger(int min) {

        int userInput = getValidInteger();

        while (userInput < min) {
            System.out.printf("Please enter a number greater than %d!\n", min);
            userInput = getValidInteger();
        }

        return userInput;
    }


    /**
     * This method will take user input and validate whether it is at least input min and less than or equal to max
     * @param min minimum integer that input can be
     * @param max maximum integer that input can be
     * @return int of user input
     */
    public static int getValidInteger(int min, int max) {

        int userInput = getValidInteger();

        while (userInput < min || userInput > max) {
            System.out.printf("Please enter a number within %d and %d!", min, max);
            userInput = getValidInteger();
        }

        return userInput;
    }


    /**
     * This method will take user input and validate whether it is an double input
     * @return double of user input
     */
    public static double getValidDouble() {

        // This keeps looping until double input is received.
        while (!scnr.hasNextDouble()) {
            scnr.nextLine();         // clear the buffer
            System.out.print("Please enter an value! ");
        }

        double doubleNum = scnr.nextDouble();
        scnr.nextLine();

        return doubleNum;
    }


    /**
     * This method will take user input and validate whether it is at least double min
     * @param min minimum double that input needs to be
     * @return double of user input
     */
    public static double getValidDouble(double min) {

        double userInput = getValidDouble();

        while (userInput < min) {
            System.out.printf("Please enter a number greater than %d!", min);
            userInput = getValidDouble();
        }

        return userInput;
    }


    /**
     * This method gets user input a string
     * @return user string
     */
    public static String getString() {
        // Variable declarations
        String name = "";                   // String object to hold name

        // Prompt user to enter name
        name = scnr.nextLine();

        // Return the name
        return name;
    }


    /**
     * This method takes user input and validates whether yes/y/no/n (case insensitive) was received.
     * @return true for yes and false for no
     */
    public static boolean askUserYesNo() {
        // Variable declarations
        String userInput = "";                  // User input string

        // Get user input
        userInput = scnr.nextLine();

        // Validate whether user input is ok, and continue asking until right
        while (!userInput.equalsIgnoreCase("y") &&
                !userInput.equalsIgnoreCase("yes") &&
                !userInput.equalsIgnoreCase("n") &&
                !userInput.equalsIgnoreCase("no")) {
            System.out.print("That is not a valid input.  Please try again. (y/n): ");
            userInput = scnr.nextLine();
        }

        // Return true if user says yes, and false if user says no
        if (userInput.equalsIgnoreCase("y") || userInput.equalsIgnoreCase("yes")) {
            return true;
        } else {
            return false;
        }
    }

}
