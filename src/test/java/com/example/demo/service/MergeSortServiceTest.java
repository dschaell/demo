package com.example.demo.service;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MergeSortServiceTest {

    private final MergeSortService mergeSortService = new MergeSortService();

    @Test
    void testSortAscending() {
        List<Double> input = Arrays.asList(4.4, 2.2, 7.7, 1.1);
        List<Double> expected = Arrays.asList(1.1, 2.2, 4.4, 7.7);

        List<Double> result = mergeSortService.sort(input, "asc");
        assertEquals(expected, result, "The sorted list (ascending) does not match the expected output.");
    }

    @Test
    void testSortDescending() {
        List<Double> input = Arrays.asList(4.4, 2.2, 7.7, 1.1);
        List<Double> expected = Arrays.asList(7.7, 4.4, 2.2, 1.1);

        List<Double> result = mergeSortService.sort(input, "desc");
        assertEquals(expected, result, "The sorted list (descending) does not match the expected output.");
    }

    @Test
    void testEmptyList() {
        List<Double> input = Arrays.asList();
        List<Double> expected = Arrays.asList();

        List<Double> result = mergeSortService.sort(input, "asc");
        assertEquals(expected, result, "Sorting an empty list should return an empty list.");
    }

    @Test
    void testSingleElementList() {
        List<Double> input = Arrays.asList(8.8);
        List<Double> expected = Arrays.asList(8.8);

        List<Double> result = mergeSortService.sort(input, "asc");
        assertEquals(expected, result, "Sorting a single-element list should return the same list.");
    }
    /* 
    @Test
    void testInvalidOrder() {
        List<Double> input = Arrays.asList(3.3, 1.1, 4.4, 2.2);
        List<Double> expected = Arrays.asList(1.1, 2.2, 3.3, 4.4); // Defaulting to ascending order for invalid input

        List<Double> result = mergeSortService.sort(input, "invalid");
        assertEquals(expected, result, "Sorting with an invalid order should default to ascending order.");
    }
    */
}
