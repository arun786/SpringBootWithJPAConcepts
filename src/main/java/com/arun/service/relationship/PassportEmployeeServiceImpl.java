package com.arun.service.relationship;

import com.arun.model.EmployeePassport;
import com.arun.model.EmployeePassportResponse;
import com.arun.repository.relationship.PassportEmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Adwiti on 6/27/2018.
 */
@Service
public class PassportEmployeeServiceImpl implements PassportEmployeeService {

    @Autowired
    private PassportEmployeeDao passportEmployeeDao;

    @Override
    public void createPassportEmployeeRelation(EmployeePassport employeePassport) {
        passportEmployeeDao.createPassportEmployeeRelation(employeePassport);
    }

    @Override
    public void createPassportEmployeeRelationWithEntity(EmployeePassport employeePassport) {
        passportEmployeeDao.createPassportEmployeeRelationWithEntity(employeePassport);
    }

    @Override
    public EmployeePassportResponse getEmployeePassportDetails(Integer id) {
        return passportEmployeeDao.getEmployeePassportDetails(id);
    }
}
