package com.example.demo.controller;

import java.util.List;
 

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.SortRequest;
import com.example.demo.service.BubbleSortService;
import com.example.demo.service.MergeSortService;
import com.example.demo.service.QuickSortService;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/api/sort")
public class Controller {

    private static final Logger logger = LoggerFactory.getLogger(Controller.class);

    @Autowired
    private BubbleSortService bubbleSortService;

    @Autowired
    private MergeSortService mergeSortService; 
    
    @Autowired
    private QuickSortService quickSortService;
    
    @PostConstruct
    public void init() {
        logger.info("SortingService initialized and ready to use.");
    }

    @PostMapping("/bubble")
    public ResponseEntity<List<Double>> bubbleSort(@RequestBody SortRequest request,  @RequestParam(name = "order", defaultValue = "asc") String order) {
        logger.info("Received Bubble Sort request with data: {}", request.getNumbers());
    
        List <Double> sortedList = bubbleSortService.sort(request.getNumbers(), order);
        logger.info("Bubble Sort completed. Sorted List: {}", sortedList);
        return ResponseEntity.ok(sortedList);
    }

    @PostMapping("/merge")
    public ResponseEntity<List<Double>> mergeSort(@RequestBody SortRequest request,  @RequestParam(name = "order", defaultValue = "asc") String order) {
        logger.info("Received Merge Sort request with data: {}", request.getNumbers());
    
        List <Double> sortedList = mergeSortService.sort(request.getNumbers(), order);
        logger.info("Merge Sort completed. Sorted List: {}", sortedList);
        return ResponseEntity.ok(sortedList);
    }
    
    @PostMapping("/quick")
    public ResponseEntity<List<Double>> quickSort(@RequestBody SortRequest request,  @RequestParam(name = "order", defaultValue = "asc") String order) {
        logger.info("Received Quick Sort request with data: {}", request.getNumbers());
    
        List <Double> sortedList = quickSortService.sort(request.getNumbers(),0, request.getNumbers().size()-1, order);
        logger.info("Quick Sort completed. Sorted List: {}", sortedList);
        return ResponseEntity.ok(sortedList);
    }

}
