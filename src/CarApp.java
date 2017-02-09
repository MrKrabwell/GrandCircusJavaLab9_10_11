/**
 * Class for CarApp, as described in Grand Circus Java (Jan 2017) Lab Number 9
 * Created by yosuk on 2/9/2017.
 */

import java.util.ArrayList;
import java.util.Scanner;

public class CarApp {

    // Static members used often
    static Scanner scnr = new Scanner(System.in);          // Scanner object for user input
    static ArrayList<Car> carList = new ArrayList<>();     // Array List to hold the Car objects
    static int numLabelColumnWidth = 4;                    // Column width for the number labels
    static int itemColumnWidth = 17;                       // Column width for displaying the items


    /****************************************************************
     * getValidInteger function to validate that it is an int value *
     ****************************************************************/
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


    /*************************************************************************
     * getValidInteger to and check for a range, user with getValidInteger() *
     *************************************************************************/
    public static int getValidInteger(int min) {

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
    public static int getValidInteger(int min, int max) {

        int userInput = getValidInteger();

        while (userInput < min || userInput > max) {
            System.out.printf("Please enter a number within %d and %d!", min, max);
            userInput = getValidInteger();
        }

        return userInput;
    }


    /****************************************************************
     * getValidDouble function to validate that it is an double value *
     ****************************************************************/
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


    /*************************************************************************
     * getValidDouble to and check for a range, user with getValidDouble() *
     *************************************************************************/
    public static double getValidDouble(double min) {

        double userInput = getValidDouble();

        while (userInput < min) {
            System.out.printf("Please enter a number greater than %d!", min);
            userInput = getValidDouble();
        }

        return userInput;
    }


    /**
     * This method gets user input for a name string
     * @return
     */
    public static String getName() {
        // Variable declarations
        String name = "";                   // String object to hold name

        // Prompt user to enter name
        name = scnr.nextLine();

        // Return the name
        return name;
    }


    /*************************************************************************
     * This method asks the user yes or no
     *************************************************************************/
    public static boolean askUserYesNo() {
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
            System.out.println("");
        }

        // Return true if user says yes, and false if user says no
        if (userInput.equalsIgnoreCase("y") || userInput.equalsIgnoreCase("yes")) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * This method asks for the make of the car
     * @param index This is the index of the car
     * @return String of the user input for Make
     */
    public static String getUserMake(int index) {
        // Prompt user to enter Make
        System.out.printf("Enter Car #%d Make: ", index);
        return getName();
    }


    /**
     * This method asks for the model of the car
     * @param index This is the index of the car
     * @return String of the user input for Model
     */
    public static String getUserModel(int index) {
        // Prompt user to enter Make
        System.out.printf("Enter Car #%d Model: ", index);
        return getName();
    }


    /**
     * This method asks for the year of the car
     * @param index This is the index of the car
     * @return int of the user input for year, >0
     */
    public static int getUserYear(int index) {
        // Prompt user to enter Year
        System.out.printf("Enter Car #%d Year: ", index);
        return getValidInteger(1);
    }


    /**
     * This method asks for the price of the car
     * @param index This is the index of the car
     * @return double of the user input for price, >=0
     */
    public static double getUserPrice(int index) {
        // Prompt user to enter Price
        System.out.printf("Enter Car #%d Price: ", index);
        return getValidDouble(0);
    }


    /**
     * This method will add cars to the inventory
     */
    public static void addCarsToInventory() {
        // Variable declarations
        int numCars = 0;                                // Number of cars to input

        // Ask user how many cars they want to enter, greater than 0
        System.out.print("How many cars are you entering?: ");
        numCars = getValidInteger(1);

        // Ask user to enter the information for each car, and add to carList
        for (int i = 1; i <= numCars; i++) {
            carList.add(new Car(getUserMake(i),getUserModel(i),getUserYear(i),getUserPrice(i)));
        }

        // Divider
        System.out.println("...");

        // Report the current inventory
        printEntireInventory();
        return;
    }

    /**
     * This method will print the entire inventory
     */
    public static void printEntireInventory() {

        // Report the current inventory
        System.out.println("Current Inventory: ");
        // Heading
        System.out.printf("%-" + numLabelColumnWidth+"s" +
                        "%-"+itemColumnWidth+"s" +
                        "%-"+itemColumnWidth+"s" +
                        "%-"+itemColumnWidth+"s" +
                        "%-"+itemColumnWidth+"s" +
                        "%-"+itemColumnWidth+"s\n",
                " ", "Make", "Model", "Year", "Price", "Mileage");
        // This while loop will print numLabel width + (itemColumn Width * 5) worth of '='
        int num = numLabelColumnWidth;
        while(num > 0) {
            System.out.print("=");
            num--;
        }
        num = itemColumnWidth * 5;
        while(num > 0) {
            System.out.print("=");
            num--;
        }
        System.out.println();
        
        // Print each element, i.e. row
        int index = 0;   // Index to print the car number
        for ( Car c : carList) {
            // Print the item number
            System.out.printf("%2d. ", index+1);
            // This for loop prints each component of the Car object with a certain width
            // It uses the character to split each item.
            // This is really confusing...  Maybe it should be changed
            for (int i = 0; i < c.toString().split(Character.toString(carList.get(0).getCharToSplit())).length; i++) {
                System.out.printf("%-"+itemColumnWidth+"s",
                        c.toString().split(Character.toString(carList.get(0).getCharToSplit()))[i]);
            }
            System.out.println();
            index++;
        }
        return;
    }

    /**
     * This method will allow the user to buy a car
     */
    public static void buyCarInInventory() {
        // Variable declarations
        int carIndex = 0;               // Holds the user input for index of car to buy

        // Show the entire inventory first
        printEntireInventory();

        // Show option to quit, +1 because it needs to be one more than size of carList
        System.out.printf("%2d. Quit\n\n", carList.size()+1);

        // Prompt user which car they want to buy
        System.out.print("Which car would you like (Enter number)? ");
        carIndex = getValidInteger(1,carList.size()+1) - 1;    // -1 because what user enters is +1 of index

        // If user selected the "Quit" car index, exit the method
        if (carIndex == carList.size()) {
            return;
        }

        // Show user what they selected
        // Again, very busy, this may have to be cleaned up.
        System.out.println("You chose: ");
        for (int i = 0; i < carList.get(carIndex).toString().
                split(Character.toString(carList.get(0).getCharToSplit())).length; i++) {
            System.out.printf("%-"+itemColumnWidth+"s", carList.get(carIndex).toString().
                    split(Character.toString(carList.get(0).getCharToSplit()))[i]);
        }
        System.out.println();

        // Prompt user if they want to buy the car
        System.out.print("Would you like to buy this car? (y/n) ");

        // If user says yes, respond and remove from the inventory
        if (askUserYesNo()) {
            System.out.println("Excellent!  Our finance department will be in touch shortly.");
            carList.remove(carIndex);
        }
        else {
            System.out.println("That's too bad.");
        }


        return;
    }


    /**
     * This is the main program
     * @param args
     */
    public static void main(String[] args) {
        // Variable declarations
        int functionChoice = 0;                         // Holds the function choice

        // TODO: this is for testing so I don't have to enter make/model/etc for every test
        carList.add(new Car("Ford", "Mustang", 2000, 9870.99));
        carList.add(new Car("Chevrolet", "Camaro", 1998, 5800.90));
        carList.add(new Car("Toyota", "Tundra", 2010, 18240.98));
        carList.add(new Car("Subaru", "WRX", 2014, 22810.24));
        carList.add(new Car("Ford", "Edge", 2016, 30120.00));
        carList.add(new Car("Ford", "Mustang", 2014, 33870.25));
        carList.add(new UsedCar("Fiat", "500", 2010, 12750.79, 83243));


        // Welcome message
        System.out.println("Welcome to the Grand Circus Motors admin console!\n");

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
                    addCarsToInventory();
                    break;
                case 2:
                    printEntireInventory();
                    break;
                case 3:
                    buyCarInInventory();
                default:
                    break;
            }
            System.out.println();

            // Ask the user if they want to continue, if no, exit loop
            System.out.print("Would you like to continue? (y/n) ");
            if (!askUserYesNo()) {
                break;
            }
        }

        // Exit message
        System.out.println("Goodbye! Have a great day!");
        return;
    }
}
