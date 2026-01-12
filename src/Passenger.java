public class Passenger {
    private String passengerId;
    private String name;
    private String email;
    private String phone;
    private int age;


    public Passenger(String passengerId, String name, String email, String phone, int age) {
        this.passengerId = passengerId;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.age = age;
    }


    public String getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(String passengerId) {
        this.passengerId = passengerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public void displayPassengerInfo() {
        System.out.println("ID пассажира: " + passengerId);
        System.out.println("Имя: " + name);
        System.out.println("Email: " + email);
        System.out.println("Телефон: " + phone);
        System.out.println("Возраст: " + age);
    }

    @Override
    public String toString() {
        return name + " (ID: " + passengerId + ")";
    }
}
