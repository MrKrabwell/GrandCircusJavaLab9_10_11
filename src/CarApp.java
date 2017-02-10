/**
 * Class for CarApp, as described in Grand Circus Java (Jan 2017) Lab Number 9
 * Created by yosuk on 2/9/2017.
 */
import java.util.Scanner;

public class CarApp {

    static Scanner scnr = new Scanner(System.in);      // Scanner object for user input

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
            System.out.println("(4) View all cars of a specific make");
            System.out.println("(5) View all cars of a specific year");
            System.out.println("(6) View all cars of an entered price or less");
            System.out.println("(7) View only new cars");
            System.out.println("(8) View only used cars");
            System.out.println("(9) Replace a car or edit car info");
            System.out.println("(10) Find car based on index number");
            System.out.print("Please enter your choice (1-10): " );
            functionChoice = InputValidator.getValidInteger(1,10);
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
                    carLot1.buyCarInInventory();
                    break;
                case 4:
                    carLot1.viewSpecificMakeInInventory(CarLot.getUserMake(-1));  // negative for generic prompt
                    break;
                case 5:
                    carLot1.viewSpecificYearInInventory(CarLot.getUserYear(-1));  // negative for generic prompt
                    break;
                case 6:
                    carLot1.viewPriceOrLessInInventory(CarLot.getUserPrice(-1));  // negative for generic prompt
                    break;
                case 7:
                    carLot1.viewNewCarsInInventory();
                    break;
                case 8:
                    carLot1.viewUsedCarsInInventory();
                    break;
                case 9:
                    System.out.print("Enter car index number: ");
                    carLot1.editCarInfoInInventory
                            (InputValidator.getValidInteger(1,carLot1.getNumCarsInInventory())-1);
                    break;
                case 10:
                    // TODO: need to finish
                    System.out.print("Enter car index number: ");
                    carLot1.printSingleCar(InputValidator.getValidInteger(0)-1);
                    break;
                default:
                    break;
            }
            System.out.println();

            // Ask the user if they want to continue, if no, exit loop
            System.out.print("Would you like to continue? (y/n) ");
            if (!InputValidator.askUserYesNo()) {
                break;
            }
            System.out.println();
        }

        // Exit message
        System.out.println("Goodbye! Have a great day!");
        return;
    }
}
