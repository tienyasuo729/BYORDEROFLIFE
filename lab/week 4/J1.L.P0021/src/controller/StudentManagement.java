package controller;

import model.Student;
import service.StudentManager;
import validate.Validate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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
                    String name = Validate.checkIntInPut("^[a-zA-Z]+$", "- Enter student name: ", "- Invalid name, please re-enter the student name: ");

                    int semester = Integer.parseInt(Validate.checkIntInPut("^[0-9]+$", "- Enter semester: ", "- Invalid semester, please re-enter: "));

                    int choiceCourseName = Integer.parseInt(Validate.checkIntInPut("^[1-3]$", "- Choose a course:\n1/ Java\n2/ .Net\n3/ C/C++\n- Enter your choice: ", "- Invalid option. Please choose a valid option: "));
                    String courseName = null;
                    switch (choiceCourseName){
                        case 1:
                            courseName = "Java";
                            break;
                        case 2:
                            courseName = ".Net";
                            break;
                        case 3:
                            courseName = "C/C++";
                            break;
                    }
                    studentManager.createStudent(name, semester, courseName);
                    System.out.println("Student created successfully.");
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
                    int studentIdToEdit = Integer.parseInt(Validate.checkIntInPut("^[1-9]\\d+$"," - Enter student ID to update/delete: ","- ID is invalid or does not exist, please re-enter: "));
                    System.out.println("Do you want to update (1) or delete (2) student?");
                    String updateOrDelete = scanner.nextLine().toUpperCase();

                    if (updateOrDelete.equals("U")) {
                        int choiceNewCourseName = Integer.parseInt(Validate.checkIntInPut("^[1-3]$", "- Choose a new course:\n1/ Java\n2/ .Net\n3/ C/C++\n- Enter your choice: ", "- Invalid option. Please choose a valid option: "));
                        String newCourse = null;
                        switch (choiceNewCourseName){
                            case 1:
                                courseName = "Java";
                                break;
                            case 2:
                                courseName = ".Net";
                                break;
                            case 3:
                                courseName = "C/C++";
                                break;
                        }
                        studentManager.updateStudentCourse(studentIdToEdit, newCourse);
                        System.out.println("Student updated successfully.");
                    } else if (updateOrDelete.equals("D")) {
                        studentManager.deleteStudent(studentIdToEdit);
                        System.out.println("Student deleted successfully.");
                    } else {
                        System.out.println("Invalid choice.");
                    }
                    break;
                case 4:
                    List<Student> allStudents = studentManager.getAllStudents();
                    for (Student student : allStudents) {
                        System.out.println(student);
                    }
                    break;
                case 5:
                    System.out.println("Exiting the program.");
                    scanner.close();
                    System.exit(0);
            }
        }
    }
}
