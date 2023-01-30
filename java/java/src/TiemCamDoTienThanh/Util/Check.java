package TiemCamDoTienThanh.Util;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;

public class Check {
    private static Scanner scanner = new Scanner(System.in);
    public static void read(){
        try {
            FileWriter fileWriter = new FileWriter("D:\\codegym\\text\\java\\java\\src\\TiemCamDoTienThanh\\Data\\DienThoai");
            BufferedWriter bufferedWriter =new BufferedWriter(fileWriter);
        }catch (Exception e){

        }

    }

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
    public static String checkName(){
        String name = null;
        do {
            name = scanner.nextLine();
            if (name.matches("^[a-z]+$") != true){
                System.out.print("Nhập sai tên rồi, nhập lại: ");
            }
        }while (name.matches("^[a-z]+$") != true);
        return name;
    }

    public static int checkNumberInput(String print) {
        int number = 0;
        boolean check = true;
        do {
            try {
                number = Integer.parseInt(scanner.nextLine());
                check = false;
            } catch (NumberFormatException e) {
                System.out.print(print);
            }
        } while (check);

        return number;
    }

    public static String checkPhoneNumber(){
        String phone = null;
        boolean check = false;
        char[] checkPhoneNumber;

        do {
            phone = scanner.nextLine();
            checkPhoneNumber = phone.toCharArray();
            for (int i = 0; i < checkPhoneNumber.length; i++) {
                if (Character.isLetter(checkPhoneNumber[i])){
                    check = true;
                    System.out.print("Nhập sai số điện thoại rồi, nhập lại: ");
                    break;
                }else {
                    check = false;
                }
            }
        }while (check);
        return phone;
    }
    public static int checkPrice() {
        int price = 0;
        boolean check = true;
        do {
            try {
                price = Integer.parseInt(scanner.nextLine());
                check = false;
            } catch (NumberFormatException e) {
                System.out.print("Nhập lộn giá cầm rồi, nhập lại: ");
            }
        } while (check);
        return price;
    }

    public static void readPrice(int price) {
        String readString = String.valueOf(price);
        char[] reads = readString.toCharArray();
        int index = reads.length;
        System.out.print("Số tiền bằng chữ : ");
        for (int i = 0; i < reads.length; i++) {
            read(Integer.parseInt(String.valueOf(reads[i])));
            if (Integer.parseInt(String.valueOf(reads[i])) != 0 || index == 4 || index == 7 || index == 10){
                donvi(index);
            }
            index--;
        }
        System.out.println("Đồng");
    }

    private static void read(int number){
        switch (number) {
            case 1:
                System.out.print("Một ");
                break;
            case 2:
                System.out.print("Hai ");
                break;
            case 3:
                System.out.print("Ba ");
                break;
            case 4:
                System.out.print("Bốn ");
                break;
            case 5:
                System.out.print("Năm ");
                break;
            case 6:
                System.out.print("Sáu ");
                break;
            case 7:
                System.out.print("Bảy ");
                break;
            case 8:
                System.out.print("Tám ");
                break;
            case 9:
                System.out.print("Chín ");
                break;
        }
    }

    private static void donvi(int index){
        switch (index){
            case 2:
                System.out.print("Mươi ");
                break;
            case 3:
                System.out.print("Trăm ");
                break;
            case 4:
                System.out.print("Nghìn ");
                break;
            case 5:
                System.out.print("Mươi ");
                break;
            case 6:
                System.out.print("Trăm ");
                break;
            case 7:
                System.out.print("Triệu ");
                break;
            case 8:
                System.out.print("Mươi ");
                break;
            case 9:
                System.out.print("Trăm ");
                break;
            case 10:
                System.out.print("Tỷ ");
                break;
        }
    }
    public static int checkYear(){ // kiểm tra năm
        int year = 0;
        boolean check = true;
        do {
            try {
                year = Integer.parseInt(scanner.nextLine());
                check = false;
            }catch (NumberFormatException e){
                System.out.print("Nhập sai năm rồi, nhập lại: ");
            }
        }while (check);

        return year;
    }
    public static int checkMonth(){
        int month = 0;
        boolean check = true;
        do {
            try {
                month = Integer.parseInt(scanner.nextLine());
                if (month <= 12 && month > 0){
                    check = false;
                }else {
                    System.out.print("Nhập sai tháng rồi, nhập lại: ");
                }
            }catch (NumberFormatException e){
                System.out.print("Nhập sai tháng rồi, nhập lại: ");
            }
        }while (check);
        return month;
    }
    public static int checkDay(int year, int month){
        int day = 0;
        boolean check = true;
        do {
            try {
                day = Integer.parseInt(scanner.nextLine());
                if (year % 4 == 0 && month == 2 && day <= 29 && day > 0 || month != 2){
                    check = false;
                }
            }catch (NumberFormatException e){
                System.out.print("Nhập sai ngày rồi, nhập lại: ");
            }
        }while (check);
        return day;
    } // chưa hoàn thành kiểm tra những tháng khác
}
