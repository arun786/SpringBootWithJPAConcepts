package com.arun.repository;

import com.arun.entity.College;

import java.util.List;

/**
 * Created by Adwiti on 6/22/2018.
 */
public interface CollegeDao {
    College getCollege(int id);
    List<College> getCollegeBasedOnRanking(int ranking);
    List<College> getAllCollege();
    int updateTimeStampBatchProcess();
}
