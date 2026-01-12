import java.sql.*;
    public class OOP {
        public static void main(String[] args) {
            String url = "jdbc:postgresql://localhost:5432/OOPDamir";
            String user = "postgres";
            String password = "1234";

            try (Connection conn = DriverManager.getConnection(url, user, password)) {


                String insertPassengerSql = "INSERT INTO Passenger (full_name, email) VALUES (?, ?) RETURNING passenger_id";
                int generatedPassengerId = -1;

                try (PreparedStatement ps = conn.prepareStatement(insertPassengerSql)) {
                    ps.setString(1, "Дамир Аргумбаев");
                    ps.setString(2, "damir@maile.com");

                    ResultSet rs = ps.executeQuery(); // Используем executeQuery, так как есть RETURNING
                    if (rs.next()) {
                        generatedPassengerId = rs.getInt(1);
                        System.out.println("Пассажир добавлен с ID: " + generatedPassengerId);
                    }
                }


                if (generatedPassengerId != -1) {
                    String insertBookingSql = "INSERT INTO Booking (passenger_id, flight_id) VALUES (?, ?)";
                    try (PreparedStatement bookingSt = conn.prepareStatement(insertBookingSql)) {
                        bookingSt.setInt(1, generatedPassengerId);
                        bookingSt.setInt(2, 1); // Предположим, flight_id = 1 уже существует
                        bookingSt.executeUpdate();
                        System.out.println("Бронирование для " + "Иван Иванов" + " успешно создано!");
                    }
                }


                String reportSql = """
                            SELECT p.full_name, f.flight_number 
                            FROM Booking b
                            JOIN Passenger p ON b.passenger_id = p.passenger_id
                            JOIN Flight f ON b.flight_id = f.flight_id
                        """;

                try (Statement st = conn.createStatement();
                     ResultSet rs = st.executeQuery(reportSql)) {
                    System.out.println("\n--- Список всех броней ---");
                    while (rs.next()) {
                        System.out.println("Пассажир: " + rs.getString("full_name") +
                                " | Рейс: " + rs.getString("flight_number"));
                    }
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }}