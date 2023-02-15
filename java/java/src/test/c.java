package test;
import java.util.Scanner;

public class c {
    public static long giaithua(int n) {
        if (n == 0) {
            return 1;
        }
        return n * giaithua(n - 1);
    }
    static Scanner scanner =new Scanner(System.in);
    public static void main(String[] args) {
//        int n;
//        int phu;
//        int n2 = 1;
//        boolean check = true;
//        do {
//            System.out.print("Nhap n: ");
//            n = Integer.parseInt(scanner.nextLine());
//        }while (n < 0);
//        phu = n;
//        if (n == 0 || n == 1){
//            System.out.print("!" + n + " = 1");
//        }else {
//            System.out.print("!" + n + " = 1");
//            for (int i = 2; i <= phu; i++) {
//                System.out.print(" x " + i);
//                n *= (phu - i + 1);
//            }
//
//
//            System.out.print(" = " + n);
//        }
        System.out.println(giaithua(50));
    }
}