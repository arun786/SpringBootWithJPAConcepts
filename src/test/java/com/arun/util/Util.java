package com.arun.util;

import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * Created by Adwiti on 7/5/2018.
 */
public class Util {

    public void readAFile() throws FileNotFoundException {
        File file = ResourceUtils.getFile(this.getClass().getResource("/college/RetrieveCollegeDetailsBasedOnId.json"));
    }
}
