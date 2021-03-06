package com.arun.service;

import com.arun.entity.Subject;

import java.util.List;

/**
 * Created by Adwiti on 6/21/2018.
 */
public interface SubjectService {
    List<Subject> getAllSubjects();

    List<Subject> getDetailsOfSubject(String authorName);

    Subject getDetailsOfSubjectBasedOnIdAndAuthor(String authorName, int id);
}
