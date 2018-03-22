package com.example.admin.androidproject.DAO;

import android.os.AsyncTask;
import android.util.Log;

import com.example.admin.androidproject.Entities.FoodEntities;
import com.example.admin.androidproject.Entities.FoodInOrderEntities;
import com.example.admin.androidproject.Entities.OrderForCasherEntities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 3/20/2018.
 */

public class ProductViewDAO {

    public ProductViewDAO() {
    }

    public List<FoodEntities> getFoodByType(int type) throws SQLException {
        List<FoodEntities> listFood = new ArrayList<>();
        FoodEntities food = null;
        Connection conn = null;
        PreparedStatement pre = null;
        ResultSet rs = null;

        try {
            conn = new BaseDAO().CONN();
            String sql ="select a.FoodID,a.FoodName,a.FoodPrice,a.InStock,a.Promotion,a.FoodQuantity,a.FoodImg" +
                    " from FoodTBL a join FoodType b on a.FoodTypeId=b.FoodTypeId where b.FoodTypeId =?";
            pre = conn.prepareStatement(sql);
            pre.setInt(1,type);
            rs = pre.executeQuery();
            while (rs.next()){
                food = new FoodEntities();
                food.setFoodId(rs.getString("FoodID"));
                food.setFoodName(rs.getString("FoodName"));
                food.setFoodPrice(rs.getDouble("FoodPrice"));
                if(rs.getInt("InStock") == 1){
                    food.setInStock(true);
                }
                if(rs.getInt("Promotion")==1){
                    food.setPromotion(true);
                };
                food.setFoodQuantity(rs.getInt("FoodQuantity"));
                food.setFoodImg(rs.getString("FoodImg"));
                food.setFoodType(type);
                listFood.add(food);
            }
        } catch (Exception e) {
            Log.e("MSG", e.getMessage());
        } finally {
            if (conn != null) {
                conn.close();
            }
            if (pre != null) {
                pre.close();
            }
            if (rs != null) {
                rs.close();
            }
        }


        return listFood;
    }

    //get all un-paid order to casher (ThangND)
    public List<OrderForCasherEntities> getOrdertoCasher() throws SQLException {
        List<OrderForCasherEntities> orderList = new ArrayList<>();
        OrderForCasherEntities order = null;
        Connection conn = null;
        PreparedStatement pre = null;
        ResultSet rs = null;

        try {
            conn = new BaseDAO().CONN();
            String sql ="select o.OrderID, o.TableNo, o. OrderTime, e.EmployeeName from OrderTBL as o " +
                    "inner join StatusTBL as s on o.StatusID = 1 inner join EmployeeTBL e on o.EmployeeOrder = e.EmployeeId;";
            pre = conn.prepareStatement(sql);
            rs = pre.executeQuery();
            while (rs.next()){
                order = new OrderForCasherEntities();
                order.setOrderID(rs.getInt("OrderID"));
                order.setTableNo(rs.getInt("TableNo"));
                order.setOrderTime(rs.getString("OrderTime"));
                order.setEmployeeOrder(rs.getString("EmployeeName"));

                orderList.add(order);
            }
        } catch (Exception e) {
            Log.e("MSG", e.getMessage());
        } finally {
            if (conn != null) {
                conn.close();
            }
            if (pre != null) {
                pre.close();
            }
            if (rs != null) {
                rs.close();
            }
        }


        return orderList;
    }

    //get food list via orderID (ThangND)
    public List<FoodInOrderEntities> getFoodForOrder(int orderID) throws SQLException {
        List<FoodInOrderEntities> foodList = new ArrayList<>();
        FoodInOrderEntities food = null;
        Connection conn = null;
        PreparedStatement pre = null;
        ResultSet rs = null;

        try {
            conn = new BaseDAO().CONN();
            String sql ="select o.FoodID, o. FoodOrderQuantity, f.FoodPrice, f.FoodName from OrderTBL o inner join FoodTBL f on o.FoodID = f.FoodID  where o.OrderID = ?;";
            pre = conn.prepareStatement(sql);
            pre.setInt(1,orderID);
            rs = pre.executeQuery();
            while (rs.next()){
                food = new FoodInOrderEntities();
                food.setFoodID(rs.getString("FoodID"));
                food.setFoodName(rs.getString("FoodName"));
                food.setQuanlity(rs.getInt("FoodOrderQuantity"));
                food.setPrice(rs.getDouble("FoodPrice"));

                foodList.add(food);
            }
        } catch (Exception e) {
            Log.e("MSG", e.getMessage());
        } finally {
            if (conn != null) {
                conn.close();
            }
            if (pre != null) {
                pre.close();
            }
            if (rs != null) {
                rs.close();
            }
        }


        return foodList;
    }

}
