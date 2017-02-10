import jdk.internal.util.xml.impl.Input;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Class for CarLot, as described in Grand Circus Java (Jan 2017) Lab Number 11
 * Created by yosuk on 2/9/2017.
 */
public class CarLot {
    // Static members used often
    private Scanner scnr = new Scanner(System.in);          // Scanner object for user input
    private ArrayList<Car> carList = new ArrayList<>();     // Array List to hold the Car objects
    private int numLabelColumnWidth = 4;                    // Column width for the number labels
    private int itemColumnWidth = 19;                       // Column width for displaying the items
    private int numCarsInInventory;                         // Number of cars in inventory


    /**
     * No argument constructor for this class, it initializes with an initial inventory
     */
    public CarLot() {
        // TODO: this is for testing, i.e. initial inventory,
        // TODO: lots should have to be populated when an instance is created
        carList.add(new Car("Ford", "Mustang", 2000, 9870.99));
        carList.add(new Car("Chevrolet", "Camaro", 1998, 5800.90));
        carList.add(new UsedCar("BMW", "M3", 2008, 18298.29, 68243.79));
        carList.add(new Car("Toyota", "Tundra", 2010, 18240.98));
        carList.add(new Car("Subaru", "WRX", 2014, 22810.24));
        carList.add(new UsedCar("Nissan", "Altima", 2007, 4879.29, 99342.79));
        carList.add(new Car("Ford", "Edge", 2016, 30120.00));
        carList.add(new Car("Ford", "Mustang", 2014, 33870.25));
        carList.add(new UsedCar("Fiat", "500", 2010, 12750.79, 83243));

        numCarsInInventory = carList.size();
    }

    // Getters
    public int getNumCarsInInventory() {
        return numCarsInInventory;
    }


    /**
     * This method asks for the make of the car
     * @param index This is the index of the car
     * @return String of the user input for Make
     */
    public static String getUserMake(int index) {
        // Prompt user to enter Make, if index < 0, generic "getMake"
        if (index < 0) {
            System.out.printf("Enter Car Make: ");
        }
        else {
            System.out.printf("Enter Car #%d Make: ", index);
        }
        return InputValidator.getString();
    }


    /**
     * This method asks for the model of the car
     * @param index This is the index of the car
     * @return String of the user input for Model
     */
    public static String getUserModel(int index) {
        // Prompt user to enter Model, if index < 0, generic "getMake"
        if (index < 0) {
            System.out.printf("Enter Car Make: ");
        }
        else {
            System.out.printf("Enter Car #%d Make: ", index);
        }
        return InputValidator.getString();
    }


    /**
     * This method asks for the year of the car
     * @param index This is the index of the car
     * @return int of the user input for year, >0
     */
    public static int getUserYear(int index) {
        // Prompt user to enter Year, if index < 0, generic getYear
        if (index < 0) {
            System.out.printf("Enter Car Year: ");
        }
        else {
            System.out.printf("Enter Car #%d Year: ", index);
        }
        return InputValidator.getValidInteger(1);
    }


    /**
     * This method asks for the price of the car
     * @param index This is the index of the car
     * @return double of the user input for price, >=0
     */
    public static double getUserPrice(int index) {
        // Prompt user to enter Price, if index < 0, then generic getPrice
        if (index < 0) {
            System.out.printf("Enter Car Price: $");
        }
        else {
            System.out.printf("Enter Car #%d Price: $", index);
        }
        return InputValidator.getValidDouble(0);
    }


    /**
     * This method asks for the mileage of the car
     * @param index This is the index of the car
     * @return double of user input for mileage, >=0
     */
    private double getUserMileage(int index) {
        // Prompt user to enter Price, if index < 0, then generic getPrice
        if (index < 0) {
            System.out.printf("Enter Car Milesage: ");
        }
        else {
            System.out.printf("Enter Car #%d Price: ", index);
        }
        return InputValidator.getValidDouble(0);
    }

    /**
     * This method will print the heading for the inventory
     */
    private void printInventoryHeading() {
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
        return;
    }

    /**
     * This method will print a single line item, with the index number as the heading
     * @param index this is the index in the carList
     */
    public void printSingleCar(int index) {
        // Print the item number
        System.out.printf("%2d. ", index+1);
        // This for loop prints each component of the Car object with a certain width
        // It uses the character to split each item.
        // This is really confusing...  Maybe it should be changed
        for (int i = 0; i < carList.get(index).toString().split(Character.toString(carList.get(0).getCharToSplit())).length; i++) {
            System.out.printf("%-"+itemColumnWidth+"s",
                    carList.get(index).toString().split(Character.toString(carList.get(0).getCharToSplit()))[i]);
        }
        System.out.println();

        return;
    }


