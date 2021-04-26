package lab8_2;

import lab8_1.MyDate;

public class Manager extends Employee{
    String department;
    public Manager(String firstName, String lastName, double salary, MyDate birthDate, String department) {
        super(firstName, lastName, salary, birthDate);
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Manager{" +
                super.toString() + " " +
                "department='" + this.department + '\'' +
                "department='" + department + '\'' +
                '}';
    }
}
