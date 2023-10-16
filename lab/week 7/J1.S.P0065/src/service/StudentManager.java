package service;

import model.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class StudentManager {
    private List<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);
    }

    public List<Student> getStudents() {
        return students;
    }

    public void classifyStudents() {
        for (Student student : students) {
            double avg = (student.getMath() + student.getChemistry() + student.getPhysics()) / 3;
            student.setAverage(avg);

            if (avg > 7.5) {
                student.setType("A");
            } else if (avg >= 6 && avg <= 7.5) {
                student.setType("B");
            } else if (avg >= 4 && avg < 6) {
                student.setType("C");
            } else {
                student.setType("D");
            }
        }
    }

    public HashMap<String, Double> getTypeStatistics() {
        HashMap<String, Double> typeStatistics = new HashMap<>();
        int totalStudents = students.size();

        int typeACount = 0;
        int typeBCount = 0;
        int typeCCount = 0;
        int typeDCount = 0;

        for (Student student : students) {
            switch (student.getType()) {
                case "A":
                    typeACount++;
                    break;
                case "B":
                    typeBCount++;
                    break;
                case "C":
                    typeCCount++;
                    break;
                case "D":
                    typeDCount++;
                    break;
            }
        }

        typeStatistics.put("A", (double) (typeACount * 100) / totalStudents);
        typeStatistics.put("B", (double) (typeBCount * 100) / totalStudents);
        typeStatistics.put("C", (double) (typeCCount * 100) / totalStudents);
        typeStatistics.put("D", (double) (typeDCount * 100) / totalStudents);

        return typeStatistics;
    }
}
