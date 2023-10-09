package code;

import java.util.List;

public class Main {
    public static void main(String[] args) {
//        String filename = "C://Users/ACER/OneDrive/Máy tính/LAB/Week4/datastudent.txt";
        String filename = "C:\\Users\\Tienn\\Downloads\\Week4\\Week4\\Long21\\src\\main\\java\\code\\data";
        List<Student> students = ReadData.readStudentsFromFile(filename);
        StudentManagementApp app = new StudentManagementApp(students);

        app.run();
    }
}
