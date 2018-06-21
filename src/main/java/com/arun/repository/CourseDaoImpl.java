package com.arun.repository;

import com.arun.constants.Constants;
import com.arun.entity.CourseEntity;
import com.arun.exception.DataNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

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

    @Override
    public void updateACourse(CourseEntity course) {
        long id = course.getId();
        CourseEntity courseEntity = findById(id);
        courseEntity.setName(course.getName());
        entityManager.merge(courseEntity);
    }

    @Override
    public CourseEntity findById(long id) {
        CourseEntity course = entityManager.find(CourseEntity.class, id);
        if (null == course) {
            throw new DataNotFoundException(Constants.NO_DATA_NOT_FOUND);
        }
        return course;
    }

    /**
     * Delete @Transactional is required
     *
     * @param id
     */
    @Override
    public void deleteById(long id) {
        CourseEntity course = findById(id);
        entityManager.remove(course);
    }

    @Override
    public List<CourseEntity> findAllCourseusingJpql() {
        TypedQuery<CourseEntity> typedCourses = entityManager.createQuery("select c from CourseEntity c", CourseEntity.class);
        return typedCourses.getResultList();
    }

}
