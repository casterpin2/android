package com.example.admin.androidproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_listview_chef);
        String nameOrder = "";
        String date = "";
        if(getIntent() != null)
        {
            String info = getIntent().getStringExtra("tableNo");
            numberOfFood = Integer.parseInt(info);
            nameOrder = getIntent().getStringExtra("employeeNameOrder");
            date = getIntent().getStringExtra("orderTime");
            Toast.makeText(this, info + "", Toast.LENGTH_LONG).show();
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

        ChefAdapter adapter = new ChefAdapter(this,chefEntities);
        recyclerView.setAdapter(adapter);
        adapter.setClickListener(this);

    }


    @Override
    public void onClick(View view, int position) {

    }
}