    /**
     * This method will add cars to the inventory
     */
    public void addCarsToInventory() {
        // Variable declarations
        int numCars = 0;                                // Number of cars to input

        // Ask user how many cars they want to enter, greater than 0
        System.out.print("How many cars are you entering?: ");
        numCars = InputValidator.getValidInteger(1);
        System.out.println();

        // Ask user to enter the information for each car, and add to carList
        for (int i = 1; i <= numCars; i++) {
            // Ask if new or used?
            System.out.printf("Is car #%d an used car? (y/n) ", i);
            if (InputValidator.askUserYesNo()) {
                carList.add(new UsedCar(getUserMake(i),getUserModel(i),getUserYear(i),getUserPrice(i),
                        getUserMileage(i)));
                ++numCarsInInventory;
                System.out.println();
            }
            else {
                carList.add(new Car(getUserMake(i),getUserModel(i),getUserYear(i),getUserPrice(i)));
                ++numCarsInInventory;
                System.out.println();
            }
        }

        // Report the current inventory
        printEntireInventory();
        return;
    }


    /**
     * This method will print the entire inventory
     */
    public void printEntireInventory() {

        // Report the current inventory
        System.out.println("Current Inventory: ");

        // Print the heading
        printInventoryHeading();

        // Make sure there is at least one car
        if (getNumCarsInInventory() < 1) {
            System.out.println("No car exists in inventory!");
            return;
        }

        // Print each element, i.e. row
        for (int i = 0; i < carList.size(); i++) {
            printSingleCar(i);
        }

        return;
    }


    /**
     * This method will allow the user to buy a car
     */
    public void buyCarInInventory() {
        // Variable declarations
        int carIndex = 0;               // Holds the user input for index of car to buy

        // Show the entire inventory first
        printEntireInventory();

        // Show option to quit, +1 because it needs to be one more than size of carList
        System.out.printf("%2d. Quit\n\n", carList.size()+1);

        // Prompt user which car they want to buy
        System.out.print("Which car would you like (Enter number)? ");
        carIndex = InputValidator.getValidInteger(1,carList.size()+1) - 1;    // -1 because user enters +1 of index

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
        if (InputValidator.askUserYesNo()) {
            System.out.println("Excellent!  Our finance department will be in touch shortly.");
            carList.remove(carIndex);
            --numCarsInInventory;
        }
        else {
            System.out.println("That's too bad.");
        }

        return;
    }


    /**
     * This method will print all the cars with a certain make
     * @param make String that is the name of make to search for, case-insensitive
     */
    public void viewSpecificMakeInInventory(String make) {
        // Variable declaration
        boolean foundMake = false;      // Boolean to determine whether a year was found

        // Print heading
        printInventoryHeading();

        // Make sure there is at least one car
        if (getNumCarsInInventory() < 1) {
            System.out.println("No car exists in inventory!");
            return;
        }

        // Search through carList
        // Print each element, i.e. row
        for (int i = 0; i < carList.size(); i++) {
            // If the object's make matches the input, print line
            if (carList.get(i).getMake().equalsIgnoreCase(make)) {
                printSingleCar(i);
                foundMake = true;
            }
        }

        // If no car with the specific make was found, tell user nothing was found
        if (!foundMake) {
            System.out.printf("No %s car available!\n", make);
        }

        return;
    }


    /**
     * This method will print all the cars with a certain year
     * @param year integer that is the year to search for
     */
    public void viewSpecificYearInInventory(int year) {
        // Variable declaration
        boolean foundYear = false;      // Boolean to determine whether a year was found

        // Print heading
        printInventoryHeading();

        // Make sure there is at least one car
        if (getNumCarsInInventory() < 1) {
            System.out.println("No car exists in inventory!");
            return;
        }

        // Search through carList
        // Print each element, i.e. row
        for (int i = 0; i < carList.size(); i++) {
            // If the object's make matches the input, print line
            if (carList.get(i).getYear() == year) {
                printSingleCar(i);
                foundYear = true;
            }
        }

        // If no car with the specific year was found, tell user nothing was found
        if (!foundYear) {
            System.out.printf("No %d car available!\n", year);
        }

        return;
    }


