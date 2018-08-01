package com.arun.controller;

import com.arun.entity.College;
import com.arun.service.CollegeService;
import com.arun.util.Util;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.modules.junit4.PowerMockRunnerDelegate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.FileNotFoundException;

import static org.mockito.Mockito.when;

/**
 * Created by Adwiti on 7/4/2018.
 */


@RunWith(PowerMockRunner.class)
@PrepareForTest(value = CollegeController.class)
@PowerMockRunnerDelegate(SpringRunner.class)
public class TestCollegeController {
    @InjectMocks
    private CollegeController collegeController;

    @Mock
    private CollegeService collegeService;
    @Mock
    Util util;

    @Test
    public void testGetCollegeById() throws FileNotFoundException {
        int id = 1;
        College college = new College();
        when(collegeService.getCollege(id)).thenReturn(college);
        ResponseEntity<College> collegeById = collegeController.getCollegeById(id);
        util.readAFile();


    }
}
