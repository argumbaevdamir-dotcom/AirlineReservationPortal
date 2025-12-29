package Model;

public interface Bookable {
    boolean book(Passenger passenger);
    double getPrice();
    String getBookingDetails();
}

