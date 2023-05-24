import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
//tao doi tuong cua lop Person
        Person p = new Person();
//goi phuong thuc cua doi tuong Person
        p.scanInfo();
        p.printInfo();
    }
}
class Person {
    private int id;
    private String name;
    private boolean gender;

    public void scanInfo() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter ID: ");
        id = input.nextInt();
        // Consume the remaining newline character
        input.nextLine();
        System.out.print("Enter Name: ");
        name = input.nextLine();
        System.out.print("Enter Gender: ");
        gender = Boolean.parseBoolean(input.nextLine());
    }

    public void printInfo() {
        System.out.println("-------------------");
        System.out.println("| ID  | Name  | Gender |");
        System.out.printf("| %d | %s | %s    |\n", id, name, (gender ? "Male" : "Female"));
    }
}
