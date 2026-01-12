package Main;

import Model.*;
import Repository.FlightRepository;
import Repository.BookingRepository;
import java.time.LocalDateTime;

public class MainApp {
    public static void main(String[] args) {
        System.out.println("=== Airline Reservation Portal ===\n");

        // Создаем пассажиров
        Passenger passenger1 = new Passenger(1, "Kasym Alibek", "Kasym@email.com", "AB1234567");
        Passenger passenger2 = new Passenger(2, "Arysova Dana", "Dana@email.com", "CD9876543");

        // Создаем админа
        Admin admin = new Admin(100, "Admin User", "admin@airline.com", "Operations");

        // Демонстрация полиморфизма
        User[] users = {passenger1, passenger2, admin};
        System.out.println("=== Users (Polymorphism) ===");
        for (User user : users) {
            System.out.println(user);
        }
        System.out.println();

        // Создаем репозиторий рейсов
        FlightRepository flightRepository = new FlightRepository();

        // Добавляем рейсы
        Flight flight1 = new Flight(101, "AA123", "Aktobe", "London",
                LocalDateTime.of(2024, 12, 25, 10, 0),
                LocalDateTime.of(2024, 12, 25, 22, 0),
                500.0, 150);

        Flight flight2 = new Flight(102, "BB456", "Astana", "Paris",
                LocalDateTime.of(2024, 12, 26, 8, 0),
                LocalDateTime.of(2024, 12, 26, 9, 30),
                200.0, 50);

        Flight flight3 = new Flight(103, "CC789", "Arys", "Tokyo",
                LocalDateTime.of(2024, 12, 27, 14, 0),
                LocalDateTime.of(2024, 12, 28, 6, 0),
                1200.0, 200);

        flightRepository.addFlight(flight1);
        flightRepository.addFlight(flight2);
        flightRepository.addFlight(flight3);

        System.out.println("=== Flights to London (Filtering) ===");
        flightRepository.filterByDestination("London")
                .forEach(System.out::println);
        System.out.println();

        System.out.println("=== Flights Sorted by Price (Sorting) ===");
        flightRepository.sortByPrice()
                .forEach(f -> System.out.println(f.getFlightNumber() +
                        " - $" + f.getBasePrice()));
        System.out.println();

        System.out.println("=== Search Flight AA123 ===");
        Flight foundFlight = flightRepository.searchByFlightNumber("AA123");
        System.out.println(foundFlight != null ? foundFlight : "Not found");
        System.out.println();

        BookingRepository bookingRepository = new BookingRepository();

        Booking booking1 = new Booking(1001, passenger1, flight1,
                FlightClass.BUSINESS, "15A");
        booking1.book(passenger1);

        Booking booking2 = new Booking(1002, passenger2, flight2,
                FlightClass.ECONOMY, "22B");
        booking2.book(passenger2);

        Booking booking3 = new Booking(1003, passenger1, flight3,
                FlightClass.FIRST, "1A");
        booking3.book(passenger1);

        bookingRepository.addBooking(booking1);
        bookingRepository.addBooking(booking2);
        bookingRepository.addBooking(booking3);

        System.out.println("=== All Bookings ===");
        bookingRepository.getAllBookings().forEach(System.out::println);
        System.out.println();

        System.out.println("=== Kasym Alibek Bookings ===");
        bookingRepository.filterByPassenger(passenger1)
                .forEach(System.out::println);
        System.out.println();

        System.out.println("=== Bookings Sorted by Price (Descending) ===");
        bookingRepository.sortByPriceDesc()
                .forEach(b -> System.out.println(b.getBookingDetails()));
        System.out.println();


        System.out.println("=== Equals and HashCode Demo ===");
        Passenger passenger3 = new Passenger(1, "Kasym Alibek", "Kasym@email.com", "AB1234567");
        System.out.println("passenger1.equals(passenger3): " +
                passenger1.equals(passenger3));
        System.out.println("passenger1.hashCode(): " + passenger1.hashCode());
        System.out.println("passenger3.hashCode(): " + passenger3.hashCode());
        System.out.println();

        System.out.println("=== Bookable Interface (Polymorphism) ===");
        Bookable[] bookables = {booking1, booking2, booking3};
        for (Bookable bookable : bookables) {
            System.out.println(bookable.getBookingDetails() +
                    " - Price: $" + bookable.getPrice());
        }

        System.out.println("\n=== Statistics ===");
        System.out.println("Total flights: " + flightRepository.getFlightCount());
        System.out.println("Total bookings: " + bookingRepository.getAllBookings().size());
        System.out.println("John's loyalty points: " + passenger1.getLoyaltyPoints());
        System.out.println("Jane's loyalty points: " + passenger2.getLoyaltyPoints());
    }
}
