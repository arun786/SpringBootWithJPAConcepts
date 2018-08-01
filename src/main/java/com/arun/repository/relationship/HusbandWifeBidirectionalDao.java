package com.arun.repository.relationship;

import com.arun.model.onetoonebidirectional.Husband;
import com.arun.model.onetoonebidirectional.Wife;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Adwiti on 6/30/2018.
 */
@Repository
public class HusbandWifeBidirectionalDao {

    @PersistenceContext
    private EntityManager entityManager;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Transactional
    public void InsertHusbandWifeDetails(Husband husband, Wife wife) {
        entityManager.merge(wife);
       // entityManager.merge(husband);
    }
}
