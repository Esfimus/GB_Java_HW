package lesson05;

public class Employee {
    private final String name;
    private String position;
    private final String email;
    private final String phoneNumber;
    private int salary;
    private int age;

    public Employee(String name, String position, String email, String phoneNumber, int salary, int age) {
        this.name = name;
        this.position = position;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void displayEmployeeInfo() {
        System.out.printf("""
                Employee card:
                %s
                %s
                %s
                %s
                %d
                %d
                
                """, this.name, this.position, this.email, this.phoneNumber, this.salary, this.age);
    }
}
