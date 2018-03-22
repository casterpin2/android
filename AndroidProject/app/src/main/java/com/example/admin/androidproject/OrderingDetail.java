package com.example.admin.androidproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.admin.androidproject.DAO.ProductViewDAO;
import com.example.admin.androidproject.Entities.FoodInOrderEntities;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderingDetail extends AppCompatActivity {
    Button backBtn;
    Button payBtn;
    ListView foodListView = null;
    List<FoodInOrderEntities> listFood =null;
    TextView orderIdTV = null;
    TextView tableNoTV = null;
    TextView employeeNameTV = null;
    TextView orderTimeTV = null;
    TextView totalBillTV = null;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ordering_detail);

        payBtn = (Button) findViewById(R.id.payBtn);
        backBtn = (Button) findViewById(R.id.backBtn);

        foodListView = (ListView) findViewById(R.id.foodLIstView);
        orderIdTV =(TextView) findViewById(R.id.orderIDTextView) ;
        tableNoTV =(TextView) findViewById(R.id.tableNoTextView) ;
        employeeNameTV =(TextView) findViewById(R.id.employeeNameTextView) ;
        orderTimeTV =(TextView) findViewById(R.id.orderTimeTextView) ;
        totalBillTV = (TextView) findViewById(R.id.totalBillTextView);

        Intent i = getIntent();
        String orderID = i.getExtras().getString("orderID");
        int tableNo = i.getExtras().getInt("tableNo");
        String orderTime = i.getExtras().getString("orderTime");
        String employeeName = i.getExtras().getString("employeeName");

        listFood = new ArrayList<>();
        try {
            listFood = new ProductViewDAO().getFoodForOrder(orderID);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        FoodListViewAdapter adapter = new FoodListViewAdapter(OrderingDetail.this, R.layout.activity_custom_food_list_view, listFood);
        foodListView.setAdapter(adapter);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });



//        Toast.makeText(OrderingDetail.this, "Hello"+String.valueOf(orderID)+String.valueOf(tableNo)+orderTime+employeeName, Toast.LENGTH_LONG).show();
        orderIdTV.setText(String.valueOf(orderID)+"");
        tableNoTV.setText(String.valueOf(tableNo)+"");
        employeeNameTV.setText(employeeName+"");
        orderTimeTV.setText(orderTime+"");


        Bundle extras = getIntent().getExtras();
        if (extras != null) {
        }

    }


    public void clickPay(View view) {

    }
}
