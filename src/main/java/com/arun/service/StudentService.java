package com.arun.service;

import com.arun.model.Student;

import java.util.List;

/**
 * Created by Adwiti on 5/16/2018.
 */
public interface StudentService {
    Student getStudentById(int id);

    Student updateStudent(Student student);

    List<Student> getAllStudents();
}
