package lab8_2;

import lab8_1.MyDate;

import java.util.Comparator;

public class Employee implements Comparable<Employee> {
    private final int ID;
    private String firstName;
    private String lastName;
    private double salary;
    private MyDate birthDate;
    private static int counter;

    public Employee(String firstName, String lastName, double salary, MyDate birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.birthDate = birthDate;
        this.ID = ++counter;
    }

    public int getID() {
        return ID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public double getSalary() {
        return salary;
    }

    public MyDate getBirthDate() {
        return birthDate;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "ID=" + ID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", salary=" + salary +
                ", birthDate=" + birthDate +
                ", counter=" + counter +
                '}';
    }

    @Override
    public int compareTo(Employee o) {
        String firstName1 = this.getFirstName();
        String firstName2 = o.getFirstName();
        String lastName1 = this.getLastName();
        String lastName2 = o.getLastName();
        if ( firstName1.equals(firstName2) ) {
            return lastName1.compareTo(lastName2);
        }
        return firstName1.compareTo(firstName2);
    }


}
