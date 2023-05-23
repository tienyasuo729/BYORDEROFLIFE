import java.util.Scanner;

public class Person {
    private int id;
    private String name;
    private boolean gender;

    public Person(int id, String name, boolean gender) {
        this.id = id;
        this.name = name;
        this.gender = gender;
    }

    public Person() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public void scanInfo() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter ID: ");
        this.id = input.nextInt();
        input.nextLine();
        System.out.print("Enter Name:");
        this.name = input.nextLine();
        System.out.print("Enter Gender: ");
        this.gender = input.nextBoolean();
    }

    public void printInfo() {
        System.out.println("-----------------------------------");
        System.out.println("| ID | Name | Male 1");
        System.out.printf("| %d | %s | %b |\n", this.id, this.name, this.gender);
    }
}
