package test_retake_module_2.controller;

import test_retake_module_2.util.Check;

public class Controller {
    public static void menu() {
        while (true) {
            System.out.println("--- Chương trình quản lý sinh viên ---" +
                    "\n1. Thêm mới sinh viên" +
                    "\n2. Xoá sinh viên" +
                    "\n3. Xem dánh sách sinh viên" +
                    "\n4. Tìm kiếm sinh viên" +
                    "\n5. Tìm kiếm sinh viên" +
                    "\n6. Thoát");
            System.out.print("Nhập vào đây lựa chọn của bạn: ");
            int choose = Check.checkChoose(6);
            switch (choose) {
                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:
                    System.exit(0);
                    break;
            }
        }
    }
}
