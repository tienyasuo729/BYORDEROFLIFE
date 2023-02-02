package test_retake_module_2.util;

import java.util.Scanner;

public class Check {
    static Scanner scanner = new Scanner(System.in);

    public static int checkChoose(int numbersOfChoose) {
        int choose = 0;
        boolean check = true;
        System.out.print("Nhập vào đây lựa chọn của bạn : ");
        do {
            try {
                choose = Integer.parseInt(scanner.nextLine());
                if (choose <= numbersOfChoose && choose > 0) {
                    check = false;
                } else {
                    System.out.print("Lỗi, xin mời nhập lại :");
                }
            } catch (NumberFormatException e) {
                System.out.print("Lỗi, xin mời nhập lại :");
            }
        } while (check);

        return choose;
    }
}
