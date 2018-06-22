package com.arun.repository;

import com.arun.entity.Subject;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Adwiti on 6/21/2018.
 */
@Repository
public class SubjectDaoImpl implements SubjectDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Subject> getAllSubjects() {
        Query query = entityManager.createNamedQuery("Get_All_Subject", Subject.class);
        return query.getResultList();
    }

    @Override
    public List<Subject> getDetailsOfSubject(String authorName) {
        Query query = entityManager.createNamedQuery("Get_Books_By_Author", Subject.class);
        query.setParameter("author",authorName);
        return query.getResultList();
    }
}
