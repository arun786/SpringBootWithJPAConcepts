package com.arun.exception;

import com.arun.constants.Constants;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Created by Adwiti on 5/16/2018.
 */
@RestController
@ControllerAdvice
public class GenericDataException extends ResponseEntityExceptionHandler {

    @ExceptionHandler(DataNotFoundException.class)
    public final ResponseEntity<ExceptionResponse> handleDataNotFoundException(DataNotFoundException e, WebRequest w) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(Constants.DATA_NOT_FOUND, e.getMessage());
        ResponseEntity<ExceptionResponse> response = new ResponseEntity<>(exceptionResponse, HttpStatus.OK);
        return response;
    }
}
