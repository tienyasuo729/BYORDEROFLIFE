package FuramaResort.controllers;

import FuramaResort.Services.Impl.EmployeeServiceImpl;

import java.util.Scanner;

public class FuramaController {
    static EmployeeServiceImpl employeeService = new EmployeeServiceImpl();

    public static void Menu() {
        Scanner scanner = new Scanner(System.in);
        displayMainMenu();
        System.out.print("Chọn chức năng : ");
        int choose = Integer.parseInt(scanner.nextLine());
        switch (choose) {
            case 1:
                employeeService.EmployeesList();
                break;
            case 2:

                break;
            case 3:

                break;
            case 4:

                break;
            case 5:

                break;
            case 6:
                System.out.println("End");
                break;
        }
        System.out.println(employeeService);
    }


    private static void displayMainMenu() {
        System.out.println("1.Employee Management \n2.Customer Management \n3.FuramaResort.Models.Facility Management \n4.Booking Management \n5.Promotion Management \n6.Exit");
    }
//
//    private static void employeeManagement() {
//        System.out.println("1. Display list employees \n2. Add new employee \n3. Edit employee \n4. Return main menu");
//    }
//
//    private static void customerManagement() {
//        System.out.println("1. Display list customers \n2. Add new customer \n3. Edit customer \n4. Return main menu");
//    }
//
//    private static void facilityManagement() {
//        System.out.println("1. Display list facility \n2. Add new facility \n3. Display list facility maintenance \n4. Return main menu");
//    }
//
//    private static void bookingManagement() {
//        System.out.println("1. Add new booking \n2. Display list booking \n3. Create new constracts \n4. Display list contracts \n5. Edit contracts \n6. Return main menu");
//    }
//
//    private static void promotionManagement() {
//        System.out.println("1. Display list customers use service \n2. Display list customers get voucher \n3. Return main menu");
//    }

    public static void main(String[] args) {
        Menu();
    }
}
