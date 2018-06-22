package com.arun.repository;

import com.arun.entity.Subject;
import com.arun.exception.DataNotFoundException;
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
        query.setParameter("author", authorName);
        return query.getResultList();
    }

    @Override
    public Subject getDetailsOfSubjectBasedOnIdAndAuthor(String authorName, int id) {
        Query query = entityManager.createNamedQuery("Get_Book_Based_On_Author_And_Id", Subject.class);
        query.setParameter("author", authorName);
        query.setParameter("id", id);
        List resultList = query.getResultList();
        if (!resultList.isEmpty()) {
            return (Subject) resultList.get(0);
        }
        throw new DataNotFoundException("Data_Not_Found");
    }
}
