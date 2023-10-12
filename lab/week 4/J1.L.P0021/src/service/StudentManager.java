package service;

import model.Student;
import validate.Validate;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class StudentManager {
    private ArrayList<Student> students = new ArrayList<>();
    private int studentIdCounter = 1;

    public void createStudent(String name, int semester, String courseName) {
        Student student = new Student(studentIdCounter, name, semester, courseName);
        students.add(student);
        studentIdCounter++;
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
                student.setCourseName(newCourse);
            }
        }
    }

    public void deleteStudent(int studentId) {
        students.removeIf(student -> student.getId() == studentId);
    }

    public ArrayList<Student> getAllStudents() {
        return students;
    }
}
