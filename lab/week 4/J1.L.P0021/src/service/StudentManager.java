package service;

import model.Student;
import validate.Validate;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class StudentManager {
    private static Scanner scanner = new Scanner(System.in);
    private List<Student> students = new ArrayList<>();

    private String checkStudentId() {
        String studentId;
        Boolean
        System.out.print("- Enter student ID: ");
        do {
            studentId = scanner.nextLine().trim();
            for (Student student: students) {
                if (!studentId.equals(student.getId())){
                    break;
                }
            }
        }while (true);

        return "";
    }

    public void createStudent() {
        String name = Validate.checkIntInPut("^[a-zA-Z]+$", "- Enter student name: ", "- Invalid name, please re-enter the student name: ");
        int semester = Integer.parseInt(Validate.checkIntInPut("^[0-9]+$", "- Enter semester: ", "- Invalid semester, please re-enter: "));
        String courseName = Validate.checkIntInPut("^[1-3]$", "- Choose a course:\n1/ Java\n2/ .Net\n3/ C/C++\n- Enter your choice: ", "- Invalid option. Please choose a valid option: ");
        Student student = new Student(studentIdCounter, name, semester, courseName);
        students.add(student);
        studentIdCounter++;
        System.out.println("Student created successfully.");
    }

    public ArrayList<Student> findStudentsByName(String searchName) {
        ArrayList<Student> result = new ArrayList<>();

        for (Student student : students) {
            if (student.getName().contains(searchName)) {
                result.add(student);
            }
        }

        return result;
    }

    public void updateStudentCourse(int studentId, String newCourse) {
        for (Student student : students) {
            if (student.getId() == studentId) {
                student.setCourse(newCourse);
            }
        }
    }

    public void deleteStudent(int studentId) {
        students.removeIf(student -> student.getId() == studentId);
    }

    public List<Student> getAllStudents() {
        return students;
    }
}
