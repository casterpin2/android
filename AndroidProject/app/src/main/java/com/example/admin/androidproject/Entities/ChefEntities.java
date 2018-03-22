package com.example.admin.androidproject.Entities;

/**
 * Created by TUMG on 21/03/2018.
 */

public class ChefEntities {
    private int orderId;
    private String foodName;
    private int foodImg;
    private  String statusType;
    private int foodQuantity;

    public ChefEntities() {
    }

    public ChefEntities(int orderId, String foodName, int foodImg, String statusType, int foodQuantity) {
        this.orderId = orderId;
        this.foodName = foodName;
        this.foodImg = foodImg;
        this.statusType = statusType;
        this.foodQuantity = foodQuantity;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public int getFoodImg() {
        return foodImg;
    }

    public void setFoodImg(int foodImg) {
        this.foodImg = foodImg;
    }

    public String getStatusType() {
        return statusType;
    }

    public void setStatusType(String statusType) {
        this.statusType = statusType;
    }

    public int getFoodQuantity() {
        return foodQuantity;
    }

    public void setFoodQuantity(int foodQuantity) {
        this.foodQuantity = foodQuantity;
    }
}
