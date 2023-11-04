package model;

public class Employee {
    private int employeeCode;
    private String employeeName;
    private int age;
    private String hometown;

    public Employee(int employeeCode, String employeeName, int age, String hometown) {
        this.employeeCode = employeeCode;
        this.employeeName = employeeName;
        this.age = age;
        this.hometown = hometown;
    }

    // Getter và Setter cho các thuộc tính của Employee
    public int getEmployeeCode() {
        return employeeCode;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public int getAge() {
        return age;
    }

    public String getHometown() {
        return hometown;
    }
}
