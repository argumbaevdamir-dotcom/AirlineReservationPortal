package Model;

import java.time.LocalDateTime;
import java.util.Objects;

public class Flight extends AbstractEntity implements Comparable<Flight> {
    private String flightNumber;
    private String departureCity;
    private String arrivalCity;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private double basePrice;
    private int availableSeats;
    private FlightStatus status;

    public Flight(int id, String flightNumber, String departureCity,
                  String arrivalCity, LocalDateTime departureTime,
                  LocalDateTime arrivalTime, double basePrice, int availableSeats) {
        super(id);
        this.flightNumber = flightNumber;
        this.departureCity = departureCity;
        this.arrivalCity = arrivalCity;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.basePrice = basePrice;
        this.availableSeats = availableSeats;
        this.status = FlightStatus.SCHEDULED;
        validate();
    }

    @Override
    public void validate() {
        if (flightNumber == null || flightNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("Flight number cannot be empty");
        }
        if (departureCity == null || arrivalCity == null) {
            throw new IllegalArgumentException("Cities cannot be null");
        }
        if (departureTime == null || arrivalTime == null ||
                departureTime.isAfter(arrivalTime)) {
            throw new IllegalArgumentException("Invalid flight times");
        }
        if (basePrice <= 0) {
            throw new IllegalArgumentException("Base price must be positive");
        }
        if (availableSeats < 0) {
            throw new IllegalArgumentException("Available seats cannot be negative");
        }
    }

    public double calculatePrice(FlightClass flightClass) {
        return basePrice * flightClass.getPriceMultiplier();
    }

    public boolean bookSeat() {
        if (availableSeats > 0) {
            availableSeats--;
            return true;
        }
        return false;
    }

    public String getFlightNumber() { return flightNumber; }
    public String getDepartureCity() { return departureCity; }
    public String getArrivalCity() { return arrivalCity; }
    public LocalDateTime getDepartureTime() { return departureTime; }
    public LocalDateTime getArrivalTime() { return arrivalTime; }
    public double getBasePrice() { return basePrice; }
    public int getAvailableSeats() { return availableSeats; }
    public FlightStatus getStatus() { return status; }

    public void setStatus(FlightStatus status) { this.status = status; }
    public void setFlightNumber(String flightNumber) { this.flightNumber = flightNumber; }
    public void setBasePrice(double basePrice) { this.basePrice = basePrice; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Flight flight = (Flight) o;
        return Double.compare(basePrice, flight.basePrice) == 0 &&
                availableSeats == flight.availableSeats &&
                Objects.equals(flightNumber, flight.flightNumber) &&
                Objects.equals(departureCity, flight.departureCity) &&
                Objects.equals(arrivalCity, flight.arrivalCity) &&
                Objects.equals(departureTime, flight.departureTime) &&
                Objects.equals(arrivalTime, flight.arrivalTime) &&
                status == flight.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), flightNumber, departureCity,
                arrivalCity, departureTime, arrivalTime,
                basePrice, availableSeats, status);
    }

    @Override
    public int compareTo(Flight other) {
        return this.departureTime.compareTo(other.departureTime);
    }

    @Override
    public String toString() {
        return "Flight{" +
                "id=" + getId() +
                ", flightNumber='" + flightNumber + '\'' +
                ", departureCity='" + departureCity + '\'' +
                ", arrivalCity='" + arrivalCity + '\'' +
                ", departureTime=" + departureTime +
                ", arrivalTime=" + arrivalTime +
                ", basePrice=" + basePrice +
                ", availableSeats=" + availableSeats +
                ", status=" + status +
                '}';
    }
}

