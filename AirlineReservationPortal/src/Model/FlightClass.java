package Model;

public enum FlightClass {
    ECONOMY(1.0),
    BUSINESS(2.5),
    FIRST(5.0);

    private final double priceMultiplier;

    FlightClass(double priceMultiplier) {
        this.priceMultiplier = priceMultiplier;
    }

    public double getPriceMultiplier() {
        return priceMultiplier;
    }
}