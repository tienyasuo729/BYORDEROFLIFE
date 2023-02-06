package tiem_cam_do_tien_thanh.util;

import java.util.Scanner;

public class CheckTienThanh {
    private static Scanner scanner = new Scanner(System.in);
    public static int checkChooseTienThanh(int numberOfChoose){
        int choose = 0;
        boolean check = true;
        do {
            try {
                choose = Integer.parseInt(scanner.nextLine());
                if (choose <= numberOfChoose && choose > 0){
                    check =false;
                }else {
                    System.out.print("Nhập lỗi rồi, xin nhập lại: ");
                }
            }catch (NumberFormatException exception){
                System.out.print("Nhập lỗi rồi, xin nhập lại: ");
            }
        }while (check);

        return choose;
    }

}
