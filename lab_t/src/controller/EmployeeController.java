package controller;

import model.Employee;

import java.util.ArrayList;

public class EmployeeController {
    private ArrayList<Employee> employeeList = new ArrayList<>();

    public void addEmployee(int employeeCode, String employeeName, int age, String hometown) {
        Employee employee = new Employee(employeeCode, employeeName, age, hometown);
        employeeList.add(employee);
    }

    public ArrayList<Employee> getEmployeeList() {
        return employeeList;
    }

    public Employee searchEmployeeByName(String name) {
        for (Employee employee : employeeList) {
            if (employee.getEmployeeName().equals(name)) {
                return employee;
            }
        }
        return null;
    }

    public boolean removeEmployee(int employeeCode) {
        for (Employee employee : employeeList) {
            if (employee.getEmployeeCode() == employeeCode) {
                employeeList.remove(employee);
                return true;
            }
        }
        return false;
    }
}
