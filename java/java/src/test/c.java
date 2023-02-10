package test;

import java.util.Scanner;

public class c {
    static Scanner scanner =new Scanner(System.in);

    public static void main(String[] args) {
        int n;
        int i;
        int k;
        int m;
        int check = 1;
        System.out.println("Nhap n: ");
        n = Integer.parseInt(scanner.nextLine());
        System.out.print("\nSo nguyen to nho hon "+ n + " la: 1, ");
//        for(k = 2; k <= n; k++){
//		m = sqrt(k);
            for(i = 2; i <= Math.sqrt(n); i++){
                if(n % i == 0){
                    System.out.print(" yes ");
                    check = 0;
                }
            }
// 	if(k % 2 != 0 && k % 3 != 0 && k % 5 != 0 && k % 7 != 0 || k == 2 || k == 3 || k == 5 || k == 7){
// 		printf("%d, ",k);
// 	}
//            if(check == 1){
//                System.out.println(k);
//            }else{
//                check = 1;
//            }
//        }
    }


}
