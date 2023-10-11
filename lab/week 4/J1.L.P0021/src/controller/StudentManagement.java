package controller;

import model.Student;
import service.StudentManager;
import validate.Validate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class StudentManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManager studentManager = new StudentManager();

        while (true) {
            System.out.println("----- WELCOME TO STUDENT MANAGEMENT -----");
            System.out.println("1. Create");
            System.out.println("2. Find and Sort");
            System.out.println("3. Update/Delete");
            System.out.println("4. Report");
            System.out.println("5. Exit");
            int choice = Integer.parseInt(Validate.checkIntInPut("^[1-5]$","- Please choose an option: ","- Invalid option. Please choose a valid option: "));

            switch (choice) {
                case 1:
                    studentManager.createStudent();
                    break;
                case 2:
                    System.out.print("Enter student name or part of the name: ");
                    String searchName = scanner.nextLine();
                    ArrayList<Student> result = studentManager.findStudentsByName(searchName);

                    if (result.isEmpty()) {
                        System.out.println("No students found.");
                    } else {
                        Collections.sort(result, (s1, s2) -> s1.getName().compareTo(s2.getName()));
                        System.out.println("Students found and sorted by name:");
                        for (Student student : result) {
                            System.out.println(student);
                        }
                    }
                    break;
                case 3:
                    System.out.print("Enter student ID to update/delete: ");
                    int studentId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Do you want to update (U) or delete (D) student?");
                    String updateOrDelete = scanner.nextLine().toUpperCase();

                    if (updateOrDelete.equals("U")) {
                        System.out.print("Enter new course (Java, .Net, C/C++): ");
                        String newCourse = scanner.nextLine();
                        studentManager.updateStudentCourse(studentId, newCourse);
                        System.out.println("Student updated successfully.");
                    } else if (updateOrDelete.equals("D")) {
                        studentManager.deleteStudent(studentId);
                        System.out.println("Student deleted successfully.");
                    } else {
                        System.out.println("Invalid choice.");
                    }
                    break;
                case 4:
                    ArrayList<Student> allStudents = studentManager.getAllStudents();
                    for (Student student : allStudents) {
                        System.out.println(student);
                    }
                    break;
                case 5:
                    System.out.println("Exiting the program.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please choose a valid option.");
            }
        }
    }
}