    /**
     * This method will print all the cars with a certain price or less
     * @param price double that is the price to search for
     */
    public void viewPriceOrLessInInventory(double price) {
        // Variable declaration
        boolean foundPrice = false;      // Boolean to determine whether a price or lower was found

        // Print heading
        printInventoryHeading();

        // Make sure there is at least one car
        if (getNumCarsInInventory() < 1) {
            System.out.println("No car exists in inventory!");
            return;
        }

        // Search through carList
        // Print each element, i.e. row
        for (int i = 0; i < carList.size(); i++) {
            // If the object's make matches the input, print line
            if (carList.get(i).getPrice() <= price) {
                printSingleCar(i);
                foundPrice = true;
            }
        }

        // If no car with the specific year was found, tell user nothing was found
        if (!foundPrice) {
            System.out.printf("No car that is less than $%.2f available!\n", price);
        }

        return;
    }


    /**
     * This method will print all new cars
     */
    public void viewNewCarsInInventory() {
        // Variable declaration
        boolean foundNew = false;      // Boolean to determine whether a new car was found

        // Print heading
        printInventoryHeading();

        // Make sure there is at least one car
        if (getNumCarsInInventory() < 1) {
            System.out.println("No car exists in inventory!");
            return;
        }

        // Search through carList
        // Print each element, i.e. row
        for (int i = 0; i < carList.size(); i++) {
            // If the object's class is the Car class, print....  Why can't you use "intanceof"?????
            if (carList.get(i).getClass().toString().equals(Car.class.toString())) {
                printSingleCar(i);
                foundNew = true;
            }
        }

        // If no new car was found, tell user nothing was found
        if (!foundNew) {
            System.out.printf("No new cars available!\n");
        }

        return;
    }


    /**
     * This method will print all used cars
     */
    public void viewUsedCarsInInventory() {
        // Variable declaration
        boolean foundUsed = false;      // Boolean to determine whether a used car was found

        // Print heading
        printInventoryHeading();

        // Search through carList
        // Print each element, i.e. row
        for (int i = 0; i < carList.size(); i++) {
            // If the object's class is the UsedCar class, print
            if (carList.get(i).getClass().toString().equals(UsedCar.class.toString())) {
                printSingleCar(i);
                foundUsed = true;
            }
        }

        // If no new car was found, tell user nothing was found
        if (!foundUsed) {
            System.out.printf("No used cars available!\n");
        }

        return;
    }


    public void editCarInfoInInventory(int index) {

        // Make sure there is at least one car in inventory
        if (getNumCarsInInventory() < 1) {
            System.out.println("No car exists in inventory!");
            return;
        }

        // Show user selection
        printSingleCar(index);

        // Confirm whether they want to really edit
        System.out.print("Do you want to edit this car? ");
        if (!InputValidator.askUserYesNo()) {
            return;
        }

        // Select what you want to edit
        System.out.println("What do you want to edit? ");
        System.out.println("(1) All info");
        System.out.println("(2) Make/Model");
        System.out.println("(3) Model");
        System.out.println("(4) Year");
        System.out.println("(5) Price");
        System.out.println("(6) Mileage");
        System.out.print("Please select (1-6): ");

        switch (InputValidator.getValidInteger(1,6)) {
            case 1:
                carList.get(index).setMake(CarLot.getUserMake(-1));
                carList.get(index).setModel(CarLot.getUserModel(-1));
                carList.get(index).setYear(CarLot.getUserYear(-1));
                carList.get(index).setPrice(CarLot.getUserPrice(-1));
                if (carList.get(index).getClass().toString().equals(UsedCar.class.toString())) {
                    ((UsedCar)carList.get(index)).setMileage(getUserMileage(-1));
                }
                break;
            case 2:
                carList.get(index).setMake(CarLot.getUserMake(-1));
            case 3:
                carList.get(index).setModel(CarLot.getUserModel(-1));
                break;
            case 4:
                carList.get(index).setYear(CarLot.getUserYear(-1));
                break;
            case 5:
                carList.get(index).setPrice(CarLot.getUserPrice(-1));
                break;
            case 6:
                if (carList.get(index).getClass().toString().equals(UsedCar.class.toString())) {
                    ((UsedCar)carList.get(index)).setMileage(getUserMileage(-1));
                }
                else {
                    System.out.println("You cannot edit mileage on a new car.");
                }
                break;
            default:
                break;
        }

        // Print to confirm to user
        printSingleCar(index);

        return;

    }


}
