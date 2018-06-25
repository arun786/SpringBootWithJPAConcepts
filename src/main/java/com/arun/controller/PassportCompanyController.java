package com.arun.controller;

import com.arun.model.relationship.PassportRequest;
import com.arun.service.relationship.PassportCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Adwiti on 6/24/2018.
 */
@RestController
public class PassportCompanyController {

    @Autowired
    private PassportCompanyService passportCompanyService;

    @PostMapping("/passport/v1/passports")
    public ResponseEntity<Integer> createPassport(@RequestBody PassportRequest passportRequest) {
        int newPassport = passportCompanyService.createNewPassport(passportRequest);
        return new ResponseEntity<>(newPassport, HttpStatus.OK);
    }

}
