package com.example.admin.androidproject.DAO;

import android.content.Context;
import android.os.AsyncTask;
import android.os.StrictMode;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by TUYEN on 3/23/2018.
 */

public class myBaseDao extends AsyncTask<Void,Void,Connection> {
    String connectionString = "";
  //  String queryString = "SELECT FirstName, LastName FROM Tbl_Customer WHERE CustomerID = " + customerID;
    Context context;
    String ip = "10.22.160.216";
    String db = "MasterAndroid";
    String un = "sa";
    String password = "123456";
    @Override
    protected Connection doInBackground(Void... voids) {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        Connection conn = null;
        String ConnURL = null;
        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            ConnURL = "jdbc:jtds:sqlserver://" + ip + "/" + db+ ";user=" + un + ";password=" + password + ";";
            conn = DriverManager.getConnection(ConnURL);
        }catch (SQLException se)
        {
            Log.e("error here 1 : ", se.getMessage());
        }
        catch (ClassNotFoundException e)
        {
            Log.e("error here 2 : ", e.getMessage());
        }
        catch (Exception e)
        {
            Log.e("error here 3 : ", e.getMessage());
        }

        return conn;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }


}
