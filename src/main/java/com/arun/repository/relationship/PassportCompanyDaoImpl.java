package com.arun.repository.relationship;

import com.arun.model.relationship.PassportRequest;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Created by Adwiti on 6/24/2018.
 */
@Repository
public class PassportCompanyDaoImpl implements PassportCompanyDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public int createNewPassport(PassportRequest passportRequest) {
        Query query = entityManager.createNativeQuery("insert into passport(number) values(?)");
        query.setParameter(1, passportRequest.getNumber());
        return query.executeUpdate();
    }
}
