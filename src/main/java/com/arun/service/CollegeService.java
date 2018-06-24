package com.arun.service;

import com.arun.entity.College;

import java.util.List;

/**
 * Created by Adwiti on 6/22/2018.
 */
public interface CollegeService {
    College getCollege(int id);
    List<College> getCollegeBasedOnRanking(int ranking);
    List<College> getAllCollege();
    int updateTimeStampBatchProcess();
}
