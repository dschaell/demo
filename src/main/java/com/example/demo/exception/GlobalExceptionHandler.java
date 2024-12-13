package com.example.demo.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ResponseStatusException;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(InvalidFormatException.class)
    public ResponseEntity<String> handleInvalidFormatException(InvalidFormatException ex) {
        String errorMessage = "Invalid input: Please ensure all elements in the list are numeric.";
        logger.error(errorMessage, ex);
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(errorMessage);
    }

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<String> handleResponseStatusException(ResponseStatusException ex) {
        logger.error(ex.getReason(), ex);
        return ResponseEntity
                .status(ex.getStatusCode())
                .body(ex.getReason());
    }

    /*@ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleInvalidOrderException(IllegalArgumentException ex) {
        String errorMessage = "Invalid sort order";
        logger.error(errorMessage, ex);
        return ResponseEntity.badRequest().body("Invalid sort order: " + ex.getMessage());
    }*/
}

