package com.example.demo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.SortRequest;

import ch.qos.logback.classic.Logger;
import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/api/sort")
class SortingController {

    private static final Logger logger = LoggerFactory.getLogger(SortingController.class);

    @PostConstruct
    public void init() {
        logger.info("SortingService initialized and ready to use.");
    }

    @PostMapping("/bubble")
    public ResponseEntity<List<Double>> bubbleSort(@RequestBody SortRequest request) {
        logger.info("Received Bubble Sort request with data: {}", request.getNumbers());
        if (request.getNumbers() == null || request.getNumbers().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Input list cannot be null or empty");
        }
    
        List<Double> sortedList = new ArrayList<>(request.getNumbers());
        bubbleSortAlgorithm(sortedList, request.getOrder());
        logger.info("Bubble Sort completed. Sorted List: {}", sortedList);
        return ResponseEntity.ok(sortedList);
    }

    @PostMapping("/merge")
    public ResponseEntity<List<Double>> mergeSort(@RequestBody SortRequest request) {
        logger.info("Received Merge Sort request with data: {}", request.getNumbers());
        if (request.getNumbers() == null || request.getNumbers().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Input list cannot be null or empty");
        }
    
        List<Double> sortedList = mergeSortAlgorithm(request.getNumbers(), request.getOrder());
        logger.info("Merge Sort completed. Sorted List: {}", sortedList);
        return ResponseEntity.ok(sortedList);
    }
    
    @PostMapping("/quick")
    public ResponseEntity<List<Double>> quickSort(@RequestBody SortRequest request) {
        logger.info("Received Quick Sort request with data: {}", request.getNumbers());
        if (request.getNumbers() == null || request.getNumbers().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Input list cannot be null or empty");
        }
    
        List<Double> sortedList = new ArrayList<>(request.getNumbers());
        quickSortAlgorithm(sortedList, 0, sortedList.size() - 1, request.getOrder());
        logger.info("Quick Sort completed. Sorted List: {}", sortedList);
        return ResponseEntity.ok(sortedList);
    }
