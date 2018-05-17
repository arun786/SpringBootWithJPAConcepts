package com.arun.controller;

import com.arun.model.Student;
import com.arun.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Adwiti on 5/16/2018.
 */
@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/student/v1/students/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable(value = "id") Integer id) {
        Student studentById = studentService.getStudentById(id);
        ResponseEntity<Student> response = new ResponseEntity<Student>(studentById, HttpStatus.OK);
        return response;
    }
}
