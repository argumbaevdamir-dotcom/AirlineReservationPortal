public class Flight {
    private String flightNumber;
    private String origin;
    private String destination;
    private String departureTime;
    private int totalSeats;
    private int bookedSeats;

    public Flight(String flightNumber, String origin, String destination,
                  String departureTime, int totalSeats) {
        this.flightNumber = flightNumber;
        this.origin = origin;
        this.destination = destination;
        this.departureTime = departureTime;
        this.totalSeats = totalSeats;
        this.bookedSeats = 0;
    }


    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }

    public int getBookedSeats() {
        return bookedSeats;
    }

    public void setBookedSeats(int bookedSeats) {
        this.bookedSeats = bookedSeats;
    }


    public boolean bookSeats(int seats) {
        if (bookedSeats + seats <= totalSeats) {
            bookedSeats += seats;
            return true;
        }
        return false;
    }

    public int getAvailableSeats() {
        return totalSeats - bookedSeats;
    }


    public void displayFlightInfo() {
        System.out.println("Рейс " + flightNumber + ": " + origin + " → " + destination);
        System.out.println("Вылет: " + departureTime);
        System.out.println("Места: " + bookedSeats + "/" + totalSeats + " забронировано");
        System.out.println("Свободно: " + getAvailableSeats() + " мест");
    }

    @Override
    public String toString() {
        return flightNumber + " [" + origin + "-" + destination + "]";
    }
}
