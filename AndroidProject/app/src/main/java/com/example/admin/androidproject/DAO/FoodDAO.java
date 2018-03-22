package com.example.admin.androidproject.DAO;

import android.util.Log;

import com.example.admin.androidproject.Entities.ChefEntities;
import com.example.admin.androidproject.Entities.FoodEntities;
import com.example.admin.androidproject.Entities.OrderEntities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by TUMG on 21/03/2018.
 */

public class FoodDAO {
        public FoodDAO() {
}

        public List<ChefEntities> getOrder() throws SQLException {
            List<ChefEntities> listChef = new ArrayList<>();
            ChefEntities chef = null;
            Connection conn = null;
            PreparedStatement pre = null;
            ResultSet rs = null;

            try {
                conn = new BaseDAO().CONN();
                String sql ="select StatusType,FoodQuantity,FoodName,FoodImg from (select b.FoodID as FoodID,FoodQuantity,FoodName,FoodImg,StatusID from OrderTBL a,FoodTBL b where a.FoodID=b.FoodID) a,StatusTBL b where a.StatusID=b.StatusID";
                pre = conn.prepareStatement(sql);
                //pre.setInt(1,type);
                rs = pre.executeQuery();
                while (rs.next()){
                    chef = new ChefEntities();
                    chef.setOrderId(rs.getInt("OrderId"));
                    chef.setFoodImg(rs.getInt("FoodImg"));
                    chef.setFoodName(rs.getString("FoodName"));
                    chef.setFoodQuantity(rs.getInt("FoodQuantity"));
                    chef.setStatusType(rs.getString("StatusType"));

                    //order.Statu(type);
                    listChef.add(chef);
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


            return listChef;
        }


}
