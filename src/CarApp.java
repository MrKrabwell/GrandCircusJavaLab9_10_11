/**
 * Class for CarApp, as described in Grand Circus Java (Jan 2017) Lab Number 9
 * Created by yosuk on 2/9/2017.
 */

import java.util.ArrayList;
import java.util.Scanner;

public class CarApp {

    static Scanner scnr = new Scanner(System.in);      // Scanner object for user input

    /****************************************************************
     * getValidInteger function to validate that it is an int value *
     ****************************************************************/
    private static int getValidInteger() {

        // This keeps looping until integer input is received.
        while (!scnr.hasNextInt()) {
            scnr.nextLine();         // clear the buffer
            System.out.print("Please enter an integer! ");
        }

        int integerNum = scnr.nextInt();
        scnr.nextLine();

        return integerNum;
    }


    /*************************************************************************
     * getValidInteger to and check for a range, user with getValidInteger() *
     *************************************************************************/
    private static int getValidInteger(int min) {

        int userInput = getValidInteger();

        while (userInput < min) {
            System.out.printf("Please enter a number greater than %d!\n");
            userInput = getValidInteger();
        }

        return userInput;
    }


    /*************************************************************************
     * getValidInteger to and check for a range, user with getValidInteger() *
     *************************************************************************/
    private static int getValidInteger(int min, int max) {

        int userInput = getValidInteger();

        while (userInput < min || userInput > max) {
            System.out.printf("Please enter a number within %d and %d!", min, max);
            userInput = getValidInteger();
        }

        return userInput;
    }

    /*************************************************************************
     * This method asks the user yes or no
     *************************************************************************/
    private static boolean askUserYesNo() {
        // Variable declarations
        String userInput = "";                  // User input string

        // Get user input
        userInput = scnr.nextLine();
        System.out.println("");

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

    /**
     * This is the main program
     * @param args
     */
    public static void main(String[] args) {
        // Variable declarations
        int functionChoice = 0;                         // Holds the function choice

        // Welcome message
        System.out.println("Welcome to the Grand Circus Motors admin console!\n");

        // Create an instance of the CarLot Object
        // TODO: Maybe the program can manage multiple CarLots, and can enter data for initial inventory
        CarLot carLot1 = new CarLot();

        // Run the program until user decides to quit
        while (true) {
            // Let user choose what function they want to make
            System.out.println("What would you like to do?");
            System.out.println("(1) Add cars to inventory");
            System.out.println("(2) Display the entire inventory");
            System.out.println("(3) Buy a car");
            System.out.print("Please enter your choice (1-3): " );
            functionChoice = getValidInteger(1,3);
            System.out.println();

            // Execute function
            switch (functionChoice) {
                case 1:
                    carLot1.addCarsToInventory();
                    break;
                case 2:
                    carLot1.printEntireInventory();
                    break;
                case 3:
                    carLot1.printEntireInventory();
                default:
                    break;
            }
            System.out.println();

            // Ask the user if they want to continue, if no, exit loop
            System.out.print("Would you like to continue? (y/n) ");
            if (!askUserYesNo()) {
                System.out.println();
                break;
            }
            System.out.println();
        }

        // Exit message
        System.out.println("Goodbye! Have a great day!");
        return;
    }
}
