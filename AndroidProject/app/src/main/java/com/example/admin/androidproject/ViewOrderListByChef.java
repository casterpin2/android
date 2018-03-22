package com.example.admin.androidproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.admin.androidproject.DAO.ProductViewDAO;
import com.example.admin.androidproject.Entities.ChefEntities;
import com.example.admin.androidproject.Entities.OrderForCasherEntities;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ViewOrderListByChef extends AppCompatActivity {
    ListView orderingListView ;
    List<ChefEntities> orderList = null;
    ArrayAdapter<OrderForCasherEntities> adapter = null;
    static final int REQUEST = 8888;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_order_list_by_chef2);
        orderingListView =(ListView) findViewById(R.id.orderingListView2);
        orderList = new ArrayList<ChefEntities>();
        ProductViewDAO dao = new ProductViewDAO();
        try {
            orderList = dao.getOrderByChef();
            Toast.makeText(this,""+ orderList.size(),Toast.LENGTH_LONG).show();
            ListViewAdapterByChef adapter = new ListViewAdapterByChef(this, R.layout.activity_custom_list_view, orderList);
            orderingListView.setAdapter(adapter);
        } catch (SQLException e) {
            e.printStackTrace();
            Log.e("MSG",e.getMessage());
        }

        orderingListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ChefEntities order = orderList.get(position);
                Intent intent = new Intent(ViewOrderListByChef.this,FoodCheff.class);
                intent.putExtra("tableNo",order.getTable()+"");
                intent.putExtra("orderTime",order.getOrderTime()+"");
                intent.putExtra("employeeNameOrder",order.getOderByName()+"");

                startActivity(intent);
//                Toast.makeText(ViewOrderListByCasher.this, "Order : [" +orderList.get(position).getOrderID()+orderList.get(position).getTableNo()+ "]", Toast.LENGTH_LONG).show();

            }
        });

    }
}