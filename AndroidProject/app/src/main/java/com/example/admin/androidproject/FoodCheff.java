package com.example.admin.androidproject;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.GridView;
import android.widget.Toast;

import com.example.admin.androidproject.DAO.FoodDAO;
import com.example.admin.androidproject.Entities.ChefEntities;
import com.example.admin.androidproject.Entities.FoodEntities;

import java.util.Date;
import java.util.List;

public class FoodCheff extends AppCompatActivity implements ItemClickListener {
    RecyclerView recyclerView;
    private GridView gridView;
    private int numberOfFood;

    List<ChefEntities> chefEntities;
    private ChefAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_listview_chef);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.logo_restaurant);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.WHITE));
        String nameOrder = "";
        String date = "";
        if(getIntent() != null)
        {
            String info = getIntent().getStringExtra("tableNo");
            numberOfFood = Integer.parseInt(info);
            nameOrder = getIntent().getStringExtra("employeeNameOrder");
            date = getIntent().getStringExtra("orderTime");
        }
        try{
            chefEntities = new FoodDAO().getOrder(numberOfFood);



        }catch(Exception e){
            Log.e("MSG",e.getMessage());
        }
        recyclerView = findViewById(R.id.rvChef);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        RecyclerView.LayoutManager rvLilayoutManager = layoutManager;
        recyclerView.setLayoutManager(rvLilayoutManager);

        adapter = new ChefAdapter(this,chefEntities);
        recyclerView.setAdapter(adapter);
        adapter.setClickListener(this);

    }


    @Override
    public void onClick(View view, int position) {
        ChefEntities chef = chefEntities.get(position);
        boolean checkUpdate = false;
        try{
            checkUpdate = new FoodDAO().updateOrderStatus(chef.getOrderId());
        }catch (Exception e){
            Log.e("abc",e.getMessage());
        }
        if(checkUpdate){
            chefEntities.remove(position);
            Toast.makeText(this, "OK", Toast.LENGTH_SHORT).show();
            adapter.notifyDataSetChanged();
        }else Toast.makeText(this, "Something Wrong", Toast.LENGTH_SHORT).show();

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0){
            return true;
        }
        return super.onKeyDown(keyCode,event);
    }

//    @Override
//    public void onBackPressed() {
//        return;
//    }
}
