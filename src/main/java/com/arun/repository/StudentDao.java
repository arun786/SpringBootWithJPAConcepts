package com.arun.repository;

import com.arun.model.Student;

/**
 * Created by Adwiti on 5/16/2018.
 */
public interface StudentDao {
    Student getStudentById(int id);
}
