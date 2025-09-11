package com.dev.Lyceum.API.infra.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleUserNotFoundEception(EntityNotFoundException exception) {
        Map<String, String> response = new HashMap<>();
        response.put("Error:", exception.getMessage());
        response.put("Message:", "Please verify the id given and try again");

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
