package com.arun.repository;

import com.arun.entity.CourseEntity;

/**
 * Created by Adwiti on 5/26/2018.
 */
public interface CourseDao {

    CourseEntity createACourse(CourseEntity courseEntity);

    CourseEntity findById(long id);

    void deleteById(long id);
}
