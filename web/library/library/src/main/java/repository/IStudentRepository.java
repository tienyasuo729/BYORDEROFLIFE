package repository;

import model.Student;

import java.util.List;

public interface IStudentRepository {
    List<Student> Find_id_and_name_of_student();
}
