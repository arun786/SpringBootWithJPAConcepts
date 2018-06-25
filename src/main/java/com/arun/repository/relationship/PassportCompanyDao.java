package com.arun.repository.relationship;

import com.arun.model.relationship.PassportRequest;

/**
 * Created by Adwiti on 6/24/2018.
 */
public interface PassportCompanyDao {
    public int createNewPassport(PassportRequest passportRequest);
}
