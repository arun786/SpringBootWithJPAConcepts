package com.arun.controller;

import com.arun.entity.Subject;
import com.arun.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Adwiti on 6/21/2018.
 */
@RestController
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @GetMapping("/subject/v1/subjects")
    public ResponseEntity<List<Subject>> getAllSubjects() {
        return new ResponseEntity<>(subjectService.getAllSubjects(), HttpStatus.OK);
    }


    @GetMapping("/subject/v1/subject/{authorname}")
    public ResponseEntity<List<Subject>> getSubjectBasedOnAuthor(@PathVariable(value = "authorname") String authorname) {
        return new ResponseEntity<>(subjectService.getDetailsOfSubject(authorname), HttpStatus.OK);
    }
}
