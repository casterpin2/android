package com.example.admin.androidproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.admin.androidproject.DAO.ProductViewDAO;
import com.example.admin.androidproject.Entities.FoodEntities;
import com.example.admin.androidproject.ItemClickListener;
import com.example.admin.androidproject.ModelFood;

import java.util.ArrayList;
import java.util.List;

public class FoodApp extends AppCompatActivity implements ItemClickListener {

    RecyclerView recyclerView;
    private int numberOfFood;
    private ProductViewDAO productViewDAO;
    private List<FoodEntities> listFood;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_app);

        if(getIntent() != null)
        {
            String info = getIntent().getStringExtra("info");
            numberOfFood=Integer.parseInt(info);
            Toast.makeText(this, info+"", Toast.LENGTH_LONG).show();
        }
        productViewDAO = new ProductViewDAO();
        try{
            switch (numberOfFood){
                case 0 :
                    listFood =  productViewDAO.getFoodByType(1);
                    break;
                case 1 :
                    listFood =  productViewDAO.getFoodByType(2);
                    break;
                case 2 :
                    listFood =  productViewDAO.getFoodByType(3);
                    break;
                case 3 :
                    listFood =  productViewDAO.getFoodByType(4);
                    break;
            }




        recyclerView = findViewById(R.id.rv);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        RecyclerView.LayoutManager rvLilayoutManager = layoutManager;
        recyclerView.setLayoutManager(rvLilayoutManager);

        FoodAdapter adapter = new FoodAdapter(this,listFood);
        recyclerView.setAdapter(adapter);
        adapter.setClickListener(this);
        }catch(Exception e){
            Log.e("MSG",e.getMessage());
        }
    }

    @Override
    public void onClick(View view, int position) {
        FoodEntities food = listFood.get(position);
        Intent i = new Intent(this, SingleViewActivity.class);
        i.putExtra("id", food.getFoodId());
        i.putExtra("total",food.getFoodQuantity());
        Log.i("hello", food.getFoodName());
        startActivity(i);
    }



}
