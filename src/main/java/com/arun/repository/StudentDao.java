package com.arun.repository;

import com.arun.model.Student;

import java.util.List;

/**
 * Created by Adwiti on 5/16/2018.
 */
public interface StudentDao {
    Student getStudentById(int id);

    Student getStudentByIdUsingJpaRepo(int id);

    List<Student> getAllStudents();

    List<Student> getAllStudentsUsingJpaRepo();

    Student updateStudent(Student student);
}
