package com.example.admin.androidproject.Entities;

import java.util.Date;

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
    private int table;
    private Date orderTime;
    private String oderByName;
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

    public int getTable() {
        return table;
    }

    public void setTable(int table) {
        this.table = table;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public String getOderByName() {
        return oderByName;
    }

    public void setOderByName(String oderByName) {
        this.oderByName = oderByName;
    }
}
