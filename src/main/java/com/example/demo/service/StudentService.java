package com.example.demo.service;

import com.example.demo.dto.StudentDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class StudentService {
    public void addStudent(StudentDTO studentDTO){

    }

    public void updateStudent(StudentDTO studentDTO){

    }

    public StudentDTO getAllStudent(){
    return new StudentDTO();
    }

    public void deleteStudent(String id){

    }


}
