package com.arun.service;

import com.arun.dto.CourseDto;
import com.arun.entity.CourseEntity;
import com.arun.model.Course;
import com.arun.repository.CourseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Adwiti on 5/26/2018.
 */
@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseDao courseDao;
    @Autowired
    private CourseDto courseDto;

    @Override
    public CourseEntity createACourse(Course course) {
        return courseDao.createACourse(courseDto.translateToCourseDto(course));
    }

    @Override
    public CourseEntity findById(long id) {
        return courseDao.findById(id);
    }

    @Override
    public void deleteById(long id) {
        courseDao.deleteById(id);
    }

    @Override
    public CourseEntity updateACourse(CourseEntity course) {
        return courseDao.updateACourse(course);
    }
}
