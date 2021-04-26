package lab8_2;

import lab8_1.MyDate;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Company {
    private String name;
    private ArrayList<Employee> employees = new ArrayList<>();

    public Company(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void hire(Employee employee) {
        this.employees.add(employee);
    }

    public void hireAll(String csvFile) {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(csvFile));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] items = line.split(",");
            switch ( items.length ) {
                case 6:
                    // employee
                    employees.add(new Employee(items[0].trim(), items[1].trim(), Double.parseDouble(items[2].trim()),
                            new MyDate(Integer.parseInt(items[3].trim()), Integer.parseInt(items[4].trim()), Integer.parseInt(items[5].trim()))));
                    break;
                case 7:
                    // manager
                    int year = Integer.parseInt(items[3].trim());
                    int month = Integer.parseInt(items[4].trim());
                    int day = Integer.parseInt(items[5].trim());
                    MyDate myDate = new MyDate(year, month, day);

                    employees.add(new Manager(items[0].trim(), items[1].trim(), Double.parseDouble(items[2].trim()),
                            myDate,
                            items[6].trim()));
//                    employees.add(new Manager(items[0].trim(), items[1].trim(), Double.parseDouble(items[2].trim()),
//                            new MyDate(Integer.parseInt(items[3].trim()), Integer.parseInt(items[4].trim()), Integer.parseInt(items[5].trim())),
//                            items[6].trim()));
                    break;
                default:
                    // skip this line
            }
        }
        scanner.close();
    }

    public void fire(int id) {
        for (Employee e : employees) {
            if (e.getID() == id) {
                employees.remove(e);
            }
        }
    }

    public void printAll(PrintStream printStream) {
        printStream.printf("Company: %s%n", name);
        for (Employee e : employees) {
            if (e instanceof Manager) {
                printStream.printf("  Manager  %-30s %s %s %s%n", e.getFirstName() + " "+ e.getLastName(), e.getBirthDate(), e.getSalary(), ((Manager) e).getDepartment());
            } else {
                printStream.printf("           %-30s %s %s%n", e.getFirstName() + " " + e.getLastName(), e.getBirthDate(), e.getSalary());
            }
        }
    }

    public void printManagers (PrintStream printStream){
        printStream.printf("Company: %s%n", name);
        for (Employee e : employees) {
            if (e instanceof Manager) {
                printStream.printf("  Manager  %s %s %s %s %s%n", e.getFirstName(), e.getLastName(), e.getBirthDate(), e.getSalary(), ((Manager) e).getDepartment());
            }
        }
    }

    public void sortByComparator(Comparator<Employee> comp) {
    }

    public void sortByName(PrintStream printStream) {
        Collections.sort(this.employees, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                String firstName1 = o1.getFirstName();
                String firstName2 = o2.getFirstName();
                String lastName1 = o1.getLastName();
                String lastName2 = o2.getLastName();
                if ( firstName1.equals(firstName2) ) {
                    return lastName1.compareTo(lastName2);
                }
                return firstName1.compareTo(firstName2);
            }
        });
    }

    public void sortByDecreasingSalaryOrder(PrintStream printStream) {
        Collections.sort(this.employees, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return (int)(o2.getSalary() - o1.getSalary());
            }
        });
    }

    public void sortByManagersFollowedByEmployees(PrintStream printStream) {
        Collections.sort(this.employees, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                if ( ((o1 instanceof Manager) &&  (o2 instanceof Manager)) || (!(o1 instanceof Manager) && !(o2 instanceof Manager)) ) {
                    String firstName1 = o1.getFirstName();
                    String firstName2 = o2.getFirstName();
                    String lastName1 = o1.getLastName();
                    String lastName2 = o2.getLastName();
                    if ( firstName1.equals(firstName2) ) {
                        return lastName1.compareTo(lastName2);
                    }
                    return firstName1.compareTo(firstName2);
                }
                return (o1 instanceof Manager )? -1: 1;
           }
        });
    }


}

