package com.example.admin.androidproject;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.admin.androidproject.DAO.ProductViewDAO;
import com.example.admin.androidproject.Entities.OrderForCasherEntities;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ViewOrderListByCasher extends AppCompatActivity {

    ListView orderingListView ;
    List<OrderForCasherEntities> orderList = null;
    ArrayAdapter<OrderForCasherEntities> adapter = null;
    static final int REQUEST = 8888;
    String empId;
    int roleId;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 100 && resultCode ==200) {
            boolean isUpdate = data.getBooleanExtra("isUpdate",false);
            String orderId = data.getStringExtra("orderId");
            ProductViewDAO dao = new ProductViewDAO();
            try {
                orderList = dao.getOrdertoCasher();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            ListViewAdapter adapter = new ListViewAdapter(ViewOrderListByCasher.this, R.layout.activity_custom_list_view, orderList);
            orderingListView.setAdapter(adapter);
            Toast.makeText(this,isUpdate+"",Toast.LENGTH_LONG).show();
        }


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_order_list_by_casher);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.logo_restaurant);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.WHITE));

        orderingListView =(ListView) findViewById(R.id.orderingListView);
        orderList = new ArrayList<OrderForCasherEntities>();
        ProductViewDAO dao = new ProductViewDAO();
        try {
            orderList = dao.getOrdertoCasher();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        ListViewAdapter adapter = new ListViewAdapter(ViewOrderListByCasher.this, R.layout.activity_custom_list_view, orderList);
        orderingListView.setAdapter(adapter);

        orderingListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                OrderForCasherEntities order = orderList.get(position);
                Intent intent = new Intent(ViewOrderListByCasher.this,OrderingDetail.class);
                intent.putExtra("orderID",order.getOrderID());
                intent.putExtra("tableNo",order.getTableNo());
                intent.putExtra("orderTime",order.getOrderTime());
                intent.putExtra("employeeName",order.getEmployeeOrder());

                startActivityForResult(intent,100);
//                Toast.makeText(ViewOrderListByCasher.this, "Order : [" +orderList.get(position).getOrderID()+orderList.get(position).getTableNo()+ "]", Toast.LENGTH_LONG).show();

            }
        });
    }
}
