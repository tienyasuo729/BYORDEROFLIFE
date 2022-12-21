package Java_Collecion_Frame_Work;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class ProductManager {
    static ArrayList<Product> products = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);


    public static void prin() {
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
        } while (choose > 7 || choose <= 0);
        switch (choose) {
            case 1:
                addProduct();
                break;
            case 2:
                fixInformation();
                break;
            case 3:
                deleteProduct();
                break;
            case 4:
                displayProduct();
                break;
            case 5:
                findProduct();
                break;
            case 6:
                break;
            case 7:
                System.exit(0);
                break;
        }

    }
    public static void main(String[] args) {
        products.add(new Product(56,"aa",200));
        products.add(new Product(23,"bb",20330));
        products.add(new Product(69,"cc",205550));
        prin();
    }
    static void addProduct() {
            System.out.print("Nhập mã sản phẩm : ");
            int id = Integer.parseInt(scanner.nextLine());
            System.out.print("Nhập tên sản phẩm : ");
            String name = scanner.nextLine();
            System.out.print("Nhập giá sản phẩm : ");
            int price = Integer.parseInt(scanner.nextLine());
            System.out.print("Bạn có muốn thêm sản phẩm không ( Y OR N ) : ");
            String choose = scanner.nextLine();
            if (choose.equals("n") || choose.equals("N")) {
                prin();
            } else {
                Product product = new Product(id,name,price);
                products.add(product);
                prin();
            }
    }

    static void fixInformation(){
        int productNeedToFix = 0;
        boolean check = true;
        do {
            System.out.print("Nhập id sản phẩm muốn sửa : ");
            int fixById = Integer.parseInt(scanner.nextLine());
            for (int i = 0; i < products.size(); i++) {
                if (fixById == products.get(i).getId()){
                    check = false;
                    productNeedToFix = i;
                    break;
                }else {
                    System.out.println("Không tìm thấy sản phẩm .");
                }
            }
        }while (check);
        System.out.print("Nhập mã sản phẩm : ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập tên sản phẩm : ");
        String name = scanner.nextLine();
        System.out.print("Nhập giá sản phẩm : ");
        int price = Integer.parseInt(scanner.nextLine());
        System.out.print("Bạn có muốn thêm sản phẩm không ( Y OR N ) : ");
        String choose = scanner.nextLine();
        if (choose.equals("n") || choose.equals("N")) {
            prin();
        } else {
            products.remove(productNeedToFix);
            Product product = new Product(id,name,price);
            products.add(productNeedToFix, product);
            System.out.println("Sản phẩm sau khi sửa là : " + products.get(productNeedToFix));
            prin();
        }
    }

    static void deleteProduct(){
        boolean check = true;
        do {
            System.out.print("Nhập id sản phẩm muốn xoá : ");
            int deleteById = Integer.parseInt(scanner.nextLine());
            for (int i = 0; i < products.size(); i++) {
                if (deleteById == products.get(i).getId()){
                    check = false;
                    products.remove(i);
                    prin();
                    break;
                }else {
                    System.out.println("Không tìm thấy sản phẩm .");
                }
            }
        }while (check);
    }

    static void displayProduct(){
        System.out.println(products);
        prin();
    }

    static void findProduct(){
        boolean check = true;
        do {
            System.out.print("Nhập tên sản phẩm muốn tìm : ");
            String findProduct = scanner.nextLine();
            for (Product product : products) {
                if (Objects.equals(findProduct, product.getNameProduct())) {
                    check = false;
                    System.out.println(product);
                    break;
                }
            }
        }while (check);
        prin();
    }

    static void sortProducts(){
    }
}
