package com.example.admin.androidproject.Entities;

/**
 * Created by ThangOcCho on 3/21/2018.
 */

public class FoodInOrderEntities {
    private String orderID;
    private String foodID;
    private String foodName;
    private int quanlity;
    private double price;
    private String foodImg;

    public FoodInOrderEntities(String orderID, String foodID,String foodName, int quanlity, double price, String foodImg) {
        this.orderID = orderID;
        this.foodID = foodID;
        this.foodName = foodName;
        this.quanlity = quanlity;
        this.price = price;
        this.foodImg = foodImg;
    }
    public FoodInOrderEntities(){

    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getFoodID() {
        return foodID;
    }

    public void setFoodID(String foodID) {
        this.foodID = foodID;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public int getQuanlity() {
        return quanlity;
    }

    public void setQuanlity(int quanlity) {
        this.quanlity = quanlity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getFoodImg() {
        return foodImg;
    }

    public void setFoodImg(String foodImg) {
        this.foodImg = foodImg;
    }
}
