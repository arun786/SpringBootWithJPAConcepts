package com.arun.service.relationship;

import com.arun.model.EmployeePassport;
import com.arun.model.EmployeePassportResponse;

/**
 * Created by Adwiti on 6/27/2018.
 */
public interface PassportEmployeeService {
    public void createPassportEmployeeRelation(EmployeePassport employeePassport);

    public void createPassportEmployeeRelationWithEntity(EmployeePassport employeePassport);

    public EmployeePassportResponse getEmployeePassportDetails(Integer id);
}
