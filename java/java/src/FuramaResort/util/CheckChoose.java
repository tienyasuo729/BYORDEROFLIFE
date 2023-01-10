package FuramaResort.util;

import java.util.Scanner;

public class CheckChoose {
    private static Scanner scanner = new Scanner(System.in);
    public static int checkChoose(int choose, int numbersOfChoose){ // kiểm tra nhập vào có vượt ra khỏi số lựa chọn hay nhập chữ không
        System.out.print("Enter your choose : ");
        boolean check = false;
        try {
            choose = Integer.parseInt(scanner.nextLine());
            if (choose > numbersOfChoose || choose <= 0){
                check = true;
            }
        }catch (NumberFormatException e){
            System.out.println("-----Just only number of the menu-----");
            check = true;
        }
        if(check){
            do {
                try {
                    System.out.print("You chose wrong, Please choose again : ");
                    choose = Integer.parseInt(scanner.nextLine());
                }catch (NumberFormatException e){
                    System.out.println("-----Just only number of the menu-----");
                }
            }while (choose > numbersOfChoose || choose <= 0);
        }
        return choose;
    }
}
