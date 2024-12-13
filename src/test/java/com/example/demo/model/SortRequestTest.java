package com.example.demo.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SortRequestTest {

    private Validator validator;

    @BeforeEach
    void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void testValidSortRequest() {
        SortRequest sortRequest = new SortRequest();
        sortRequest.setNumbers(List.of(1.0, 2.0, 3.0));

        Set<ConstraintViolation<SortRequest>> violations = validator.validate(sortRequest);

        assertEquals(0, violations.size(), "There should be no validation errors for a valid request.");
    }

    @Test
    void testNullNumbers() {
        SortRequest sortRequest = new SortRequest();
        sortRequest.setNumbers(null);

        Set<ConstraintViolation<SortRequest>> violations = validator.validate(sortRequest);

        assertEquals(1, violations.size(), "There should be one validation error for null numbers.");
        assertEquals("The numbers list cannot be null or empty.", violations.iterator().next().getMessage());
    }

    /* 
    @Test
    void testEmptyNumbers() {
        SortRequest sortRequest = new SortRequest();
        sortRequest.setNumbers(new ArrayList<>());

        Set<ConstraintViolation<SortRequest>> violations = validator.validate(sortRequest);

        assertEquals(1, violations.size(), "There should be one validation error for an empty numbers list.");
        assertEquals("The numbers list cannot be empty.", violations.iterator().next().getMessage());
    }
    */
}
