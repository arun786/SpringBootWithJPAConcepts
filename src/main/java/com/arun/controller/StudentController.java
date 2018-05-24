package com.arun.controller;

import com.arun.model.Student;
import com.arun.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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


    @PutMapping("/student/v1/students")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student) {
        Student student1 = studentService.updateStudent(student);
        ResponseEntity<Student> response = new ResponseEntity<Student>(student1, HttpStatus.OK);
        return response;
    }


    @GetMapping("/student/v1/students/all")
    public ResponseEntity<List<Student>> getAllStudentUsingEntityManager() {
        List<Student> allStudents = studentService.getAllStudents();
        return new ResponseEntity<>(allStudents, HttpStatus.OK);
    }

    @GetMapping("/student/v1/students/jpa/all")
    public ResponseEntity<List<Student>> getAllStudentUsingJpa() {
        List<Student> allStudentsUsingJpa = studentService.getAllStudentsUsingJpa();
        return new ResponseEntity<>(allStudentsUsingJpa, HttpStatus.OK);
    }

    @GetMapping("/student/v1/students/jpa/{id}")
    public ResponseEntity<Student> getStudentByIdUsingJpaRepo(
            @PathVariable(name = "id") int id) {

        Student studentByIdUsingJpaRepo = studentService.getStudentByIdUsingJpaRepo(id);
        return new ResponseEntity<>(studentByIdUsingJpaRepo, HttpStatus.OK);
    }


    @PostMapping("/student/v1/students/jpa")
    public ResponseEntity<Student> updateStudentByJpa(@RequestBody Student student) {
        Student updateStudentByJpa = studentService.updateStudentByJpa(student);
        return new ResponseEntity<>(updateStudentByJpa, HttpStatus.OK);
    }
}
