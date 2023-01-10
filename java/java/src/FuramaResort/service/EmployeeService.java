package FuramaResort.service;

import FuramaResort.Model.Employee;
import FuramaResort.util.CheckChoose;
import FuramaResort.view.MainMenu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeService {
    static Scanner scanner = new Scanner(System.in);
    private static List<Employee> listemployee = new ArrayList<>();
    public static void mainEmployee() {
        listemployee.add(new Employee(222,"Tiến",23,"HHH"));
        while (true){
            System.out.println("---------- Employee ----------\n" + "1Display list employees\n" + "2Add new employee\n" + "3Edit employee\n" + "4Return main menu");
            int chooseInEmployeeService = 0;
            chooseInEmployeeService = CheckChoose.checkChoose(chooseInEmployeeService, 4);
            // lựa chọn = kiểm tra dữ liệu nập vào (  lựa chọn cho trước không nằm trong số tương ứng với chức năng ( 0 ), số lượng chức năng trong quản lí )
            switch (chooseInEmployeeService) {
                case 1:
                    displayListEmployee();
                    break;
                case 2:
                    addEmployee();
                    break;
                case 3:
                    editEmployee();
                    break;
                case 4:
                    MainMenu.displayMainMenu();
                    break;
            }

        }
    }

    public static void addEmployee() {
        System.out.println("---------- Add Employee ----------");
        System.out.print("Enter your CCCD : ");
        int cccd = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter your NAME : ");
        String name = scanner.nextLine();
        System.out.print("Enter your AGE : ");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter your SKILL : ");
        String skill = scanner.nextLine();
        System.out.print("Are you sure ?\n" + "1. YES\n" + "2. NO\n");
        int chooseYNAdd = 0;
        chooseYNAdd = CheckChoose.checkChoose(chooseYNAdd, 2);
        if (chooseYNAdd == 1){
            listemployee.add(new Employee(cccd,name,age,skill));
        }
    }

    public static void displayListEmployee() {
        System.out.println("---------- List Employee ----------");
        System.out.println(listemployee);
    }

    public static void editEmployee() {

    }

}
