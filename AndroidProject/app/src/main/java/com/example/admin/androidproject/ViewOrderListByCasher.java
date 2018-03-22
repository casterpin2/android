package com.example.admin.androidproject;

import android.annotation.SuppressLint;
import android.content.Intent;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_order_list_by_casher);

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

                startActivity(intent);
//                Toast.makeText(ViewOrderListByCasher.this, "Order : [" +orderList.get(position).getOrderID()+orderList.get(position).getTableNo()+ "]", Toast.LENGTH_LONG).show();

            }
        });
    }
}
