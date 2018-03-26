package com.example.admin.androidproject.Entities;

import java.util.Date;

/**
 * Created by Admin on 3/21/2018.
 */

public class OrderEntities {
    private String orderId;
    private int tableNo;
    private Date orderTime;
    private String foodId;
    private int foodOrderQuantity;
    private String DemandCustommer;
    private int statusId;
    private String employeeId;

    public OrderEntities() {

    }

    public OrderEntities(String orderId, int tableNo, Date orderTime, String foodId, int foodOrderQuantity, String demandCustommer, int statusId, String employeeId) {
        this.orderId = orderId;
        this.tableNo = tableNo;
        this.orderTime = orderTime;
        this.foodId = foodId;
        this.foodOrderQuantity = foodOrderQuantity;
        DemandCustommer = demandCustommer;
        this.statusId = statusId;
        this.employeeId = employeeId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public int getTableNo() {
        return tableNo;
    }

    public void setTableNo(int tableNo) {
        this.tableNo = tableNo;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public String getFoodId() {
        return foodId;
    }

    public void setFoodId(String foodId) {
        this.foodId = foodId;
    }

    public int getFoodOrderQuantity() {
        return foodOrderQuantity;
    }

    public void setFoodOrderQuantity(int foodOrderQuantity) {
        this.foodOrderQuantity = foodOrderQuantity;
    }

    public String getDemandCustommer() {
        return DemandCustommer;
    }

    public void setDemandCustommer(String demandCustommer) {
        DemandCustommer = demandCustommer;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }
}
