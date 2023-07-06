package views;

import validate.Validate;

import java.util.List;
import java.util.Scanner;

public class View<T> {
    private static Scanner scanner = new Scanner(System.in);
    public static void printTypeMenu(String type){
        System.out.println("----- " + type.toUpperCase() + " MENU -----\n" +
                "1. Hiển thị danh sách "+ type + " cầm\n" +
                "2. Thêm "+ type + " cầm\n" +
                "3. Sửa thông tin " + type + " cầm\n" +
                "4. Xoá "+ type + " cầm\n" +
                "5. Gia hạn "+ type + " cầm\n" +
                "6. Lấy "+ type + " cầm\n" +
                "7. Quay lại menu chính\n" +
                "8. Thoát."
        );
    }
    public static void printMainMenu(){
        System.out.println("----- MAIN MENU -----\n" +
                "1. Phone\n" +
                "2. Laptop\n" +
                "3. Vehicle\n" +
                "4. Thoát"
        );
    }

    public static Boolean confirm(String title){
        System.out.println(title + "\n1. Có\n2. Không");
        String choose = Validate.checkIntInPut("","","");
        if (choose == "1"){
            return true;
        }else {
            return false;
        }
    }
    public void printList(List<T> lists, String type){
        System.out.println("---------- Danh sách " + type + " cầm ----------");
        for (T list: lists) {
            System.out.println(list.toString());
        }
        System.out.println("----------------------------------------");
    }

    public static String manufacturerPhone(){
        System.out.println("Lựa chọn hãng điện thoại\n" +
                "1. Samsung\n" +
                "2. Iphone\n" +
                "3. Redmi\n" +
                "4. Oppo" +
                "5. Khác");
        int choose = Integer.parseInt(Validate.checkIntInPut("","",""));
        String result = null;
        switch (choose){
            case 1:
                result = "Samsung";
                break;
            case 2:
                result = "Iphone";
                break;
            case 3:
                result = "Redmi";
                break;
            case 4:
                result = "Oppo";
                break;
            case 5:
                System.out.print("- Nhập lựa chọn khác của bạn: ");
                result = scanner.nextLine();
                break;
        }
        return result;
    }
}
