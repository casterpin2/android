package com.example.admin.androidproject.DAO;

import android.util.Log;

import com.example.admin.androidproject.Entities.FoodEntities;
import com.example.admin.androidproject.Entities.OrderEntities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Admin on 3/21/2018.
 */

public class SingleViewDao {

    public SingleViewDao() {
    }

    public FoodEntities getInfoFood(String idFood) throws SQLException {
        FoodEntities food = null;
        Connection conn = null;
        PreparedStatement pre = null;
        ResultSet rs = null;
        try {
            String sql = "select FoodName,FoodPrice,FoodQuantity,FoodDescription,FoodImg from FoodTBL where FoodID = ?";
            conn = new BaseDAO().CONN();
            pre = conn.prepareStatement(sql);
            pre.setString(1, idFood);
            rs = pre.executeQuery();
            while (rs.next()) {
                food = new FoodEntities();
                food.setFoodName(rs.getString("FoodName"));
                food.setFoodPrice(rs.getDouble("FoodPrice"));
                food.setFoodQuantity(rs.getInt("FoodQuantity"));
                if (rs.getString("FoodDescription") != null) {
                    food.setFoodDes(rs.getString("FoodDescription"));
                } else food.setFoodDes("N/A");
                food.setFoodImg(rs.getString("FoodImg"));
            }
        } catch (Exception e) {
            Log.e("error", e.getMessage());

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

        return food;
    }

    public boolean addImployee(OrderEntities e,int total) throws SQLException {

        Connection conn = null;
        PreparedStatement pre = null;
        boolean checkInsert = false;
        boolean checkUpdate = false;
        try {

            conn = new BaseDAO().CONN();
            conn.setAutoCommit(false);
            String sql = "INSERT INTO [OrderTBL]\n" +
                    "           ([TableNo]\n" +
                    "           ,[OrderTime]\n" +
                    "           ,[FoodID]\n" +
                    "           ,[FoodOrderQuantity]\n" +
                    "           ,[DemandCustomer]\n" +
                    "           ,[StatusID]\n" +
                    "           ,[EmployeeOrder])\n" +
                    "           VALUES\n" +
                    "           (?,?,?,?,?,?,?)";
            pre = conn.prepareStatement(sql);
            pre.setInt(1, e.getTableNo());
            Date currentTime = Calendar.getInstance().getTime();
            DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
            java.sql.Date sqlDate = java.sql.Date.valueOf(df.format(currentTime));
            pre.setDate(2, sqlDate);
            pre.setInt(3, e.getFoodOrderQuantity());
            pre.setString(4, e.getDemandCustommer());
            pre.setInt(5, 1);
            pre.setString(6, "EMP001");
            pre.addBatch();
            int[] count = pre.executeBatch();
            if (count.length > 0) {
                checkInsert = true;
            }

            checkUpdate = updateQuantityFood(e,conn,total);

            if (!checkInsert && !checkUpdate) {
                conn.setAutoCommit(true);
                conn.rollback();
            }

        } catch (Exception ex) {
            Log.e("error", ex.getMessage());
        } finally {
            if (pre != null) {
                pre.close();
            }
            if (conn != null) {
                conn.close();
            }
        }

        return checkInsert && checkUpdate;
    }

    public boolean updateQuantityFood(OrderEntities e,Connection conn,int total) throws SQLException {
        PreparedStatement pre = null;
        boolean checkUpdate = false;
        try {

            conn = new BaseDAO().CONN();
            conn.setAutoCommit(false);
            String sql = "Update FoodTBL set FoodQuantity =?,InStock =? where FoodID =?";
            pre = conn.prepareStatement(sql);
            int quantityAfter = total - e.getFoodOrderQuantity();
            pre.setInt(1,quantityAfter);
            if(quantityAfter >=0){
                pre.setInt(2,1);
            } else {
                pre.setInt(2,0);
            }
            pre.setString(3,e.getFoodId());
            pre.addBatch();
            int[] count = pre.executeBatch();
            if (count.length > 0) {
                checkUpdate = true;
            }

        } catch (Exception ex) {
            Log.e("error", ex.getMessage());
        } finally {
            if (pre != null) {
                pre.close();
            }
        }


        return checkUpdate;
    }
}
