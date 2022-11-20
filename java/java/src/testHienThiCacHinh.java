import java.util.Scanner;

public class testHienThiCacHinh {
    public static void main(String[] args) {
        System.out.println("1.Print the rectangle");
        Scanner scanner = new Scanner(System.in);
        int chieudaichunhat;
        int chieurongchunhat;
        do {
            System.out.print("Nhập vào đây chiều dài của hình chữ nhật : ");
            chieudaichunhat = Integer.parseInt(scanner.nextLine());
        }while (chieudaichunhat <= 0);
        do {
            System.out.print("Nhập vào đây chiều rộng của hình chữ nhật : ");
            chieurongchunhat = Integer.parseInt(scanner.nextLine());
        }while (chieurongchunhat <= 0);
        for (int i = 0; i < chieurongchunhat ; i++) {
            for (int j = 0; j < chieudaichunhat ; j++) {
                System.out.print("* ");
            }
            System.out.print("\n");
        }
        System.out.println("2.Print the square triangle (The corner is square at 4 different angles: top-left, top-right, botton-left, botton-right)");
        int chieucaotamgiacvuong;
        do {
            System.out.print("Nhập vào đây chiều cao của tam giác vuông : ");
            chieucaotamgiacvuong = Integer.parseInt(scanner.nextLine());
        }while (chieucaotamgiacvuong <= 0);
        for (int chieucaoi = 0; chieucaoi < chieucaotamgiacvuong; chieucaoi++) {
            for (int chieucaoj = 0; chieucaoj < chieucaoi + 1; chieucaoj++) {
                System.out.print("* ");
            }
            System.out.print("\n");
        }
        System.out.println("3.Print isosceles triangle");
        int chieucaotamgiacvuongnguoc;
        do {
            System.out.print("Nhập vào đây chiều cao của tam giác vuông ngược : ");
            chieucaotamgiacvuongnguoc = Integer.parseInt(scanner.nextLine());
        }while (chieucaotamgiacvuongnguoc <= 0);
        for (int chieucaonguoci = 0; chieucaonguoci < chieucaotamgiacvuongnguoc; chieucaonguoci++) {
            for (int chieucaonguocj = 0; chieucaonguocj < chieucaotamgiacvuongnguoc - chieucaonguoci; chieucaonguocj++) {
                System.out.print("* ");
            }
            System.out.print("\n");
        }
        System.out.println("4.Exit");
    }
}
