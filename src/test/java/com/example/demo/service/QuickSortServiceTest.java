package com.example.demo.service;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class QuickSortServiceTest {

    private final QuickSortService quickSortService = new QuickSortService();

    @Test
    void testSortAscending() {
        List<Double> input = Arrays.asList(5.5, 2.2, 8.8, 1.1);
        List<Double> expected = Arrays.asList(1.1, 2.2, 5.5, 8.8);

        List<Double> result = quickSortService.sort(input, 0, input.size() - 1, "asc");
        assertEquals(expected, result, "The sorted list (ascending) does not match the expected output.");
    }

    @Test
    void testSortDescending() {
        List<Double> input = Arrays.asList(5.5, 2.2, 8.8, 1.1);
        List<Double> expected = Arrays.asList(8.8, 5.5, 2.2, 1.1);

        List<Double> result = quickSortService.sort(input, 0, input.size() - 1, "desc");
        assertEquals(expected, result, "The sorted list (descending) does not match the expected output.");
    }

    @Test
    void testEmptyList() {
        List<Double> input = Arrays.asList();
        List<Double> expected = Arrays.asList();

        List<Double> result = quickSortService.sort(input, 0, input.size() - 1, "asc");
        assertEquals(expected, result, "Sorting an empty list should return an empty list.");
    }

    @Test
    void testSingleElementList() {
        List<Double> input = Arrays.asList(10.10);
        List<Double> expected = Arrays.asList(10.10);

        List<Double> result = quickSortService.sort(input, 0, input.size() - 1, "asc");
        assertEquals(expected, result, "Sorting a single-element list should return the same list.");
    }

     @Test
    void testDuplicateValues() {
        List<Double> input = Arrays.asList(5.5, 2.2, 2.2, 9.9, 3.3);
        List<Double> expected = Arrays.asList(2.2, 2.2, 3.3, 5.5, 9.9);

        List<Double> result = quickSortService.sort(input, 0, input.size() - 1, "asc");
        assertEquals(expected, result, "The sorted list with duplicates (ascending) does not match the expected output.");
    }

    @Test
    void testNegativeValues() {
        List<Double> input = Arrays.asList(-5.5, -2.2, 9.9, 3.3);
        List<Double> expected = Arrays.asList(-5.5, -2.2, 3.3, 9.9);

        List<Double> result = quickSortService.sort(input, 0, input.size() - 1, "asc");
        assertEquals(expected, result, "The sorted list with negative values (ascending) does not match the expected output.");
    }
    @Test
    void testLargeInput() {
        List<Double> input = new ArrayList<>();
        for (int i = 10000; i > 0; i--) {
            input.add((double) i);
        }

        List<Double> result = quickSortService.sort(input, 0, input.size() - 1, "asc");
        for (int i = 0; i < result.size() - 1; i++) {
            assertTrue(result.get(i) <= result.get(i + 1), "List is not sorted correctly.");
        }
    }
    
    
}
