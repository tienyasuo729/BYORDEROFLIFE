package service.impl;

import model.Student;
import repository.IStudentRepository;
import repository.impl.StudentRepository;
import service.IStudentService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentService implements IStudentService {
    private IStudentRepository iStudentRepository = new StudentRepository();


    @Override
    public Map<String, String> save(Student student) {
        Map<String, String>map = new HashMap<>();
        if(student.getName().equals("")) {
            map.put("name","Tên không được để trống");
        } else if(!student.getName().matches("^[a-zA-Z ]+$")) {
            map.put("name","Tên không hợp lệ");
        }

        if(map.isEmpty()) {
            iStudentRepository.save(student);
        }
        return map;
    }

    @Override
    public List<Student> getAll() {
        List<Student> studentList = this.iStudentRepository.getAll();
        return studentList;
    }

    @Override
    public Student findById(int id) {
        Student student = iStudentRepository.findById(id);
        return student;
    }

    @Override
    public void deleteById(int id) {
        iStudentRepository.deleteById(id);
    }
}
