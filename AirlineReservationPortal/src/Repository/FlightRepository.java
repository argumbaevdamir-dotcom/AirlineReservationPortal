package Repository;

import Model.Flight;
import Model.FlightStatus;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FlightRepository {
    private DataPool<Flight> DataPool;

    public FlightRepository() {
        this.DataPool = new DataPool<>();
    }

    public void addFlight(Flight flight) {
        DataPool.add(flight);
    }

    public Flight getFlightById(int id) {
        return DataPool.getById(id);
    }


    public List<Flight> filterByDestination(String destination) {
        return DataPool.filter(flight ->
                flight.getArrivalCity().equalsIgnoreCase(destination));
    }


    public List<Flight> filterByStatus(FlightStatus status) {
        return DataPool.filter(flight -> flight.getStatus() == status);
    }


    public List<Flight> filterByDate(LocalDateTime date) {
        return DataPool.filter(flight ->
                flight.getDepartureTime().toLocalDate().equals(date.toLocalDate()));
    }


    public Flight searchByFlightNumber(String flightNumber) {
        return DataPool.search(flight ->
                flight.getFlightNumber().equalsIgnoreCase(flightNumber));
    }


    public List<Flight> sortByPrice() {
        return DataPool.getAll().stream()
                .sorted(Comparator.comparingDouble(Flight::getBasePrice))
                .collect(Collectors.toList());
    }


    public List<Flight> sortByDepartureTime() {
        return DataPool.getAll().stream()
                .sorted(Comparator.comparing(Flight::getDepartureTime))
                .collect(Collectors.toList());
    }


    public List<Flight> sortByAvailableSeatsDesc() {
        return DataPool.getAll().stream()
                .sorted((f1, f2) -> Integer.compare(f2.getAvailableSeats(),
                        f1.getAvailableSeats()))
                .collect(Collectors.toList());
    }


    public List<Flight> searchByPriceRange(double minPrice, double maxPrice) {
        return DataPool.filter(flight ->
                flight.getBasePrice() >= minPrice &&
                        flight.getBasePrice() <= maxPrice);
    }

    public List<Flight> getAllFlights() {
        return DataPool.getAll();
    }

    public int getFlightCount() {
        return DataPool.size();
    }
}
