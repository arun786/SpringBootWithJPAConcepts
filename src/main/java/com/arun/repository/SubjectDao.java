package com.arun.repository;

import com.arun.entity.Subject;

import java.util.List;

/**
 * Created by Adwiti on 6/21/2018.
 */
public interface SubjectDao {
    List<Subject> getAllSubjects();

    List<Subject> getDetailsOfSubject(String authorName);

    Subject getDetailsOfSubjectBasedOnIdAndAuthor(String authorName, int id);
}
