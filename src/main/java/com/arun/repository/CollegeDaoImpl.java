package com.arun.repository;

import com.arun.entity.College;
import com.arun.exception.DataNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Adwiti on 6/22/2018.
 */
@Repository
public class CollegeDaoImpl implements CollegeDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public College getCollege(int id) {
        Query query = entityManager.createNativeQuery("select * from college c where c.id = ?", College.class);
        query.setParameter(1, id);

        List resultList = query.getResultList();
        if (!resultList.isEmpty()) {
            return (College) query.getResultList().get(0);
        }
        throw new DataNotFoundException("DATA_NOT_FOUND");
    }

    @Override
    public List<College> getCollegeBasedOnRanking(int ranking) {
        Query query = entityManager.createNativeQuery("select * from college c where c.ranking > ?", College.class);
        query.setParameter(1, ranking);
        return query.getResultList();
    }

    @Override
    public List<College> getAllCollege() {
        return null;
    }

    @Override
    @Transactional
    public int updateTimeStampBatchProcess() {
        Query query = entityManager.createNativeQuery("update college set update_Time_Stamp=sysdate()");
        return query.executeUpdate();
    }
}
