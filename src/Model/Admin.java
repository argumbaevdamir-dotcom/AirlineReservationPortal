package Model;

public class Admin extends User {
    private String department;

    public Admin(int id, String name, String email, String department) {
        super(id, name, email);
        this.department = department;
    }

    @Override
    public String getRole() {
        return "ADMIN";
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}
