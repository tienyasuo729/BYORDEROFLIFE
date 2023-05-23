import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
//tao doi tuong cua lop Person
        Person p = new Person();
//goi phuong thuc cua doi tuong Person
        p.scanInfo();
        p.printInfo();
    }
    public void scanInfo() {
        Scanner input = new Scanner(System.in);
        System.out.print ("Enter ID: ");
        int id = input.nextInt();
        System.out.print ("Enter Name:");
        String name=input.nextLine();
        System.out.print ("Enter Gender: ");
        boolean gender = input.nextBoolean();
    }
    public void printInfo() {
        System.out.println("-------------------");
        System.out.println("| ID | Name | Male |");
        System.out.printf("%d %s | b |\n", this.id, this.name, this.gender);
    }
}
