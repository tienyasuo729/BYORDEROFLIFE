package test_retake_module_2.service;

import FuramaResortSet.utilSet.CheckSET;
import test_retake_module_2.model.Student;
import test_retake_module_2.util.Check;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentService {
    private static List<Student> studentList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    public static void add(){
        System.out.print("Nhập vào đây tên sinh viên");
        String name = scanner.nextLine();
        System.out.print("Nhập vào đây ngày sinh");
        String day = scanner.nextLine();
        System.out.print("Nhập vào đây giới tính của sinh viên");
        String sex = scanner.nextLine();
        System.out.print("Nhập vào đây số điện thoại của sinh viên");
        String phoneNumber = scanner.nextLine();
        System.out.print("Nhập vào đây mã lớp học của sinh viên:");
        int idClass = Integer.parseInt(scanner.nextLine());
        System.out.println("------------------------------ \n" + new Student(studentList.size(),name,day,sex,phoneNumber,idClass));
        System.out.print("Are you sure ?\n" + "1. YES\n" + "2. NO\n");
        int chooseYNAdd = Check.checkChoose(2);
        if (chooseYNAdd == 1){
            studentList.add(new Student(studentList.size() + 1,name,day,sex,phoneNumber,idClass);

        }
    }
    public static void delete(){

    }
    public static void display(){

    }
    public static void find(){

    }
}
