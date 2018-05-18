package com.arun.repository;

import com.arun.constants.Constants;
import com.arun.exception.DataNotFoundException;
import com.arun.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

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

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student getStudentById(int id) {
        Student student = entityManager.find(Student.class, id);
        if (null == student) {
            throw new DataNotFoundException(Constants.NO_DATA_NOT_FOUND);
        }
        return student;
    }

    @Override
    public Student getStudentByIdUsingJpaRepo(int id) {
        Optional<Student> byId = studentRepository.findById(id);
        if (byId.isPresent()) {
            return byId.get();
        } else {
            throw new DataNotFoundException(Constants.NO_DATA_NOT_FOUND);
        }
    }

    @Override
    public List<Student> getAllStudents() {
        Query query = entityManager.createNamedQuery("Get_All_Students");
        return query.getResultList();
    }

    @Override
    public List<Student> getAllStudentsUsingJpaRepo() {
        return null;
    }

    @Override
    public Student updateStudent(Student student) {
        return entityManager.merge(student);
    }
}
