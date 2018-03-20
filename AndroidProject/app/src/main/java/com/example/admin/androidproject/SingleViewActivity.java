package com.example.admin.androidproject;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.androidproject.DAO.SingleViewDao;
import com.example.admin.androidproject.Entities.FoodEntities;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_view2);

        Intent i = getIntent();
        imgView = (ImageView) findViewById(R.id.imageFood);
        txtName = (TextView) findViewById(R.id.txtNameFood);
        txtPrice = (TextView) findViewById(R.id.txtPrice);
        txtDescripton = (TextView) findViewById(R.id.txtArea);
        btnAdd = (Button) findViewById(R.id.btnAddToCart);
        btnOK = (Button) findViewById(R.id.btnOK);
        String position = i.getExtras().getString("id");
        int total = i.getExtras().getInt("total");
        try {
            singleViewDao = new SingleViewDao();
            food = singleViewDao.getInfoFood(position);


            int id = this.getResources().getIdentifier(food.getFoodImg() + "", "drawable", this.getPackageName());
            imgView.setImageResource(id);
            txtName.setText(food.getFoodName());
            txtPrice.setText(formatVnCurrence(this, food.getFoodPrice() + ""));
            txtDescripton.setText(food.getFoodDes());


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
        switch (v.getId()){
            case R.id.btnOK:

                dialog.hide();
                break;
            case R.id.btnCancel:

                dialog.hide();
                break;

        }

    }


}
