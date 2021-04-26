package lab8_2;

public class Main {
    public static void main(String[] args) {
//        Employee employee = new Employee("Takahiro", "FUJIWARA",2000, new MyDate(2000,1,2));
//        System.out.println(employee);
        Company comp = new Company("my company");

        comp.hireAll("employees.csv");
        comp.printAll(System.out);
        System.out.println("\nAlphabetically: ");
//        comp.sortByComparator(new Comparator<Employee>() {
//            @Override
//            public int compare(Employee o1, Employee o2) {
//                String firstName1 = o1.getFirstName();
//                String firstName2 = o2.getFirstName();
//                String lastName1 = o1.getLastName();
//                String lastName2 = o2.getLastName();
//                if ( firstName1.equals(firstName2) ) {
//                    return lastName1.compareTo(lastName2);
//                }
//                return firstName1.compareTo(firstName2);
//            }
//        });
        comp.sortByName(System.out);

        System.out.println("\nDecreasing salary order: ");
        comp.sortByDecreasingSalaryOrder(System.out);
        comp.printAll(System.out);

        System.out.println("\nManagers followed by employees: ");
        comp.sortByManagersFollowedByEmployees(System.out);
        comp.printAll(System.out);


    }
}
