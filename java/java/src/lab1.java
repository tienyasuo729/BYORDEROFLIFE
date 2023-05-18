import javax.print.attribute.IntegerSyntax;
import java.util.Scanner;

public class lab1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int soSach;
        System.out.print("Nhập số lượng sách: ");
        soSach = scanner.nextInt();
        scanner.nextLine();

        String[] tenSach = new String[soSach];
        int[] namXuatBan = new int[soSach];

        for (int i = 0; i < soSach; i++) {
            while (true) {
                System.out.printf("Nhập thông tin cho sách thứ: %d\n", i + 1);
                System.out.print("Tên sách: ");
                tenSach[i] = scanner.nextLine();
                System.out.print("Năm xuất bản: ");
                namXuatBan[i] = scanner.nextInt();
                scanner.nextLine();
                if (namXuatBan[i] > 2000 && namXuatBan[i] < 2023) {
                    break;
                } else {
                    System.out.println("Năm xuất bản không hợp lệ. Vui lòng nhập lại.");
                }
            }
        }

        for (int i = 0; i < soSach; i++) {
            double giaSach;
            if (namXuatBan[i] < 2005) {
                giaSach = 0.8;
            } else if (namXuatBan[i] < 2015) {
                giaSach = 0.5;
            } else if (namXuatBan[i] < 2020) {
                giaSach = 0.3;
            } else if (namXuatBan[i] < 2022) {
                giaSach = 0.1;
            } else {
                giaSach = 0;
            }
            double giaBan = giaSach * 100;
            System.out.printf("Tên sách: %s\nNăm xuất bản: %d\nGiảm giá:  %.0f%% \n", tenSach[i], namXuatBan[i], giaBan);


        }
    }
}
