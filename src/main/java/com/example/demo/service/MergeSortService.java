package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class MergeSortService {

    public List<Double> sort(List<Double> list, String order) {
        if (list.size() <= 1) {
            return list;
        }
        int mid = list.size() / 2;
        List<Double> left = sort(new ArrayList<>(list.subList(0, mid)), order);
        List<Double> right = sort(new ArrayList<>(list.subList(mid, list.size())), order);
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
}