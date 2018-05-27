package com.arun.repository;

import com.arun.entity.CourseEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

/**
 * Created by Adwiti on 5/26/2018.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CourseRepositoryTest {

    @Autowired
    private CourseDao courseDaoImpl;

    @Test
    public void findById() {
        CourseEntity course = courseDaoImpl.findById(1);
        assertEquals(course.getName(), "chemistry");
    }
}
