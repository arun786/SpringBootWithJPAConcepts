package com.arun.exception;

/**
 * Created by Adwiti on 5/16/2018.
 */
public class DataNotFoundException extends RuntimeException {
    public DataNotFoundException(String message) {
        super(message);
    }
}
