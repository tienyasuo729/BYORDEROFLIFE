package FuramaResort.Services.Impl;

import FuramaResort.Models.Employee;
import FuramaResort.controllers.FuramaController;

import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeServiceImpl {
    static ArrayList<Employee> listEmployee = new ArrayList<>();

    static Scanner scanner = new Scanner(System.in);
    static boolean check = false;

    static void check(boolean check){
        if (check){
            System.out.println("Không tìm thấy kết quả");
        }
    }

    private static void employeeManagement() {
        System.out.println("1. Display list employees \n2. Add new employee \n3. Edit employee \n4. Return main menu");
    }

    public void EmployeesList() {
        employeeManagement();
        System.out.print("Chọn chức năng : ");
        int choose = Integer.parseInt(scanner.nextLine());
        switch (choose) {
            case 1:
                displayListEmployees();
                break;
            case 2:
                addNewEmployee();
                break;
            case 3:
                editEployee();
                break;
            case 4:
                FuramaController.Menu();
                break;
        }
    }

    private void addNewEmployee() {
        int choose;
        System.out.print("Nhập số căn cước công dân của bạn : ");
        int cccd = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập tên của bạn : ");
        String name = scanner.nextLine();
        System.out.print("Nhập tuổi của bạn : ");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập giới tính của bạn : ");
        String gender = scanner.nextLine();
        System.out.print("Thời gian bạn có thể làm trong ngày hoặc tuần : ");
        String timeForJob = scanner.nextLine();
        System.out.print("Kĩ năng trong công việc mà bạn có : ");
        String skill = scanner.nextLine();
        System.out.print("Bằng cấp mà bạn đạt được : ");
        String degree = scanner.nextLine();
        System.out.println(new Employee(cccd, name, age, gender, timeForJob, skill, degree));
        System.out.print("Bạn có đồng ý với những thông tin mà bạn cung cấp không ( 1 : Đồng ý / 2 : Không ): ");
        choose = Integer.parseInt(scanner.nextLine());
        if (choose == 1) {
            listEmployee.add(new Employee(cccd, name, age, gender, timeForJob, skill, degree));
            EmployeesList();
        } else {
            EmployeesList();
        }
    }

    private void displayListEmployees() {
        System.out.println("List Employees : ");
        System.out.println(listEmployee);
        EmployeesList();
    }

    public void editEployee() {
        int choose;
        System.out.print("Nhập số căn cước của bạn để chỉnh sửa thông tin : ");
        int edit = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < listEmployee.size(); i++) {
            if (listEmployee.get(i).getCccd() == edit) {
                System.out.print("Nhập số căn cước công dân của bạn : ");
                int cccd = Integer.parseInt(scanner.nextLine());
                System.out.print("Nhập tên của bạn : ");
                String name = scanner.nextLine();
                System.out.print("Nhập tuổi của bạn : ");
                int age = Integer.parseInt(scanner.nextLine());
                System.out.print("Nhập giới tính của bạn : ");
                String gender = scanner.nextLine();
                System.out.print("Thời gian bạn có thể làm trong ngày hoặc tuần : ");
                String timeForJob = scanner.nextLine();
                System.out.print("Kĩ năng trong công việc mà bạn có : ");
                String skill = scanner.nextLine();
                System.out.print("Bằng cấp mà bạn đạt được : ");
                String degree = scanner.nextLine();
                System.out.println(new Employee(cccd, name, age, gender, timeForJob, skill, degree));
                System.out.print("Bạn có đồng ý với những thông tin mà bạn cung cấp không ( 1 : Đồng ý / 2 : Không ): ");
                choose = Integer.parseInt(scanner.nextLine());
                if (choose == 1) {
                    listEmployee.add(new Employee(cccd, name, age, gender, timeForJob, skill, degree));
                    check = true;
                    EmployeesList();
                } else {
                    EmployeesList();
                }
            }
            check(check);
        }
    }
}
