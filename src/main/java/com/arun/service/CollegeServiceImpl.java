package com.arun.service;

import com.arun.entity.College;
import com.arun.repository.CollegeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Adwiti on 6/22/2018.
 */
@Service
public class CollegeServiceImpl implements CollegeService {

    @Autowired
    private CollegeDao collegeDao;

    @Override
    public College getCollege(int id) {
        return collegeDao.getCollege(id);
    }

    @Override
    public List<College> getCollegeBasedOnRanking(int ranking) {
        return collegeDao.getCollegeBasedOnRanking(ranking);
    }

    @Override
    public List<College> getAllCollege() {
        return null;
    }
}
