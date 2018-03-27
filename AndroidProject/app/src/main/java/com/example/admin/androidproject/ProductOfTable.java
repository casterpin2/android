package com.example.admin.androidproject;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;

public class ProductOfTable extends AppCompatActivity {
    private int numberTable;
    private GridLayout gridLayout;
    String employeeId;
    String info;
    int roleId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_of_table);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.logo_restaurant);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.WHITE));


        if(getIntent() != null)
        {
            info = getIntent().getStringExtra("info");
            numberTable=Integer.parseInt(info);
            employeeId = getIntent().getStringExtra("employeeId");
            roleId = getIntent().getExtras().getInt("roleId");
            Toast.makeText(this, info+"", Toast.LENGTH_LONG).show();
        }

        gridLayout = (GridLayout) findViewById(R.id.mainGridOfProduct);

        //Set Event
        setSingleEvent(gridLayout);

    }

    private void setSingleEvent(GridLayout mainGrid) {
        //Loop all child item of Main Grid
        for (int i = 0; i < mainGrid.getChildCount(); i++) {
            //You can see , all child item is CardView , so we just cast object to CardView
            CardView cardView = (CardView) mainGrid.getChildAt(i);
            final int finalI = i;
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent intent = new Intent(ProductOfTable.this,FoodApp.class);
                    intent.putExtra("info",""+finalI);
                    intent.putExtra("tableNo",numberTable);
                    intent.putExtra("employeeId",employeeId+"");
                    startActivity(intent);

                }
            });
        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:

                Intent intent  = new Intent(this,ProductViewActivity.class);
                intent.putExtra("employeeId",employeeId+"");
                intent.putExtra("roleId",roleId);
                startActivity(intent);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
