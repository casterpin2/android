package com.example.admin.androidproject.DAO;

import android.os.AsyncTask;
import android.util.Log;

import com.example.admin.androidproject.Entities.ChefEntities;
import com.example.admin.androidproject.Entities.FoodEntities;
import com.example.admin.androidproject.Entities.FoodInOrderEntities;
import com.example.admin.androidproject.Entities.OrderEntities;
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
            String sql ="select distinct o.OrderID,o.TableNo,o.OrderTime,e.EmployeeName from \n" +
                    "                    OrderTBL o join StatusTBL s on o.StatusID = s.StatusID\n" +
                    "                    join EmployeeTBL e on e.EmployeeId = o.EmployeeOrder \n" +
                    "                    where  o.StatusID in (3)";
            pre = conn.prepareStatement(sql);
            rs = pre.executeQuery();
            while (rs.next()){
                order = new OrderForCasherEntities();
                order.setOrderID(rs.getString("OrderID"));
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
    public List<FoodInOrderEntities> getFoodForOrder(String orderID) throws SQLException {
        List<FoodInOrderEntities> foodList = new ArrayList<>();
        FoodInOrderEntities food = null;
        Connection conn = null;
        PreparedStatement pre = null;
        ResultSet rs = null;

        try {
            conn = new BaseDAO().CONN();
            String sql ="select o.OrderID, o.FoodID, f.FoodName, o. FoodOrderQuantity, f.FoodPrice, f.FoodImg from OrderTBL o inner join FoodTBL f on o.FoodID = f.FoodID  where o.OrderID = ?";
            pre = conn.prepareStatement(sql);
            pre.setString(1,orderID);
            rs = pre.executeQuery();
            while (rs.next()){
                food = new FoodInOrderEntities();
                food.setOrderID(rs.getString("OrderID"));
                food.setFoodID(rs.getString("FoodID"));
                food.setFoodName(rs.getString("FoodName"));
                food.setQuanlity(rs.getInt("FoodOrderQuantity"));
                food.setPrice(rs.getDouble("FoodPrice"));
                food.setFoodImg(rs.getString("FoodImg"));


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

    //update order status after pay order (ThangND)
    public boolean updateOrderStatus(String orderID) throws SQLException {

        Connection conn = null;
        PreparedStatement pre = null;
        ResultSet rs = null;
        boolean result = false;

        try {
            conn = new BaseDAO().CONN();
            conn.setAutoCommit(false);
            String sql =" update OrderTBL set StatusID = 2 where OrderID = ?";
            pre = conn.prepareStatement(sql);
            pre.setString(1,orderID);
            pre.executeUpdate();
            conn.commit();
            return true;

        } catch (Exception e) {
            Log.e("MSG", e.getMessage());
        } finally {

            if (pre != null) {
                pre.close();
            }
            if (rs != null) {
                rs.close();
            }
            if (conn != null) {
                conn.close();
            }
        }


        return false;
    }


    public List<ChefEntities> getOrderByChef() throws SQLException {
        List<ChefEntities> orderList = new ArrayList<>();
        ChefEntities order = null;
        Connection conn = null;
        PreparedStatement pre = null;
        ResultSet rs = null;

        try {
            conn = new BaseDAO().CONN();
            String sql ="select distinct o.OrderID,o.TableNo,o.OrderTime,e.EmployeeName from \n" +
                    "\n" +
                    "                     OrderTBL o join StatusTBL s on o.StatusID = s.StatusID\n" +
                    "                   join EmployeeTBL e on e.EmployeeId = o.EmployeeOrder \n" +
                    "                   where  o.StatusID in (1)";
            pre = conn.prepareStatement(sql);
            rs = pre.executeQuery();
            while (rs.next()){
                order = new ChefEntities();
                order.setOrderId(rs.getString("OrderID"));
                order.setTable(rs.getInt("TableNo"));
                order.setOrderTime(rs.getTimestamp("OrderTime"));
                order.setOderByName(rs.getString("EmployeeName"));
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

}
