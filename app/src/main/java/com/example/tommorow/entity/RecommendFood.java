package com.example.tommorow.entity;

/**
 * 推荐食物的实体类
 */

public class RecommendFood {
    private int amount;
    private String name;

    public RecommendFood(int amount, String name) {
        this.amount = amount;
        this.name = name;
    }
    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
