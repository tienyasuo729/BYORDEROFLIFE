package FuramaResort.view;

import java.util.Scanner;

public class mainMenu{
    static Scanner scanner = new Scanner(System.in);
    private

    public void displayMainMenu(){
        System.out.println("1.Employee Management \n2.Customer Management \n3.Facility Management \n4.Booking Management \n5.Promotion Management \n6.Exit");
        System.out.print("Enter your selection : ");
        int chooseInMainMenu = Integer.parseInt(scanner.nextLine());
        switch (chooseInMainMenu){
            case 1:
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
