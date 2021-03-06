package com.example.admin.androidproject;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.androidproject.DAO.SingleViewDao;
import com.example.admin.androidproject.Entities.FoodEntities;
import com.example.admin.androidproject.Entities.OrderEntities;

import java.sql.SQLOutput;

import static com.example.admin.androidproject.FoodAdapter.formatVnCurrence;

public class SingleViewActivity extends AppCompatActivity {
    private ImageView imgView;
    private TextView txtName;
    private TextView txtPrice;
    private TextView txtDescripton;
    private Button btnAdd;
    private SingleViewDao singleViewDao;
    private FoodEntities food;
    private Dialog dialog;
    private Button btnOK;
    int numberOrder = 0;
    private EditText editText;
    int total;
    String position;
    String employeeId;
    private OrderEntities orderEntities;
    int numberTable;
    int numberOfFood;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_view2);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.logo_restaurant);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.WHITE));

        Intent i = getIntent();
        imgView = (ImageView) findViewById(R.id.imageFood);
        txtName = (TextView) findViewById(R.id.txtNameFood);
        txtPrice = (TextView) findViewById(R.id.txtPrice);
        txtDescripton = (TextView) findViewById(R.id.txtArea);
        btnAdd = (Button) findViewById(R.id.btnAddToCart);
        btnOK = (Button) findViewById(R.id.btnOK);
         position = i.getExtras().getString("id");
        total = i.getExtras().getInt("total");
         numberTable = i.getExtras().getInt("numberTable");
         employeeId = i.getExtras().getString("employeeId");
        numberOfFood = i .getExtras().getInt("numberOffood");
        try {
            singleViewDao = new SingleViewDao();
            food = singleViewDao.getInfoFood(position);
            orderEntities = new OrderEntities();

            int id = this.getResources().getIdentifier(food.getFoodImg() + "", "drawable", this.getPackageName());
            imgView.setImageResource(id);
            txtName.setText(food.getFoodName());
            txtPrice.setText(formatVnCurrence(this, food.getFoodPrice() + ""));
            txtDescripton.setText(food.getFoodDes());
            editText = (EditText) findViewById(R.id.editQuantity);
            Toast.makeText(this, editText.getText() + "", Toast.LENGTH_SHORT).show();

            btnAdd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showDialog();
                }
            });


        } catch (Exception e) {
            Log.e("MSG", e.getMessage());
        }




    }

    public void showDialog() {
        dialog = new Dialog(SingleViewActivity.this);
        dialog.setTitle("Chọn số lượng món ăn");
        dialog.setContentView(R.layout.dialog);

        dialog.show();
    }

    public void OnClick(View v) {
        switch (v.getId()) {
            case R.id.btnOK:
                boolean checkInsert = false;
                try {
                    if (editText.getText() != null || !editText.getText().equals("")) {
                        numberOrder = Integer.parseInt(editText.getText().toString());
                    }
                    numberTable+=1;
                    orderEntities.setFoodOrderQuantity(numberOrder);
                    orderEntities.setTableNo(numberTable);
                    orderEntities.setEmployeeId(employeeId);
                    orderEntities.setFoodId(position);
                    if(numberTable<10){
                        orderEntities.setOrderId(employeeId+"-00"+numberTable);
                    }else{
                        orderEntities.setOrderId(employeeId+"-0"+numberTable);
                    }

                    checkInsert = new SingleViewDao().addImployee(orderEntities, total);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                if (checkInsert) {
                //    dialog.hide();
                    Intent i = new Intent(this,FoodApp.class);
                    i.putExtra("number",numberOfFood);
                    setResult(200, i);
                    dialog.cancel();
                    finish();

                } else Toast.makeText(this, "Something wrong !!!", Toast.LENGTH_SHORT).show();


            case R.id.btnCancel:

                dialog.hide();
                break;

        }

    }


}
