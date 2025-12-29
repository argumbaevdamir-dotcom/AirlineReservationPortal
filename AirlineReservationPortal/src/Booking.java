public class Booking {
    private String bookingId;
    private Flight flight;
    private Passenger passenger;
    private int numberOfSeats;
    private String bookingDate;
    private boolean isConfirmed;


    public Booking(String bookingId, Flight flight, Passenger passenger,
                   int numberOfSeats, String bookingDate) {
        this.bookingId = bookingId;
        this.flight = flight;
        this.passenger = passenger;
        this.numberOfSeats = numberOfSeats;
        this.bookingDate = bookingDate;
        this.isConfirmed = false;
        confirmBooking();
    }


    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public boolean isConfirmed() {
        return isConfirmed;
    }

    public void setConfirmed(boolean confirmed) {
        isConfirmed = confirmed;
    }


    private void confirmBooking() {
        if (flight.bookSeats(numberOfSeats)) {
            isConfirmed = true;
            System.out.println("✅ Бронирование " + bookingId + " подтверждено для " + passenger.getName());
        } else {
            System.out.println("❌ Недостаточно мест для бронирования " + bookingId);
        }
    }


    public void cancelBooking() {
        if (isConfirmed) {
            flight.setBookedSeats(flight.getBookedSeats() - numberOfSeats);
            isConfirmed = false;
            System.out.println("❌ Бронирование " + bookingId + " отменено");
        }
    }


    public void displayBookingInfo() {
        System.out.println("\n=== ИНФОРМАЦИЯ О БРОНИРОВАНИИ ===");
        System.out.println("ID бронирования: " + bookingId);
        System.out.println("Дата бронирования: " + bookingDate);
        System.out.println("Статус: " + (isConfirmed ? "ПОДТВЕРЖДЕНО" : "ОЖИДАЕТСЯ"));
        System.out.println("Количество мест: " + numberOfSeats);
        System.out.println("\nИнформация о рейсе:");
        flight.displayFlightInfo();
        System.out.println("\nИнформация о пассажире:");
        passenger.displayPassengerInfo();
        System.out.println("------------------------------");
    }

    @Override
    public String toString() {
        return "Бронирование " + bookingId + " [" + (isConfirmed ? "подтверждено" : "не подтверждено") + "]";
    }
}
