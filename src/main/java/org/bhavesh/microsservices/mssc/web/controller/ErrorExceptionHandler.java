package org.bhavesh.microsservices.mssc.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

import javax.validation.ConstraintViolationException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ErrorExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<List<String>> constraintErrorHandling(ConstraintViolationException constraintViolationException)
    {
       List<String> errorList=new ArrayList<>(constraintViolationException.getConstraintViolations().size());
       constraintViolationException.getConstraintViolations().forEach(error -> errorList.add(error.toString()));
       return new ResponseEntity<>(errorList, HttpStatus.BAD_REQUEST);
    }
}
