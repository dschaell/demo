package com.example.demo.service;

import java.util.List;
import org.springframework.stereotype.Component;


@Component
public class BubbleSortService {
    public List<Double> sort(List<Double> list, String order) {
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
        return list;
    }
}
