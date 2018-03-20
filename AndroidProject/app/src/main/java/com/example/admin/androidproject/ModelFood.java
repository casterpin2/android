package com.example.admin.androidproject;

/**
 * Created by Admin on 3/20/2018.
 */

public class ModelFood {
    private int img;
    private String name;
    private String place;
    private String Price;
    private int foodId;

    public ModelFood() {
    }

    public ModelFood(int img, String name, String place, String price,int foodId) {
        this.img = img;
        this.name = name;
        this.place = place;
        this.Price = price;
        this.foodId = foodId;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public int getFoodId() {
        return foodId;
    }

    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }
}
