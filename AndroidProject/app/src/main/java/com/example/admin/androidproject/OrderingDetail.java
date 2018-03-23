package com.example.admin.androidproject;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
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
    ProductViewDAO dao = new ProductViewDAO();


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
        final String orderID = i.getExtras().getString("orderID");
        int tableNo = i.getExtras().getInt("tableNo");
        String orderTime = i.getExtras().getString("orderTime");
        String employeeName = i.getExtras().getString("employeeName");

        listFood = new ArrayList<>();
        try {
            listFood = dao.getFoodForOrder(orderID);
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

        payBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
// Add the buttons
                builder.setPositiveButton(R.string.confirm, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        boolean isUpdate = false;
                        try {
                            isUpdate = dao.updateOrderStatus(orderID);
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                        Intent result = new Intent();
                        result.putExtra("isUpdate", isUpdate);
                        setResult(Activity.RESULT_OK, result);
                        finish();
                    }
                });
                builder.setNegativeButton(R.string.notyet, new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                    }
                });
                builder.setTitle("Payment Confirm");
                builder.setMessage("Do you want to pay this order?");
                AlertDialog alertDialog = builder.create();
                alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.LTGRAY));
                alertDialog.show();
                Button nbutton = alertDialog.getButton(DialogInterface.BUTTON_NEGATIVE);
                nbutton.setBackground(
                        ContextCompat.getDrawable(
                                getBaseContext(),R.drawable.dialog_button
                        ));
                nbutton.setTextColor(Color.BLACK);
                Button pbutton = alertDialog.getButton(DialogInterface.BUTTON_POSITIVE);
                pbutton.setBackground(
                        ContextCompat.getDrawable(
                                getBaseContext(),R.drawable.dialog_button
                        ));
                pbutton.setTextColor(Color.BLACK);

//                final Dialog dialog = new Dialog(view.getContext()); // Context, this, etc.
//                dialog.setContentView(R.layout.dialog_confirm);
//                TextView dialogContent = (TextView) findViewById(R.id.dialog_info);
//                dialogContent.setText("Do you sure to pay this order?");
//                dialog.setTitle("Hello");
//                dialog.show();
            }
        });

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
        }

    }


    public void clickPay(View view) {

    }
}
