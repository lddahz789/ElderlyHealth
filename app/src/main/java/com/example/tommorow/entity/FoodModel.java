package com.example.tommorow.entity;

import java.io.Serializable;

/**
 * 食物的实体类  继承Serializable  是为了用Intent传送数据
 */

public class FoodModel implements Serializable{
    private String foodName;
    private String energy;

    private double fat;
    private double protein;
    private double carbohydrates;
    private int amount;
    public FoodModel() {
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public FoodModel(String foodName, String energy, int fat, int protein, int carbohydrates, int amount) {

        this.foodName = foodName;
        this.energy = energy;
        this.fat = fat;
        this.protein = protein;
        this.carbohydrates = carbohydrates;
        this.amount = amount;
    }

    public FoodModel(String foodName, String energy, int fat, int protein, int carbohydrates) {
        this.foodName = foodName;
        this.energy = energy;
        this.fat = fat;
        this.protein = protein;
        this.carbohydrates = carbohydrates;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getEnergy() {
        return energy;
    }

    public void setEnergy(String energy) {
        this.energy = energy;
    }

    public double getFat() {
        return fat;
    }

    public void setFat(double fat) {
        this.fat = fat;
    }

    public double getProtein() {
        return protein;
    }

    public void setProtein(double protein) {
        this.protein = protein;
    }

    public double getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(double carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    public void setCarbohydrates(int carbohydrates) {
        this.carbohydrates = carbohydrates;
    }
}
