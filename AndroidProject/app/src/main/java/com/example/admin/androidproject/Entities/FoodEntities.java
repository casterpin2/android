package com.example.admin.androidproject.Entities;

import java.io.Serializable;

/**
 * Created by Admin on 3/20/2018.
 */

public class FoodEntities implements Serializable {
    private String foodId;
    private String foodName;
    private Double foodPrice;
    private boolean inStock = false;
    private boolean promotion = false;
    private int foodQuantity;
    private String foodImg;
    private int img;
    private int foodType;
    private String foodDes;
    public FoodEntities() {

    }

    public FoodEntities(String foodId, String foodName, Double foodPrice, boolean inStock, boolean promotion, int foodQuantity, String foodImg, int foodType) {
        this.foodId = foodId;
        this.foodName = foodName;
        this.foodPrice = foodPrice;
        this.inStock = inStock;
        this.promotion = promotion;
        this.foodQuantity = foodQuantity;
        this.foodImg = foodImg;
        this.foodType = foodType;
    }

    public String getFoodId() {
        return foodId;
    }

    public void setFoodId(String foodId) {
        this.foodId = foodId;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public Double getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(Double foodPrice) {
        this.foodPrice = foodPrice;
    }

    public boolean isInStock() {
        return inStock;
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }

    public boolean isPromotion() {
        return promotion;
    }

    public void setPromotion(boolean promotion) {
        this.promotion = promotion;
    }

    public int getFoodQuantity() {
        return foodQuantity;
    }

    public void setFoodQuantity(int foodQuantity) {
        this.foodQuantity = foodQuantity;
    }

    public String getFoodImg() {
        return foodImg;
    }

    public void setFoodImg(String foodImg) {
        this.foodImg = foodImg;
    }

    public int getFoodType() {
        return foodType;
    }

    public void setFoodType(int foodType) {
        this.foodType = foodType;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getFoodDes() {
        return foodDes;
    }

    public void setFoodDes(String foodDes) {
        this.foodDes = foodDes;
    }
}
