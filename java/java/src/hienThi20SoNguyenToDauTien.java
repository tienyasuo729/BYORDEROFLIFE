import java.util.Scanner;

public class hienThi20SoNguyenToDauTien {
    public static void main(String[] args) {
        Scanner nhap = new Scanner(System.in);
        int soluong = Integer.parseInt(nhap.nextLine());
        int count = 0;
        for (int i = 1; i > 0 ;i++) {
            if (i > 1 && i % 2 != 0 && i % 3 != 0 || i == 2 || i == 3) {
                System.out.print(i + ", ");
                count++;
            }
            if (count == soluong) {
                break;
            }

        }
    }
}
