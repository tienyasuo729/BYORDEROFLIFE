package TiemCamDoTienThanh.View;

import TiemCamDoTienThanh.Service.DienThoai;
import TiemCamDoTienThanh.Service.XeMay;
import TiemCamDoTienThanh.Util.Check;

public class Menu {
    public static void Menu() {
        System.out.println("---------- TIỆM CẦM ĐỒ TIẾN THANH ---------- " +
                "\n1. Điện thoại " +
                "\n2. Xe máy");
        int choose = Check.checkChoose(2);
        switch (choose){
            case 1:
                DienThoai.CamDienThoai();
                break;
            case 2:
                XeMay.CamXeMay();
                break;
        }
    }
}
