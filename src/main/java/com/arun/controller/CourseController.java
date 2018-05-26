package com.arun.controller;

import com.arun.entity.CourseEntity;
import com.arun.model.Course;
import com.arun.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Adwiti on 5/26/2018.
 */
@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping("/course/v1/courses")
    public ResponseEntity<CourseEntity> createACourse(@RequestBody Course course) {
        CourseEntity aCourse = courseService.createACourse(course);
        return new ResponseEntity<>(aCourse, HttpStatus.OK);
    }
}
