import controller.EmployeeController;
import model.Employee;
import view.EmployeeView;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        EmployeeController controller = new EmployeeController();
        EmployeeView view = new EmployeeView();

        controller.addEmployee(1, "John Doe", 30, "New York");
        controller.addEmployee(2, "Jane Smith", 25, "Los Angeles");
        controller.addEmployee(3, "Mike Johnson", 28, "Chicago");

        ArrayList<Employee> employees = controller.getEmployeeList();
        view.printEmployeeList(employees);

        String searchName = "Jane Smith";
        Employee foundEmployee = controller.searchEmployeeByName(searchName);
        if (foundEmployee != null) {
            view.printEmployeeInfo(foundEmployee);
        } else {
            view.printEmployeeNotFound();
        }

        int removeCode = 2;
        boolean isRemoved = controller.removeEmployee(removeCode);
        if (isRemoved) {
            view.printEmployeeRemoved();
        } else {
            view.printEmployeeNotFound();
        }

        employees = controller.getEmployeeList();
        view.printEmployeeList(employees);    }
}