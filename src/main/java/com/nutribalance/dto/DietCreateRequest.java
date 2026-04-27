package com.nutribalance.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

public class DietCreateRequest {

    @NotBlank(message = "Food name is required")
    private String foodName;

    @Min(value = 0, message = "Calories cannot be negative")
    private int calories;

    @Min(value = 0, message = "Protein cannot be negative")
    private int protein;

    @Min(value = 0, message = "Carbs cannot be negative")
    private int carbs;

    @Min(value = 0, message = "Fats cannot be negative")
    private int fats;

    @NotNull(message = "Date is required")
    private LocalDate date;

    public DietCreateRequest() {}

    public DietCreateRequest(String foodName, int calories, int protein, int carbs, int fats, LocalDate date) {
        this.foodName = foodName;
        this.calories = calories;
        this.protein = protein;
        this.carbs = carbs;
        this.fats = fats;
        this.date = date;
    }

    // Getters and Setters
    public String getFoodName() { return foodName; }
    public void setFoodName(String foodName) { this.foodName = foodName; }

    public int getCalories() { return calories; }
    public void setCalories(int calories) { this.calories = calories; }

    public int getProtein() { return protein; }
    public void setProtein(int protein) { this.protein = protein; }

    public int getCarbs() { return carbs; }
    public void setCarbs(int carbs) { this.carbs = carbs; }

    public int getFats() { return fats; }
    public void setFats(int fats) { this.fats = fats; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }
}
