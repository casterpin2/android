package com.example.admin.androidproject.DAO;

import android.os.AsyncTask;
import android.util.Log;

import com.example.admin.androidproject.Entities.ChefEntities;
import com.example.admin.androidproject.Entities.UserEntites;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 3/23/2018.
 */

public class LoginDAO extends AsyncTask<String,String,UserEntites> {
    public UserEntites loginAccount(String username,String password) throws SQLException {
        UserEntites user = null;

            ChefEntities chef = null;
            Connection conn = null;
            PreparedStatement pre = null;
            ResultSet rs = null;

            try {
                conn = new BaseDAO().CONN();
                String sql ="SELECT  a.[Account]\n" +
                        "      ,a.[Password]\n" +
                        "      ,a.[EmployeeId],e.RoleID\n" +
                        "  FROM [AccountTBL] a\n" +
                        "  join EmployeeTBL e on a.EmployeeID =e.EmployeeId" +
                        "   where a.Account = ? and a.password = ?";
                pre = conn.prepareStatement(sql);
                pre.setString(1,username);
                pre.setString(2,password);
                //pre.setInt(1,type);
                rs = pre.executeQuery();
                while (rs.next()){
                    user = new UserEntites();
                    user.setUsername(rs.getString("Account"));
                    user.setPassword(rs.getString("Password"));
                    user.setEmployeeID(rs.getString("EmployeeID"));
                    user.setRoleId(rs.getInt("RoleID"));
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

        return user;


    }

    @Override
    protected UserEntites doInBackground(String... voids) {
        return null;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(UserEntites userEntites) {
        super.onPostExecute(userEntites);
    }
}
