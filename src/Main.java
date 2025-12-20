public class Main {
    public static void main(String[] args) {
        System.out.println("=== СИСТЕМА БРОНИРОВАНИЯ АВИАБИЛЕТОВ ===\n");


        Flight flight1 = new Flight("SU100", "Москва", "Нью-Йорк", "2024-12-15 14:30", 150);
        Flight flight2 = new Flight("SU200", "Санкт-Петербург", "Париж", "2024-12-16 09:15", 200);
        Flight flight3 = new Flight("SU300", "Казань", "Токио", "2024-12-17 18:45", 180);


        Passenger passenger1 = new Passenger("P001", "Садыков Арнур", "sadykov@email.com", "+77051234567", 28);
        Passenger passenger2 = new Passenger("P002", "Мадияров Арлан", "madiarov@email.com", "+77779876543", 35);
        Passenger passenger3 = new Passenger("P003", "Сайфулин Халмырза", "saifulin@email.com", "+77081112233", 42);
        Passenger passenger4 = new Passenger("P004", "Зайфуллин Анарбек", "zaifullin@email.com", "+77017778899", 25);


        System.out.println("=== ИНФОРМАЦИЯ О РЕЙСАХ ===");
        flight1.displayFlightInfo();
        System.out.println();
        flight2.displayFlightInfo();
        System.out.println();
        flight3.displayFlightInfo();
        System.out.println();


        System.out.println("=== ПРОЦЕСС БРОНИРОВАНИЯ ===");
        Booking booking1 = new Booking("B001", flight1, passenger1, 2, "2024-11-01");
        Booking booking2 = new Booking("B002", flight1, passenger2, 1, "2024-11-02");
        Booking booking3 = new Booking("B003", flight2, passenger3, 5, "2024-11-03"); // Попытка забронировать больше мест, чем есть
        Booking booking4 = new Booking("B004", flight3, passenger4, 3, "2024-11-04");
        System.out.println();


        booking1.displayBookingInfo();
        booking2.displayBookingInfo();
        booking3.displayBookingInfo();
        booking4.displayBookingInfo();


        System.out.println("\n=== ОТМЕНА БРОНИРОВАНИЯ ===");
        booking1.cancelBooking();
        System.out.println("После отмены:");
        flight1.displayFlightInfo();
        System.out.println();


        System.out.println("=== СРАВНЕНИЕ ОБЪЕКТОВ ===");
        System.out.println("Рейс flight1: " + flight1);
        System.out.println("Рейс flight2: " + flight2);
        System.out.println("Они одинаковые? " + (flight1 == flight2));
        System.out.println("\nПассажир passenger1: " + passenger1);
        System.out.println("Пассажир passenger2: " + passenger2);
        System.out.println("Они одинаковые? " + (passenger1 == passenger2));


        System.out.println("\n=== ИСПОЛЬЗОВАНИЕ ГЕТТЕРОВ ===");
        System.out.println("Номер рейса flight1: " + flight1.getFlightNumber());
        System.out.println("Имя пассажира booking2: " + booking2.getPassenger().getName());
        System.out.println("Свободные места на flight3: " + flight3.getAvailableSeats());


        System.out.println("\n=== СТАТИСТИКА ===");
        System.out.println("Всего создано рейсов: 3");
        System.out.println("Всего создано пассажиров: 4");
        System.out.println("Всего создано бронирований: 4");
        System.out.println("\n=== РАБОТА ПРОГРАММЫ ЗАВЕРШЕНА ===");
    }
}
