
package code;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadData {
    public static List<Student> readStudentsFromFile(String filename) {
        List<Student> students = new ArrayList<>();

        try {
            File file = new File("C:\\Users\\Tienn\\Downloads\\Week4\\Week4\\Long21\\src\\main\\java\\code\\data");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    int id = Integer.parseInt(parts[0].trim());
                    String name = parts[1].trim();
                    int semester = Integer.parseInt(parts[2].trim());
                    String course = parts[3].trim();
                    students.add(new Student(id, name, semester, course));
                } else {
                    System.out.println("Skipping invalid line: " + line);
                }
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " );
        }

        return students;
    }
}
