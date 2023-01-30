package TiemCamDoTienThanh.Service;

import TiemCamDoTienThanh.Model.Customer;
import TiemCamDoTienThanh.Util.Check;
import TiemCamDoTienThanh.View.Menu;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class DienThoai {
    static Scanner scanner = new Scanner(System.in);
    static Set<Customer> customers = new TreeSet<>();
    public static void CamDienThoai(){
        customers.add(new Customer(123,"sad","ád675azxc",123123,12,23,1234,"12390183018"));
        customers.add(new Customer(23,"sad2","ádaz234xc",123123,12,23,1234,"12390183018"));
        customers.add(new Customer(1235,"sad3","ádưerwazxc",123123,12,23,1234,"12390183018"));
        customers.add(new Customer(923,"sad4","ádaz456xcdsf",123123,12,23,1234,"12390183018"));
        do {
            System.out.println("---------- Điện Thoại ----------" +
                    "\n1. Hiển thị thông tin đồ cầm" +
                    "\n2. Thêm điện thoại cầm" +
                    "\n3. Sửa phiếu cầm" +
                    "\n4. Gia hạn phiếu cầm" +
                    "\n5. Tính tổng lãi" +
                    "\n6. Khách lấy đồ cầm" +
                    "\n7. Sắp xếp lại danh sách" +
                    "\n8. Quay lại trang chính");
            int chooseInDienThoai = Check.checkChoose(7);
            switch (chooseInDienThoai){
                case 1:
                    HienThiThongTinDoCam();
                    break;
                case 2:
                    ThemDienThoaiCam();
                    break;
                case 3:
                    SuaPhieuCam();
                    break;
                case 4:
                    GiaHanPhieuCam();
                    break;
                case 5:
                    TinhTongLai();
                    break;
                case 6:
                    KhachLayDoCam();
                    break;
                case 7:

                    break;
                case 8:
                    Menu.Menu();
                    break;
            }
        }while (true);
    }
    private static void HienThiThongTinDoCam(){
        System.out.println("----- Danh sách người cầm -----");
        for (Customer list: customers) {
            System.out.println(String.format("%s : %s [ %s ] giá : %s , %s / %s / %s , { %s } ", list.getId(),list.getName(),list.getProduct(),list.getPrice(),list.getDay(),list.getMonth(),list.getYears(),list.getPhoneNumber()));
        }
    }
    private static void ThemDienThoaiCam(){
        System.out.println("----- Điền thông tin khách hàng -----");
        System.out.print("Nhập mã số cầm: ");
        int id = Check.checkNumberInput("Nhập sai mã số phiếu cầm, nhập lại: ");
        System.out.print("Nhập tên của khách hàng: ");
        String name = Check.checkName();
        System.out.print("Nhập tên đồ cầm: ");
        String product = scanner.nextLine();
        System.out.print("Nhập số tiền cầm: ");
        int price = Check.checkPrice();
        Check.readPrice(price);
        System.out.print("Nhập năm cầm: ");
        int year = Check.checkYear();
        System.out.print("Nhập tháng cầm: ");
        int month = Check.checkMonth();
        System.out.print("Nhập ngày cầm: ");
        int day = Check.checkDay(year,month);
        System.out.print("Nhập số diện thoại của khác hàng: ");
        String phone = Check.checkPhoneNumber();
        customers.add(new Customer(id,name,product,price,day,month,year,phone));
    }
    private static void SuaPhieuCam(){

    }
    private static void GiaHanPhieuCam(){

    }
    private static void TinhTongLai(){

    }
    private static void KhachLayDoCam(){

    }
    private static void SapXepLaiDanhSach(){

    }
}
