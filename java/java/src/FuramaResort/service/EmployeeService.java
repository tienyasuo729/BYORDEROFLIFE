package FuramaResort.service;

import FuramaResort.Model.Employee;
import FuramaResort.util.CheckChoose;
import FuramaResort.view.MainMenu;

import java.util.*;

public class EmployeeService {
    static Scanner scanner = new Scanner(System.in);
//    private static Set<Employee> listemployee = new TreeSet<>();
    private static List<Employee> listemployee = new ArrayList<>();
    public static void mainEmployee() {
        listemployee.add(new Employee("123123123123","Tiến",23,"HHH"));
        listemployee.add(new Employee("456456456456","Ti",24,"ggg"));
        listemployee.add(new Employee("456456456456","Ti",14,"ggg"));
        listemployee.add(new Employee("456456456456","Ti",2,"ggg"));
        listemployee.add(new Employee("456456456456","Ti",99,"ggg"));
        listemployee.add(new Employee("456456456456","Ti",10,"ggg"));
        listemployee.add(new Employee("456456456456","Ti",10,"ggg"));
        while (true){
            System.out.println("---------- Employee ----------\n" + "1Display list employees\n" + "2Add new employee\n" + "3Edit employee\n" + "4Return main menu");
            int chooseInEmployeeService = CheckChoose.checkChoose(4);
            // lựa chọn = kiểm tra dữ liệu nập vào (  lựa chọn cho trước không nằm trong số tương ứng với chức năng ( 0 ), số lượng chức năng trong quản lí )
            switch (chooseInEmployeeService) {
                case 1:
                    displayListEmployee();
                    break;
                case 2:
                    addEmployee();
                    break;
                case 3:
                    editEmployee();
                    break;
                case 4:
                    MainMenu.displayMainMenu();
                    break;
            }

        }
    }

    public static void addEmployee() {
        System.out.println("---------- Add Employee ----------");
        System.out.print("Enter your CCCD : ");
        String cccd = CheckChoose.checkIntInPut(12);
        System.out.print("Enter your NAME : ");
        String name = scanner.nextLine();
        System.out.print("Enter your AGE : ");
        int age = Integer.parseInt(CheckChoose.checkIntInPut(3));
        System.out.print("Enter your SKILL : ");
        String skill = scanner.nextLine();
        System.out.println("------------------------------\n" + new Employee(cccd,name,age,skill));
        System.out.print("Are you sure ?\n" + "1. YES\n" + "2. NO\n");
        int chooseYNAdd = CheckChoose.checkChoose(2);
        if (chooseYNAdd == 1){
            listemployee.add(new Employee(cccd,name,age,skill));
        }
    }

    public static void displayListEmployee() {
        Collections.sort(listemployee);
        if (listemployee.size() == 0){
            System.out.println("---------- List is empty ----------");
        }else {
            System.out.println("---------- List Employee ----------");
            for (int i = 0; i < listemployee.size(); i++) {
                System.out.println((i+1)+ ": " + listemployee.get(i));
            }
        }
    }

    public static void editEmployee() {
        System.out.print("Enter CCCD you want to edit : ");
        boolean checkFindCCCD;
        do {
            checkFindCCCD = true;
            String findCCCD = CheckChoose.checkIntInPut(12);
            for (int i = 0; i < listemployee.size(); i++) {
                if (findCCCD.equals(listemployee.get(i).getCccd())){
                    checkFindCCCD = false;
                    System.out.println("---------- Edit Employee ----------");
                    System.out.print("Enter your CCCD : ");
                    String cccd = CheckChoose.checkIntInPut(12);
                    System.out.print("Enter your NAME : ");
                    String name = scanner.nextLine();
                    System.out.print("Enter your AGE : ");
                    int age = Integer.parseInt(CheckChoose.checkIntInPut(3));
                    System.out.print("Enter your SKILL : ");
                    String skill = scanner.nextLine();
                    System.out.println("------------------------------\n" + new Employee(cccd,name,age,skill));
                    System.out.print("Are you sure ?\n" + "1. YES\n" + "2. NO\n");
                    int chooseYNAdd = CheckChoose.checkChoose(2);
                    if (chooseYNAdd == 1){
                        listemployee.set(i, new Employee(cccd,name,age,skill));
                    }
                }
            }
            if (checkFindCCCD){
                System.out.println("---Can not find your CCCD ---");
            }
        } while (checkFindCCCD);
    }

}
