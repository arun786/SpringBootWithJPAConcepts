package com.arun.dto;

import com.arun.entity.CourseEntity;
import com.arun.model.Course;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Adwiti on 5/26/2018.
 */
@Configuration
public class CourseDto {

    public CourseEntity translateToCourseDto(Course course) {
        CourseEntity courseEntity = new CourseEntity();
        courseEntity.setName(course.getName());
        return courseEntity;
    }
}
