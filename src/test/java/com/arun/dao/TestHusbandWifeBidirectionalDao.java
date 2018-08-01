package com.arun.dao;

import com.arun.model.onetoonebidirectional.Husband;
import com.arun.model.onetoonebidirectional.Wife;
import com.arun.repository.relationship.HusbandWifeBidirectionalDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Adwiti on 6/30/2018.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestHusbandWifeBidirectionalDao {

    @Autowired
    private HusbandWifeBidirectionalDao husbandWifeBidirectionalDao;

    @Test
    public void testHusbandWifeBidirectionalDao() {
        Wife wife = new Wife("Pushpa", "23");
        Husband husband = new Husband("Arun", "27", wife);
        husbandWifeBidirectionalDao.InsertHusbandWifeDetails(husband, wife);
    }
}
