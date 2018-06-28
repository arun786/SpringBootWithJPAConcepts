package com.arun.controller;

import com.arun.model.EmployeePassport;
import com.arun.service.relationship.PassportEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Adwiti on 6/26/2018.
 */
@RestController
public class PassportEmployeeController {

    @Autowired
    private PassportEmployeeService passportEmployeeService;

    @PostMapping("/employee/v1/passport")
    public ResponseEntity<HttpStatus> createPassportEmployeeRelation(@RequestBody EmployeePassport employeePassport) {
        passportEmployeeService.createPassportEmployeeRelation(employeePassport);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/employee/v1/passport/entity")
    public ResponseEntity<HttpStatus> createPassportEmployeeRelationWithEntity(@RequestBody EmployeePassport employeePassport) {
        passportEmployeeService.createPassportEmployeeRelationWithEntity(employeePassport);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
