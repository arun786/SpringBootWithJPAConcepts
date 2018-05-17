package com.arun.service;

import com.arun.model.Student;
import com.arun.repository.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
