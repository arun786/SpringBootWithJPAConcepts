package com.arun.service;

import com.arun.entity.Student;
import com.arun.repository.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Adwiti on 5/16/2018.
 */

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDao studentDao;

    @Override
    public Student getStudentById(int id) {
        return studentDao.getStudentById(id);
    }

    @Override
    public Student getStudentByIdUsingJpaRepo(int id) {
        return studentDao.getStudentByIdUsingJpaRepo(id);
    }

    @Override
    public Student updateStudent(Student student) {
        return studentDao.updateStudent(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentDao.getAllStudents();
    }

    @Override
    public List<Student> getAllStudentsUsingJpa() {
        return studentDao.getAllStudentsUsingJpaRepo();
    }

    @Override
    public Student updateStudentByJpa(Student student) {
        return studentDao.updateStudentByJpa(student);
    }

    @Override
    public void deleteAStudentById(int id) {
        studentDao.deleteAStudentById(id);
    }

    @Override
    public void deleteAStudentByIdUsingJpa(int id) {
        studentDao.deleteAStudentByIdUsingJpa(id);
    }
}
