package com.example.admin.androidproject.Entities;

/**
 * Created by TUMG on 21/03/2018.
 */

public class ChefEntities {
    private String orderId;
    private String foodName;
    private int foodImg;
    private  String statusType;
    private int foodQuantity;//orderQuantity
    private String foodImgUrl;

    public ChefEntities() {
    }

    public ChefEntities(String orderId, String foodName, int foodImg, String statusType, int foodQuantity) {
        this.orderId = orderId;
        this.foodName = foodName;
        this.foodImg = foodImg;
        this.statusType = statusType;
        this.foodQuantity = foodQuantity;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
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

    public String getFoodImgUrl() {
        return foodImgUrl;
    }

    public void setFoodImgUrl(String foodImgUrl) {
        this.foodImgUrl = foodImgUrl;
    }
}
