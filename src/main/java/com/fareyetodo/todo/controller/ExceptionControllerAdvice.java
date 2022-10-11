package com.fareyetodo.todo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionControllerAdvice {
    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<String> handleException(MethodArgumentNotValidException ex){
        return new ResponseEntity<>("Duplicate Title", HttpStatus.BAD_REQUEST);
    }
}