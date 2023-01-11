package FuramaResort.view;

import FuramaResort.service.EmployeeService;
import FuramaResort.util.CheckChoose;

import java.util.Scanner;

public class MainMenu {
    static Scanner scanner = new Scanner(System.in);

    public static void displayMainMenu() {
        while (true) {
            System.out.println("---------- MENU ---------- \n1.Employee Management \n2.Customer Management \n3.Facility Management \n4.Booking Management \n5.Promotion Management \n6.Exit");
            int chooseInMainMenu = 0;
            chooseInMainMenu = CheckChoose.checkChoose(6);
            switch (chooseInMainMenu) {
                case 1:
                    EmployeeService.mainEmployee();
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
                    System.exit(0);
            }
        }
    }
}
