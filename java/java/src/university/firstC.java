package university;

import java.util.Scanner;

public class firstC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter length of side : ");
        int s = Integer.parseInt(scanner.nextLine());
        int a = s * s;
        System.out.println("Area of square is : " + a);
    }
}
