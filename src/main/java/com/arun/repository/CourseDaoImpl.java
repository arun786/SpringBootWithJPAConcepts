package com.arun.repository;

import com.arun.entity.CourseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Adwiti on 5/26/2018.
 */
@Repository
@Transactional
public class CourseDaoImpl implements CourseDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public CourseEntity createACourse(CourseEntity courseEntity) {
        return entityManager.merge(courseEntity);
    }
}
