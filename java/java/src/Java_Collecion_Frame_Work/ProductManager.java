package Java_Collecion_Frame_Work;

import java.util.ArrayList;
import java.util.Scanner;

public class ProductManager {
    static ArrayList<Product> products = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void product() {
        System.out.println("1/ Thêm sản phâm mới");
        System.out.println("2/ Sủa sản phẩm trong danh sách");
        System.out.println("3/ Xoá sản phẩm trong danh sách");
        System.out.println("4/ Hiển thị sản phẩm trong danh sách");
        System.out.println("5/ Tìm kiếm sản phẩm trong danh sách");
        System.out.println("6/ Sắp xếp sản phẩm trong danh sách");
        System.out.println("7/ Thoát");
        int choose;
        do {
            System.out.print("Chọn chức năng muốn thực hiện : ");
            choose = Integer.parseInt(scanner.nextLine());
        } while (choose > 7 || choose < 0);
        switch (choose) {
            case 1:
                addProduct();
                break;
            case 2:
                fixInformation();
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                System.exit(0);
                break;
        }

    }

    static void addProduct() {
        while (true) {
            System.out.print("Nhập mã sản phẩm : ");
            int id = Integer.parseInt(scanner.nextLine());
            System.out.print("Nhập tên sản phẩm : ");
            String name = scanner.nextLine();
            System.out.print("Nhập giá sản phẩm : ");
            int price = Integer.parseInt(scanner.nextLine());
            System.out.print("Bạn có muốn thêm sản phẩm không ( Y OR N ) : ");
            String choose = scanner.nextLine();
            if (choose.equals("n") || choose.equals("N")) {
                product();
            }
        }
    }

    static void fixInformation(){

    }

    public static void main(String[] args) {
        product();
    }
}
