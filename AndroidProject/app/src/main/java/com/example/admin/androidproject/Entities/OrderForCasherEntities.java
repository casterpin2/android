package com.example.admin.androidproject.Entities;

/**
 * Created by ThangOcCho on 3/21/2018.
 */

public class OrderForCasherEntities {
    private String orderID;
    private int tableNo;
    private String orderTime;
    private int statusID;
    private String employeeName;

    public OrderForCasherEntities() {

    }

    public OrderForCasherEntities(String orderID, int tableNo, String orderTime, int statusID, String employeeName) {
        this.orderID = orderID;
        this.tableNo = tableNo;
        this.orderTime = orderTime;
        this.statusID = statusID;
        this.employeeName = employeeName;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public int getTableNo() {
        return tableNo;
    }

    public void setTableNo(int tableNo) {
        this.tableNo = tableNo;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }


    public int getStatusID() {
        return statusID;
    }

    public void setStatusID(int statusID) {
        this.statusID = statusID;
    }

    public String getEmployeeOrder() {
        return employeeName;
    }

    public void setEmployeeOrder(String employeeName) {
        this.employeeName = employeeName;
    }
}
