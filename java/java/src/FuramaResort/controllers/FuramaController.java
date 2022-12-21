package FuramaResort.controllers;

import FuramaResort.Services.Impl.EmployeeServiceImpl;

import java.util.Scanner;

public class FuramaController {

    private static void displayMainMenu (){
        System.out.println("1.Employee Management \n2.Customer Management \n3.FuramaResort.Models.Facility Management \n4.Booking Management \n5.Promotion Management \n6.Exit");
    }
    private static void employeeManagement (){
        System.out.println("1. Display list employees \n2. Add new employee \n3. Edit employee \n4. Return main menu");
    }
    private static void customerManagement(){
        System.out.println("1. Display list customers \n2. Add new customer \n3. Edit customer \n4. Return main menu");
    }
    private static void facilityManagement(){
        System.out.println("1. Display list facility \n2. Add new facility \n3. Display list facility maintenance \n4. Return main menu");
    }
    private static void bookingManagement(){
        System.out.println("1. Add new booking \n2. Display list booking \n3. Create new constracts \n4. Display list contracts \n5. Edit contracts \n6. Return main menu");
    }
    private static void promotionManagement(){
        System.out.println("1. Display list customers use service \n2. Display list customers get voucher \n3. Return main menu");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
        displayMainMenu();
        System.out.print("Chọn chức năng : ");
        int choose = Integer.parseInt(scanner.nextLine());
        switch (choose) {
            case 1:
                employeeManagement();
                employeeService.addNewEmployee();
                break;
            case 2:
                customerManagement();
                break;
            case 3:
                facilityManagement();
                break;
            case 4:
                bookingManagement();
                break;
            case 5:
                promotionManagement();
                break;
            case 6:
                System.out.println("End");
                break;
        }
    }
}
