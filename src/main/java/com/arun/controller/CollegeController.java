package com.arun.controller;

import com.arun.entity.College;
import com.arun.rc.config.annotation.RsLogging;
import com.arun.rc.config.annotation.RsTimeTraker;
import com.arun.service.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Adwiti on 6/22/2018.
 */
@RestController
public class CollegeController {
    @Autowired
    private CollegeService collegeService;

    @RsLogging
    @RsTimeTraker
    @GetMapping("/college/v1/colleges/{id}")
    public ResponseEntity<College> getCollegeById(@PathVariable(value = "id") Integer id) {
        College college = collegeService.getCollege(id);
        return new ResponseEntity<>(college, HttpStatus.OK);
    }

    @GetMapping("/college/v1/colleges/ranking/{ranking}")
    public ResponseEntity<List<College>> getCollegeByRanking(@PathVariable(value = "ranking") Integer ranking) {
        List<College> college = collegeService.getCollegeBasedOnRanking(ranking);
        return new ResponseEntity<>(college, HttpStatus.OK);
    }

    @GetMapping("/college/v1/colleges/batch")
    public ResponseEntity<Integer> updateTimeStampBatchProcess(){
        int rowsUpdated = collegeService.updateTimeStampBatchProcess();
        return new ResponseEntity<>(rowsUpdated, HttpStatus.OK);
    }

}
