package com.arun.service;

import com.arun.entity.Subject;
import com.arun.repository.SubjectDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Adwiti on 6/21/2018.
 */
@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectDao subjectDao;

    @Override
    public List<Subject> getAllStudents() {
        return subjectDao.getAllStudents();
    }
}
