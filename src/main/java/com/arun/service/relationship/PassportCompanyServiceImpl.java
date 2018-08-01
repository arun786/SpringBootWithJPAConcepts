package com.arun.service.relationship;

import com.arun.model.relationship.PassportRequest;
import com.arun.repository.relationship.PassportCompanyDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Adwiti on 6/24/2018.
 */
@Service
public class PassportCompanyServiceImpl implements PassportCompanyService {
    @Autowired
    PassportCompanyDao passportCompanyDao;

    @Override
    public int createNewPassport(PassportRequest passportRequest) {
        return passportCompanyDao.createNewPassport(passportRequest);
        }
        }
