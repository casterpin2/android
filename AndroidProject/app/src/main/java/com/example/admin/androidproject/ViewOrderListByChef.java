package com.example.admin.androidproject;

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

public class ViewOrderListByChef extends AppCompatActivity {
    ListView orderingListView ;
    List<OrderForCasherEntities> orderList = null;
    ArrayAdapter<OrderForCasherEntities> adapter = null;
    static final int REQUEST = 8888;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_order_list_by_chef2);
        orderingListView =(ListView) findViewById(R.id.orderingListView2);
        orderList = new ArrayList<OrderForCasherEntities>();
        ProductViewDAO dao = new ProductViewDAO();
        try {
            orderList = dao.getOrdertoCasher();
            Toast.makeText(ViewOrderListByChef.this,""+ orderList.size(),Toast.LENGTH_LONG).show();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        ListViewAdapter adapter = new ListViewAdapter(ViewOrderListByChef.this, R.layout.chef_item_layout, orderList);
        orderingListView.setAdapter(adapter);

        orderingListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                OrderForCasherEntities order = orderList.get(position);
            }
        });
    }
}