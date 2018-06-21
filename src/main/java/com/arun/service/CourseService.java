package com.arun.service;

import com.arun.entity.CourseEntity;
import com.arun.model.Course;

import java.util.List;

/**
 * Created by Adwiti on 5/26/2018.
 */
public interface CourseService {
    CourseEntity createACourse(Course course);

    CourseEntity findById(long id);

    void deleteById(long id);

    void updateACourse(CourseEntity course);

    List<CourseEntity> findAllCourseusingJpql();
}
