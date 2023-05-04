package com.example.demo.controller;

import com.example.demo.dto.StudentDTO;
import com.example.demo.exseption.NotFoundException;
import com.example.demo.service.StudentService;
import com.example.demo.util.StandradResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/v1/login")
@CrossOrigin
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping(value = "/users")
    public ResponseEntity getStudent(HttpServletRequest httpServletRequest){
        StudentDTO studentDTO=studentService.getAllStudent();
       return new ResponseEntity(new StandradResponse("200", "Done", studentDTO), HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity setStudent(@RequestBody StudentDTO studentDTO){
        if (studentDTO.getId().trim().length()<=0 || !studentDTO.getId().matches("^[0-9]{9}[V]$")){
            return new ResponseEntity(new StandradResponse("400", "Done", "Student nic can't be accept.."), HttpStatus.OK);
        }
        studentService.addStudent(studentDTO);
        return new ResponseEntity(new StandradResponse("200", "Done", "done"), HttpStatus.OK);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateStudent(@RequestBody StudentDTO studentDTO){
        if (studentDTO.getId().trim().length() <= 0) {
            return new ResponseEntity(new StandradResponse("404", "Done", "No id provided to update"), HttpStatus.NOT_FOUND);
        }
        studentService.updateStudent(studentDTO);
        return new ResponseEntity(new StandradResponse("200", "Done", studentDTO), HttpStatus.OK);
    }

    @DeleteMapping(params = {"id"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteCustomer(@RequestParam String id) {
        if (null!=id || 0==id.trim().length()){
            return new ResponseEntity(new StandradResponse("404", "Done", "No id provided to delete"), HttpStatus.NOT_FOUND);
        }
        studentService.deleteStudent(id);
        return new ResponseEntity(new StandradResponse("200", "Done", null), HttpStatus.NO_CONTENT);
    }


}
