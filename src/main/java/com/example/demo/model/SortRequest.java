package com.example.demo.model;

import java.util.List;
import jakarta.validation.constraints.NotEmpty;
//import jakarta.validation.constraints.NotNull;

public class SortRequest {

    //@NotNull(message = "The numbers list cannot be null.")
    @NotEmpty(message = "The numbers list cannot be null or empty.")

    private List<Double> numbers;

    public List<Double> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<Double> numbers) {
        this.numbers = numbers;
    }

  
}
