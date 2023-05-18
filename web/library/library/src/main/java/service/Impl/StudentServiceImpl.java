package service.Impl;

import model.Student;
import repository.impl.StudentRepositoryImpl;
import service.IStudentService;

import java.util.List;

public class StudentServiceImpl implements IStudentService {
    private StudentRepositoryImpl studentRepository = new StudentRepositoryImpl();
    @Override
    public List<Student> Find_id_and_name_of_student() {
        return studentRepository.Find_id_and_name_of_student();
    }
}
