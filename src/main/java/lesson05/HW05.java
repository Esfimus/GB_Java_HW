package lesson05;

public class HW05 {

    public static void main(String[] args) {

        Employee[] empArray = new Employee[5];
        empArray[0] = new Employee("Jack Ryan", "Developer",
                "jr@emp.com", "+1-505-555-0193",
                190_000, 38);
        empArray[1] = new Employee("Jackie McLean", "Supervisor",
                "jm@emp.com", "+1-505-555-0107",
                150_000, 42);
        empArray[2] = new Employee("Martin Byrde", "Accountant",
                "mb@emp.com", "+1-505-555-0117",
                110_000, 31);
        empArray[3] = new Employee("Mark Knopfler", "Senior developer",
                "mk@emp.com", "+1-505-555-0165",
                250_000, 43);
        empArray[4] = new Employee("Ray Donovan", "Fixer",
                "rd@emp.com", "+1-505-555-0173",
                170_000, 45);

        for (Employee employee : empArray) {
            if (employee.getAge() >= 40) {
                employee.displayEmployeeInfo();
            }
        }
    }
}