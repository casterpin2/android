package com.example.admin.androidproject.Entities;

import java.io.Serializable;

/**
 * Created by Admin on 3/23/2018.
 */

public class UserEntites implements Serializable {
    private String username;
    private String password;
    private String employeeID;
    private int roleId;

    public UserEntites() {
    }

    public UserEntites(String username, String password, String employeeID) {
        this.username = username;
        this.password = password;
        this.employeeID = employeeID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }
}
