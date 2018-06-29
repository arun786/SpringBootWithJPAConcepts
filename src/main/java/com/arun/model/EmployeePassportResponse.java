package com.arun.model;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by Adwiti on 6/28/2018.
 */
@Getter
@Setter
public class EmployeePassportResponse {
    private Integer employeeId;
    private String employeeName;
    private Integer passportId;
    private String passportNumber;
}
