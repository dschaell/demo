package com.example.demo.controller;

import java.util.List;
 

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
import jakarta.validation.Valid;

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
    public ResponseEntity<List<Double>> bubbleSort(@RequestBody @Valid SortRequest request,  @RequestParam(name = "order", defaultValue = "asc") String order) {
        logger.info("Received Bubble Sort request with valid Input: {}", request.getNumbers());

        long startTime = System.currentTimeMillis(); // Zeit vor dem Algorithmus

        List <Double> sortedList = bubbleSortService.sort(request.getNumbers(), order);
        long endTime = System.currentTimeMillis(); // Zeit nach dem Algorithmus
        long duration = endTime - startTime; // Dauer in Millisekunden
        logger.info("Bubble Sort completed in {} ms. \n Sorted List: {}", duration, sortedList);
        return ResponseEntity.ok(sortedList);
    }

    @PostMapping("/merge")
    public ResponseEntity<List<Double>> mergeSort(@RequestBody @Valid SortRequest request,  @RequestParam(name = "order", defaultValue = "asc") String order) {
        logger.info("Received Merge Sort request with valid Input: {}", request.getNumbers());

        long startTime = System.currentTimeMillis(); // Zeit vor dem Algorithmus
    
        List <Double> sortedList = mergeSortService.sort(request.getNumbers(), order);
        long endTime = System.currentTimeMillis(); // Zeit nach dem Algorithmus
        long duration = endTime - startTime; // Dauer in Millisekunden
        logger.info("Merge Sort completed in {} ms. \n Sorted List: {}", duration, sortedList);
        return ResponseEntity.ok(sortedList);
    }
    
    @PostMapping("/quick")
    public ResponseEntity<List<Double>> quickSort(@RequestBody @Valid SortRequest request,  @RequestParam(name = "order", defaultValue = "asc") String order) {
        logger.info("Received Quick Sort request with valid Input: {}", request.getNumbers());

        long startTime = System.currentTimeMillis(); // Zeit vor dem Algorithmus
    
        List <Double> sortedList = quickSortService.sort(request.getNumbers(),0, request.getNumbers().size()-1, order);
        long endTime = System.currentTimeMillis(); // Zeit nach dem Algorithmus
        long duration = endTime - startTime; // Dauer in Millisekunden
        logger.info("Quick Sort completed in {} ms. \n Sorted List: {}", duration, sortedList);
        return ResponseEntity.ok(sortedList);
    }

}
