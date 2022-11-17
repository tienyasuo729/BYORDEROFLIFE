import java.security.PrivateKey;
import java.util.Scanner;

public class test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String print = "Đọc số cần in ra màn hình là : ";
        int number;
        do {
            System.out.print("Mời nhập số nguyên không âm dưới 1000 : ");
            number = Integer.parseInt(sc.next());
        } while (number >= 1000 || number < 0);
        if (number <= 10) {
            System.out.println(bbb(number));
        }else if (number < 100) {
            System.out.println("2 số");
        }else {
            System.out.println("3 số");
        }
        System.out.print("Số vừa nhập là : " + number);
    }
    private static String bbb(int number){
        switch (number) {
            case 1:
                print += "Một";
                break;
            case 2:
                print +="Hai";
                break;
            case 3:
                print +="Ba";
                break;
            case 4:
                print +="Bốn";
                break;
            case 5:
                print +="Năm";
                break;
            case 6:
                print +="Sáu";
                break;
            case 7:
                print +="Bảy";
                break;
            case 8:
                print +="Tám";
                break;
            case 9:
                print +="Chín";
                break;
            case 10:
                print +="Mười";
                break;
            default:
                print +="Không";
        }
    }

}
