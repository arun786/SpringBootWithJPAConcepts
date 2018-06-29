package com.arun.repository.relationship;

import com.arun.model.EmployeePassport;
import com.arun.model.EmployeePassportResponse;

/**
 * Created by Adwiti on 6/26/2018.
 */
public interface PassportEmployeeDao {
    void createPassportEmployeeRelation(EmployeePassport employeePassport);

    void createPassportEmployeeRelationWithEntity(EmployeePassport employeePassport);

    EmployeePassportResponse getEmployeePassportDetails(Integer id);
}
