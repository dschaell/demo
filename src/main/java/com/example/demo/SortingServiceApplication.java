package com.example.demo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ResponseStatusException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;





    
    private void bubbleSortAlgorithm(List<Double> list, String order) {
        int n = list.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                boolean condition = "asc".equalsIgnoreCase(order) 
                    ? list.get(j) > list.get(j + 1) 
                    : list.get(j) < list.get(j + 1);
    
                if (condition) {
                    double temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }
    }
    

    private List<Double> mergeSortAlgorithm(List<Double> list, String order) {
        if (list.size() <= 1) {
            return list;
        }
        int mid = list.size() / 2;
        List<Double> left = mergeSortAlgorithm(new ArrayList<>(list.subList(0, mid)), order);
        List<Double> right = mergeSortAlgorithm(new ArrayList<>(list.subList(mid, list.size())), order);
        return merge(left, right, order);
    }
    
    private List<Double> merge(List<Double> left, List<Double> right, String order) {
        List<Double> result = new ArrayList<>();
        int i = 0, j = 0;
        while (i < left.size() && j < right.size()) {
            boolean condition = "asc".equalsIgnoreCase(order) 
                ? left.get(i) <= right.get(j) 
                : left.get(i) >= right.get(j);
    
            if (condition) {
                result.add(left.get(i++));
            } else {
                result.add(right.get(j++));
            }
        }
        result.addAll(left.subList(i, left.size()));
        result.addAll(right.subList(j, right.size()));
        return result;
    }
    

    private void quickSortAlgorithm(List<Double> list, int low, int high, String order) {
        if (low < high) {
            int pi = partition(list, low, high, order);
            quickSortAlgorithm(list, low, pi - 1, order);
            quickSortAlgorithm(list, pi + 1, high, order);
        }
    }
    
    private int partition(List<Double> list, int low, int high, String order) {
        double pivot = list.get(high);
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            boolean condition = "asc".equalsIgnoreCase(order) 
                ? list.get(j) <= pivot 
                : list.get(j) >= pivot;
    
            if (condition) {
                i++;
                double temp = list.get(i);
                list.set(i, list.get(j));
                list.set(j, temp);
            }
        }
        double temp = list.get(i + 1);
        list.set(i + 1, list.get(high));
        list.set(high, temp);
        return i + 1;
    }
    
}
