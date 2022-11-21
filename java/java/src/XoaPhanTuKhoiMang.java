import java.util.Arrays;
import java.util.Scanner;

public class XoaPhanTuKhoiMang {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập phần tử muốn xoá ra khỏi mảng : ");
        int x = Integer.parseInt(scanner.nextLine());
        int [] arr = new int[1001];
        int [] arr2 = new int[1000];
        int count = 0;
        for (int i = 0; i <= 1000; i++) {
            arr[i] = i;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
             System.out.print("");
            }else {
                arr2[count] = arr[i];
                count++;
            }
        }
        System.out.print(Arrays.toString(arr2));
    }
}
