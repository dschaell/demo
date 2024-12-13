package com.example.demo.service;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BubbleSortServiceTest {

    private final BubbleSortService bubbleSortService = new BubbleSortService();

    @Test
    void testSortAscending() {
        List<Double> input = Arrays.asList(5.5, 2.2, 9.9, 3.3);
        List<Double> expected = Arrays.asList(2.2, 3.3, 5.5, 9.9);

        List<Double> result = bubbleSortService.sort(input, "asc");
        assertEquals(expected, result, "The sorted list (ascending) does not match the expected output.");
    }

    @Test
    void testSortDescending() {
        List<Double> input = Arrays.asList(5.5, 2.2, 9.9, 3.3);
        List<Double> expected = Arrays.asList(9.9, 5.5, 3.3, 2.2);

        List<Double> result = bubbleSortService.sort(input, "desc");
        assertEquals(expected, result, "The sorted list (descending) does not match the expected output.");
    }

    @Test
    void testEmptyList() {
        List<Double> input = Arrays.asList();
        List<Double> expected = Arrays.asList();

        List<Double> result = bubbleSortService.sort(input, "asc");
        assertEquals(expected, result, "Sorting an empty list should return an empty list.");
    }

    @Test
    void testSingleElementList() {
        List<Double> input = Arrays.asList(7.7);
        List<Double> expected = Arrays.asList(7.7);

        List<Double> result = bubbleSortService.sort(input, "asc");
        assertEquals(expected, result, "Sorting a single-element list should return the same list.");
    }

    /* 
    @Test
    void testInvalidOrder() {
        List<Double> input = Arrays.asList(5.5, 2.2, 9.9, 3.3);
        List<Double> expected = Arrays.asList(5.5, 2.2, 9.9, 3.3); // No change expected for invalid order

        List<Double> result = bubbleSortService.sort(input, "invalid");
        assertEquals(expected, result, "Sorting with an invalid order should not change the list.");
    }
    */
}
