/*package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class QuickSortService {
    public List<Double> sort(List<Double> list, int low, int high, String order) {
        if (low < high) {
            int pi = partition(list, low, high, order);
            sort(list, low, pi - 1, order);
            sort(list, pi + 1, high, order);
        }
        return list; 
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
}*/

package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.springframework.stereotype.Component;

@Component
public class QuickSortService {
    public List<Double> sort(List<Double> list, int low, int high, String order) {
        iterativeQuickSort(list, 0, list.size() - 1, order);
        return list;
    }

    private void iterativeQuickSort(List<Double> list, int low, int high, String order) {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{low, high});

        while (!stack.isEmpty()) {
            int[] range = stack.pop();
            low = range[0];
            high = range[1];

            if (low < high) {
                int pi = partition(list, low, high, order);

                if (pi - 1 > low) {
                    stack.push(new int[]{low, pi - 1});
                }
                if (pi + 1 < high) {
                    stack.push(new int[]{pi + 1, high});
                }
            }
        }
    }

    private int partition(List<Double> list, int low, int high, String order) {
        double pivot = list.get(high);
        int i = low - 1;

        for (int j = low; j < high; j++) {
            boolean condition = "asc".equalsIgnoreCase(order)
                ? list.get(j) <= pivot
                : list.get(j) >= pivot;

            if (condition) {
                i++;
                swap(list, i, j);
            }
        }
        swap(list, i + 1, high);
        return i + 1;
    }

    private void swap(List<Double> list, int i, int j) {
        double temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
}
