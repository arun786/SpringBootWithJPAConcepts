package com.arun.repository;

import com.arun.constants.Constants;
import com.arun.exception.DataNotFoundException;
import com.arun.model.Student;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Adwiti on 5/16/2018.
 */

@Repository
@Transactional
public class StudentDaoImpl implements StudentDao {
    /**
     * Connect to the database
     */
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Student getStudentById(int id) {
        Student student = entityManager.find(Student.class, id);
        if (null == student) {
            throw new DataNotFoundException(Constants.NO_DATA_NOT_FOUND);
        }
        return student;
    }

    @Override
    public List<Student> getAllStudents() {
        Query query = entityManager.createNamedQuery("Get_All_Students");
        return query.getResultList();
    }

    @Override
    public Student updateStudent(Student student) {
        return entityManager.merge(student);
    }
}
