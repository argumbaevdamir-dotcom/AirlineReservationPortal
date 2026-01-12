package Repository;

import Model.Booking;
import Model.Passenger;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class BookingRepository {
    private DataPool<Booking> dataPool;

    public BookingRepository() {
        this.dataPool = new DataPool<>();
    }

    public void addBooking(Booking booking) {
        dataPool.add(booking);
    }

    public Booking getBookingById(int id) {
        return dataPool.getById(id);
    }

    public List<Booking> filterByPassenger(Passenger passenger) {
        return dataPool.filter(booking ->
                booking.getPassenger().equals(passenger));
    }

    public List<Booking> filterByBookingDate(LocalDateTime date) {
        return dataPool.filter(booking ->
                booking.getBookingTime().toLocalDate().equals(date.toLocalDate()));
    }

    public List<Booking> searchByMinPrice(double minPrice) {
        return dataPool.filter(booking -> booking.getPrice() >= minPrice);
    }

    public List<Booking> sortByPriceDesc() {
        return dataPool.getAll().stream()
                .sorted((b1, b2) -> Double.compare(b2.getPrice(), b1.getPrice()))
                .collect(Collectors.toList());
    }

    public List<Booking> sortByBookingTime() {
        return dataPool.getAll().stream()
                .sorted(Comparator.comparing(Booking::getBookingTime))
                .collect(Collectors.toList());
    }

    public List<Booking> getAllBookings() {
        return dataPool.getAll();
    }
}