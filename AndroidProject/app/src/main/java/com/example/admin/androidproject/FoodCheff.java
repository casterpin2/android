package com.example.admin.androidproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.GridView;
import android.widget.Toast;

import com.example.admin.androidproject.DAO.FoodDAO;
import com.example.admin.androidproject.Entities.ChefEntities;
import com.example.admin.androidproject.Entities.FoodEntities;

import java.util.List;

public class FoodCheff extends AppCompatActivity implements ItemClickListener {
    RecyclerView recyclerView;
    private GridView gridView;
    private int numberOfFood;

    List<ChefEntities> chefEntities;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_cheff);
        if(getIntent() != null)
        {
         //   String info = getIntent().getStringExtra("info");
          //  numberOfFood = Integer.parseInt(info);
            //Toast.makeText(this, info + "", Toast.LENGTH_LONG).show();
        }
        try{
            chefEntities = new FoodDAO().getOrder(1);



            ChefAdapter adapter = new ChefAdapter(this,chefEntities );
            recyclerView.setAdapter(adapter);
            adapter.setClickListener(this);

        }catch(Exception e){
            Log.e("MSG",e.getMessage());
        }
    }


    @Override
    public void onClick(View view, int position) {
        ChefEntities chef= chefEntities.get(position);
        Intent i = new Intent(this, SingleViewActivity.class);
        i.putExtra("id", chef.getOrderId());
        i.putExtra("total",chef.getFoodQuantity());
        Log.i("hello", chef.getFoodName());
        startActivity(i);
    }
}
