package view;

import model.Employee;

import java.util.ArrayList;

public class EmployeeView {
    public void printEmployeeInfo(Employee employee) {
        System.out.println("Employee Code: " + employee.getEmployeeCode());
        System.out.println("Employee Name: " + employee.getEmployeeName());
        System.out.println("Age: " + employee.getAge());
        System.out.println("Hometown: " + employee.getHometown());
    }

    public void printEmployeeList(ArrayList<Employee> employees) {
        for (Employee employee : employees) {
            printEmployeeInfo(employee);
            System.out.println();
        }
    }

    public void printEmployeeNotFound() {
        System.out.println("Employee not found.");
    }

    public void printEmployeeRemoved() {
        System.out.println("Employee removed.");
    }
}
