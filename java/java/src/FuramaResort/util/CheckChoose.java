package FuramaResort.util;

import java.util.Scanner;

public class CheckChoose {
    private static Scanner scanner = new Scanner(System.in);
//    public static void checkIntInPut(int input){ // kiểm tra int nhập vào có bị lỗi về cố tình nhập chữ hay vượt phạm vi int không
//        try {
//
//        }catch (NumberFormatException e){
//            System.out.println("");
//        }
//    }

    //    public static int checkIntInPut(int input, String regex){ // kiểm tra int nhập vào có bị lỗi về cố tình nhập chữ hay vượt phạm vi int không { theo regex }
//        boolean check = false;
//        try {
//            input = Integer.parseInt(scanner.nextLine());
//        }
//        catch (NumberFormatException e){
//            System.out.println("Invalid data, please re-enter: ");
//        }
//        return input;
//    }
    public static String checkIntInPut(int inputLength) { // kiểm tra int nhập vào có bị lỗi về cố tình nhập chữ hay vượt phạm vi int không và trả về String
        boolean check = true; // công tắc kích hoạt ( vòng lặp )
        String input = null;
        int firstTime = 1;
        int checkAge = 0;

        do { // ( vòng lặp )
             // mảng kiểm tra nhập vào có chữ không
            try {
                if (firstTime == 1) { // if phân luồng kiểm ra tuổi hoặc số cccd
                    input = scanner.nextLine();
                } else {
                    System.out.print("Invalid data, please re-enter: ");
                    input = scanner.nextLine();
                }
                if (inputLength <= 3 && inputLength > 0) { // kiểm tra tuổi
                    checkAge = Integer.parseInt(input);
                    if (input.length() <= inputLength){
                        check = false;
                    }
                } else if (input.length() == inputLength) {
                    char [] checkForLettersInput = input.toCharArray();
                    for (int i = 0; i < input.length(); i++) {
                        if (Character.isLetter(checkForLettersInput[i])){ // kiểm tra trong mảng ký tự char ( Character.isLetter() : kiểm tra bên trong có phải ký tự không, nếu có thì trả về true )
                            check = true;
                            break;
                        }else {
                            check = false;
                        }
                    }
                }
                firstTime = 2; // công tắc bật if phân luồng kiểm ra tuổi hoặc số cccd
            } catch (Exception e) {
                firstTime = 2;// công tắc bật if phân luồng kiểm ra tuổi hoặc số cccd
            }
        } while (check);
        return input;
    }

    public static int checkChoose(int numbersOfChoose) { // kiểm tra nhập vào có vượt ra khỏi số lựa chọn hay nhập chữ không
        System.out.print("Enter your choose : ");
        int choose = 0;
        boolean check = false;
        try {
            choose = Integer.parseInt(scanner.nextLine());
            if (choose > numbersOfChoose || choose <= 0) { // kiểm tra xem số nhập vào lần đầu tiên có phù hợp không nếu không thì cho chạy vào ( vòng lặp ) điểm bắt nhập lại
                check = true;
            }
        } catch (NumberFormatException e) {
            System.out.println("-----Just only number of the menu-----");
            check = true;
        }
        if (check) { // ( vòng lặp ) kiểm tra dữ liệu nhập vào
            do {
                try {
                    System.out.print("You chose wrong, Please choose again : ");
                    choose = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("-----Just only number of the menu-----");
                }
            } while (choose > numbersOfChoose || choose <= 0);
        }
        return choose;
    }
}
