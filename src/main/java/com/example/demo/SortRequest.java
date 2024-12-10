package com.example.demo;

import java.util.List;

public class SortRequest {
    private List<Double> numbers;
    private String order; // "asc" für aufsteigend, "desc" für absteigend

    public List<Double> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<Double> numbers) {
        this.numbers = numbers;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }
}
