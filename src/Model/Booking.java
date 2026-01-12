package Model;

import java.time.LocalDateTime;
import java.util.Objects;

public class Booking extends AbstractEntity implements Bookable {
    private Passenger passenger;
    private Flight flight;
    private FlightClass flightClass;
    private LocalDateTime bookingTime;
    private String seatNumber;
    private double finalPrice;

    public Booking(int id, Passenger passenger, Flight flight,
                   FlightClass flightClass, String seatNumber) {
        super(id);
        this.passenger = passenger;
        this.flight = flight;
        this.flightClass = flightClass;
        this.seatNumber = seatNumber;
        this.bookingTime = LocalDateTime.now();
        this.finalPrice = flight.calculatePrice(flightClass);
        validate();
    }

    @Override
    public void validate() {
        if (passenger == null || flight == null || flightClass == null) {
            throw new IllegalArgumentException("Booking details cannot be null");
        }
        if (seatNumber == null || seatNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("Seat number cannot be empty");
        }
    }

    @Override
    public boolean book(Passenger passenger) {
        if (flight.bookSeat()) {
            passenger.addLoyaltyPoints((int)(finalPrice / 10));
            return true;
        }
        return false;
    }

    @Override
    public double getPrice() {
        return finalPrice;
    }

    @Override
    public String getBookingDetails() {
        return "Booking #" + getId() +
                " - Flight: " + flight.getFlightNumber() +
                " - Passenger: " + passenger.getName() +
                " - Class: " + flightClass +
                " - Price: $" + finalPrice;
    }


    public Passenger getPassenger() { return passenger; }
    public Flight getFlight() { return flight; }
    public FlightClass getFlightClass() { return flightClass; }
    public LocalDateTime getBookingTime() { return bookingTime; }
    public String getSeatNumber() { return seatNumber; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Booking booking = (Booking) o;
        return Double.compare(finalPrice, booking.finalPrice) == 0 &&
                Objects.equals(passenger, booking.passenger) &&
                Objects.equals(flight, booking.flight) &&
                flightClass == booking.flightClass &&
                Objects.equals(bookingTime, booking.bookingTime) &&
                Objects.equals(seatNumber, booking.seatNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), passenger, flight, flightClass,
                bookingTime, seatNumber, finalPrice);
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + getId() +
                ", passenger=" + passenger.getName() +
                ", flight=" + flight.getFlightNumber() +
                ", flightClass=" + flightClass +
                ", bookingTime=" + bookingTime +
                ", seatNumber='" + seatNumber + '\'' +
                ", finalPrice=" + finalPrice +
                '}';
    }
}

