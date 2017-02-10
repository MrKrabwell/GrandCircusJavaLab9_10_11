/**
 * Class for UsedCar, as described in Grand Circus Java (Jan 2017) Lab Number 9
 * Created by yosuk on 2/9/2017.
 */

public class UsedCar extends Car {
    // Data member for class
    private double mileage;

    /**
     * Constructor: Takes five aruments (same order as constructor from last lab with the mileage last
     * @param make
     * @param model
     * @param year
     * @param price
     * @param mileage
     */
    public UsedCar(String make, String model, int year, double price, double mileage) {
        super(make, model, year, price);
        this.mileage = mileage;
    }

    // Setter
    public void setMileage(double mileage) {
        this.mileage = mileage;
    }

    /**
     * Overriden toString() method to return a labeled and formatted string of the data members
     * mileage is the new data member available in this subclass
     * @return string of labeled and formatted member variables
     */
    @Override
    public String toString() {
        int columnWidth = 14;

        return String.format("%s%c%s%c%d%c$%.2f (Used) %c%.1f miles",
                super.getMake(), super.getCharToSplit(),
                super.getModel(), super.getCharToSplit(),
                super.getYear(), super.getCharToSplit(),
                super.getPrice(), super.getCharToSplit(),
                mileage);
    }
}
