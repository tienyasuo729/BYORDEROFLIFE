package FuramaResort.Services.Impl;

import FuramaResort.Models.Employee;

import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeServiceImpl {
    public void addNewEmployee(){
        ArrayList<Employee> listEmployee = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
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
        listEmployee.add(new Employee(cccd,name,age,gender,timeForJob,skill,degree));
    }
    public void displayListEmployees(){

    }
}
