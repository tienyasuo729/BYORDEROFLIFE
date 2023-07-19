package com.codegym.demo_springdatajpa_a10.dto;

import com.codegym.demo_springdatajpa_a10.model.ClassRoom;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class StudentDto implements Validator {
//    @NotEmpty(message = "Not Empty")
//    @Pattern(regexp = "^[A-Z]\\w+$",message = "Not matches regex")
    private String name;
    private int gender;
    private ClassRoom classRoom;


    public StudentDto() {
    }

    public StudentDto(String name, int gender, ClassRoom classRoom) {
        this.name = name;
        this.gender = gender;
        this.classRoom = classRoom;
    }

    public ClassRoom getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(ClassRoom classRoom) {
        this.classRoom = classRoom;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
       StudentDto studentDto = (StudentDto) target;
       if (studentDto.getName().isEmpty()){
           errors.rejectValue("name",null,"Khong duoc de trong");
       }else if (!studentDto.getName().matches("^[A-Z]\\w++$")){
           errors.rejectValue("name",null,"Khong dung dinh dang");
       }

    }
}
