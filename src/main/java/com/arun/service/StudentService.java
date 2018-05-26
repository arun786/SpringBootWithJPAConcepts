package com.arun.service;

import com.arun.entity.Student;

import java.util.List;

/**
 * Created by Adwiti on 5/16/2018.
 */
public interface StudentService {
    Student getStudentById(int id);

    Student getStudentByIdUsingJpaRepo(int id);

    Student updateStudent(Student student);

    List<Student> getAllStudents();

    List<Student> getAllStudentsUsingJpa();

    Student updateStudentByJpa(Student student);

    void deleteAStudentById(int id);

    void deleteAStudentByIdUsingJpa(int id);
}
