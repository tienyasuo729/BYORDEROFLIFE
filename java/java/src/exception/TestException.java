package exception;

import java.util.Scanner;

public class TestException {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int n = 0;
        try {
            System.out.println("Nhập vào giá trị n : ");
            n = Integer.parseInt(scanner.nextLine());
        }catch (Exception i){
            System.out.println("Nhập sai ");
        }

        System.out.println("Giá trị của n là : " + n);
        System.out.println("kết thúc chương trình .");
    }
}
