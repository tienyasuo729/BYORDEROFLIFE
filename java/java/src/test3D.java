
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class test3D {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        ArrayList<Person> personArrayList = new ArrayList<>();
        personArrayList.add(new Person(1, "fff", true));
        personArrayList.add(new Person(2, "fff", false));
        for (int i = 0; i < 2; i++) {
                personArrayList.add(writeInformation(i));
        }
        System.out.println("-----------------------------");
        findByID(personArrayList);
        System.out.println("-----------------------------");
        displayList(personArrayList);
    }

    private static void displayList(List<Person> personArrayList) {
        for (int i = 0; i < personArrayList.size(); i++) {
            System.out.println(personArrayList.get(i).toString());
        }
    }

    private static void findByID(List<Person> personArrayList) {
        System.out.print("- Nhập id muốn tìm: ");
        int find = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < personArrayList.size(); i++) {
            if (personArrayList.get(i).getId() == find) {
                System.out.println(personArrayList.get(i));
            }
        }
    }

    private static Person writeInformation(int i) {
        System.out.print("- mời bạn nhập id cho người dùng thứ " + (i + 1) + " : ");
        int id = checkId(scanner.nextLine());
        System.out.print("- Nhập tên cho người thứ " + (i + 1) + " : ");
        String name = scanner.nextLine();
        System.out.print("- Nhập giới tính cho người dùng: " + (i + 1) + " : ");
        Boolean gender = Boolean.valueOf(scanner.nextLine());
        return new Person(id, name, gender);
    }

    private static int checkId(String idToCheck) {
        int id = 0;
        Boolean check = false;
        do {
            try {
                id = Integer.parseInt(idToCheck);
                check = false;
            } catch (Exception e) {
                System.out.print("- Chỉ nhập số, xin mời nhập lại: ");
                check = true;
            }
        } while (check);
        return id;
    }
}
