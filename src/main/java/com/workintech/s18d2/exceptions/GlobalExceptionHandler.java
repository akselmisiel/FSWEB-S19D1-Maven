package com.workintech.s18d2.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<PlantErrorResponse> handleException(PlantException exception) {
        PlantErrorResponse plantErrorResponse = new PlantErrorResponse(exception.getHttpStatus(), exception.getMessage(), LocalDateTime.now());
        return new ResponseEntity<>(plantErrorResponse, exception.getHttpStatus());
    }

    @ExceptionHandler
    public ResponseEntity<PlantErrorResponse> handleException(Exception exception) {
        PlantErrorResponse plantErrorResponse = new PlantErrorResponse(HttpStatus.BAD_REQUEST, exception.getMessage(), LocalDateTime.now());
        return new ResponseEntity<>(plantErrorResponse, HttpStatus.BAD_REQUEST);
    }
}
