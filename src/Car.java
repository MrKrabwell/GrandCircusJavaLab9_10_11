/**
 * Class for Car, as described in Grand Circus Java (Jan 2017) Lab Number 9
 * Created by yosuk on 2/9/2017.
 */

import java.util.Formatter;

public class Car {
    // Data members for class
    private String make;
    private String model;
    private int year;
    private double price;
    private char charToSplit = '&';     // This is used by the application main program to use to parse the strings

    // No-argument constructor that sets data members to default values
    public Car() {
        make = "";
        model = "";
        year = 0;
        price = 0.00;
    }

    // Constructor with four arguments matching the order of members
    public Car(String make, String model, int year, double price) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.price = price;
    }

    // Getters for all data members
    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public double getPrice() {
        return price;
    }

    public char getCharToSplit() { return charToSplit; }

    // Setters for all data members
    public void setMake(String make) {
        this.make = make;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Overriden toString() method to return a labeled and formatted string of the data members
     * @return string of labeled and formatted member variables
     */
    @Override
    public String toString() {
        int columnWidth = 14;
        return String.format("%s%c%s%c%d%c$%.2f",
                make, charToSplit, model, charToSplit, year, charToSplit, price);
    }
}
