package Model;

public class Passenger extends User {
    private String passportNumber;
    private int loyaltyPoints;

    public Passenger(int id, String name, String email, String passportNumber) {
        super(id, name, email);
        this.passportNumber = passportNumber;
        this.loyaltyPoints = 0;
    }

    @Override
    public String getRole() {
        return "PASSENGER";
    }

    @Override
    public void validate() {
        super.validate();
        if (passportNumber == null || passportNumber.length() < 8) {
            throw new IllegalArgumentException("Invalid passport number");
        }
    }


    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public void addLoyaltyPoints(int points) {
        this.loyaltyPoints += points;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", passportNumber='" + passportNumber + '\'' +
                ", loyaltyPoints=" + loyaltyPoints +
                '}';
    }
}
