package com.example.demo.service;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

        List<Double> resultDesc = bubbleSortService.sort(input, "desc");
        assertEquals(expected, resultDesc, "Sorting a single-element list (descending) should return the same list.");

    }

     @Test
    void testDuplicateValues() {
        List<Double> input = Arrays.asList(5.5, 2.2, 2.2, 9.9, 3.3);
        List<Double> expected = Arrays.asList(2.2, 2.2, 3.3, 5.5, 9.9);

        List<Double> result = bubbleSortService.sort(input, "asc");
        assertEquals(expected, result, "The sorted list with duplicates (ascending) does not match the expected output.");
    }

    @Test
    void testNegativeValues() {
        List<Double> input = Arrays.asList(-5.5, -2.2, 9.9, 3.3);
        List<Double> expected = Arrays.asList(-5.5, -2.2, 3.3, 9.9);

        List<Double> result = bubbleSortService.sort(input, "asc");
        assertEquals(expected, result, "The sorted list with negative values (ascending) does not match the expected output.");
    }

    @Test
    void testLargeInput() {
        List<Double> input = new ArrayList<>();
        for (int i = 10000; i > 0; i--) {
            input.add((double) i);
        }

        List<Double> result = bubbleSortService.sort(input, "asc");
        for (int i = 0; i < result.size() - 1; i++) {
            assertTrue(result.get(i) <= result.get(i + 1), "List is not sorted correctly.");
        }
    }

}
