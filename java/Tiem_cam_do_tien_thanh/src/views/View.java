package views;

public class View {
    public static void printTypeMenu(String type){
        System.out.println("----- PHONE MENU -----\n" +
                "1. Hiển thị danh sách "+ type + " cầm\n" +
                "2. Thêm "+ type + " cầm\n" +
                "4. Xoá "+ type + " cầm\n" +
                "5. Gia hạn "+ type + " cầm\n" +
                "6. Lấy "+ type + " cầm\n" +
                "7. Quay lại menu chính\n" +
                "8. Thoát."
        );
    }
    public static void printMainMenu(){
        System.out.println("----- MAIN MENU -----\n" +
                "1. Phone\n" +
                "2. Laptop\n" +
                "3. Vehicle"
        );
    }
}
