package com.arun.repository;

import com.arun.entity.CourseEntity;

import java.util.List;

/**
 * Created by Adwiti on 5/26/2018.
 */
public interface CourseDao {

    CourseEntity createACourse(CourseEntity courseEntity);

    void updateACourse(CourseEntity course);

    CourseEntity findById(long id);

    void deleteById(long id);

    List<CourseEntity> findAllCourseusingJpql();
}
