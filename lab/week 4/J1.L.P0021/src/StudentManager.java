import model.Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StudentManager {
    private List<Student> studentList = new ArrayList<>();
    private int studentId = 1;

    public void createStudent(String name, int semester, String course) {
        Student student = new Student(studentId++, name, semester, course);
        studentList.add(student);
    }

    public List<Student> findAndSortStudents(String searchName) {
        List<Student> searchResults = new ArrayList<>();
        for (Student student : studentList) {
            if (student.getName().toLowerCase().contains(searchName.toLowerCase())) {
                searchResults.add(student);
            }
        }
        Collections.sort(searchResults, Comparator.comparing(Student::getName));
        return searchResults;
    }

    public void updateStudent(int studentIdToUpdate, String newName, int newSemester, String newCourse) {
        for (Student student : studentList) {
            if (student.getId() == studentIdToUpdate) {
                student.setName(newName);
                student.setSemester(newSemester);
                student.setCourse(newCourse);
                break;
            }
        }
    }

    public boolean deleteStudent(int studentIdToDelete) {
        return studentList.removeIf(student -> student.getId() == studentIdToDelete);
    }

    public List<Student> getAllStudents() {
        return studentList;
    }
}
