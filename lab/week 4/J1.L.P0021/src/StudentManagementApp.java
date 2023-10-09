import model.Student;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentManagementApp {
    private StudentManager studentManager;
    private Scanner scanner;
    private List<Student> students;

    public StudentManagementApp(List<Student> students) {
        this.students = students;
        studentManager = new StudentManager();
        scanner = new Scanner(System.in);
    }

    public void run() {
        int choice;

        do {
            System.out.println("WELCOME TO STUDENT MANAGEMENT");
            System.out.println("1. Create");
            System.out.println("2. Find and Sort");
            System.out.println("3. Update/Delete");
            System.out.println("4. Report");
            System.out.println("5. Display All Students");
            System.out.println("6. Exit");
            System.out.print("Please choose an option: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    createStudent();
                    break;
                case 2:
                    findAndSortStudents();
                    break;
                case 3:
                    updateOrDeleteStudent();
                    break;
                case 4:
                    displayStudentReport();
                    break;
                case 5:
                    displayAllStudents();
                    break;
                case 6:
                    System.out.println("Exiting program.");
                    break;

                default:
                    System.out.println("Invalid choice. Please choose again.");
            }
        } while (choice != 6);

        scanner.close();
    }

    private void createStudent() {
        while (true) {
            System.out.print("Enter student id: ");
            String id = scanner.nextLine();
            System.out.print("Enter student name: ");
            String name = scanner.nextLine();
            System.out.print("Enter semester: ");
            int semester = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter course (Java, .Net, C/C++): ");
            String course = scanner.nextLine();

            studentManager.createStudent(name, semester, course);

            System.out.print("Do you want to continue (Y/N)? ");
            String continueInput = scanner.nextLine();
            if (!continueInput.equalsIgnoreCase("Y")) {
                break;
            }
        }
    }

    private void findAndSortStudents() {
        System.out.print("Enter student name or part of the name: ");
        String searchName = scanner.nextLine();

        List<Student> searchResults = studentManager.findAndSortStudents(searchName);

        if (searchResults.isEmpty()) {
            System.out.println("No matching students found.");
        } else {
            System.out.println("Search results (sorted by name):");
            for (Student student : searchResults) {
                System.out.println(student);
            }
        }
    }

    private void updateOrDeleteStudent() {
        System.out.print("Enter student ID to update or delete: ");
        int studentIdToUpdateOrDelete = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Do you want to update (U) or delete (D) this student? ");
        String choice = scanner.nextLine();
        if (choice.equalsIgnoreCase("U")) {
            System.out.print("Enter new student name: ");
            String newName = scanner.nextLine();
            System.out.print("Enter new semester: ");
            int newSemester = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter new course (Java, .Net, C/C++): ");
            String newCourse = scanner.nextLine();

            studentManager.updateStudent(studentIdToUpdateOrDelete, newName, newSemester, newCourse);
            System.out.println("model.Student updated successfully.");
        } else if (choice.equalsIgnoreCase("D")) {
            boolean deleted = studentManager.deleteStudent(studentIdToUpdateOrDelete);
            if (deleted) {
                System.out.println("model.Student deleted successfully.");
            } else {
                System.out.println("model.Student with ID " + studentIdToUpdateOrDelete + " not found.");
            }
        } else {
            System.out.println("Invalid choice.");
        }
    }

    private void displayStudentReport() {
        List<Student> students = studentManager.getAllStudents();
        System.out.println("model.Student Report:");
        for (Student student : students) {
            int totalCourses = 0;
            for (Student s : students) {
                if (s.getName().equals(student.getName())) {
                    totalCourses++;
                }
            }
            System.out.println("Id: " + student.getId() + "Name: " + student.getName() + ", Course: " + student.getCourse() + ", Total Courses: " + totalCourses);
        }
    }

    private void displayAllStudents() {
//        List<model.Student> students = studentManager.getAllStudents();
        List<Student> students = this.students;
        if (students.isEmpty()) {
            System.out.println("No students found.");
        } else {
            System.out.println("All Students:");
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }

    public static List<Student> readStudentsFromFile(String filename) {
        List<Student> students = new ArrayList<>();

        try {
            File file = new File("C://Users/ACER/OneDrive/Máy tính/LAB/Week4/datastudent.txt");
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
            System.out.println("File not found: " + filename);
        }

        return students;
    }
}

