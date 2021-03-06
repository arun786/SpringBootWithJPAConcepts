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
    public List<Subject> getAllSubjects() {
        return subjectDao.getAllSubjects();
    }

    @Override
    public List<Subject> getDetailsOfSubject(String authorName) {
        return subjectDao.getDetailsOfSubject(authorName);
    }

    @Override
    public Subject getDetailsOfSubjectBasedOnIdAndAuthor(String authorName, int id) {
        return subjectDao.getDetailsOfSubjectBasedOnIdAndAuthor(authorName, id);
    }
}
