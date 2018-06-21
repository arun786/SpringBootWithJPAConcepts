package com.arun.controller;

import com.arun.entity.CourseEntity;
import com.arun.model.Course;
import com.arun.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/course/v1/courses/{id}")
    public ResponseEntity<CourseEntity> findById(@PathVariable(value = "id") Long id) {
        CourseEntity courseEntity = courseService.findById(id);
        return new ResponseEntity<>(courseEntity, HttpStatus.OK);
    }

    @DeleteMapping("/course/v1/courses/{id}")
    public ResponseEntity<String> deleteById(@PathVariable(value = "id") long id) {
        courseService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/course/v1/courses")
    public ResponseEntity<HttpStatus> updateACourse(@RequestBody CourseEntity course) {
        courseService.updateACourse(course);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/course/v1/courses/jpql")
    public ResponseEntity<List<CourseEntity>> getAllCoursesByJPQL() {
        List<CourseEntity> courses = courseService.findAllCourseusingJpql();
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }
}
