package com.example.admin.androidproject;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.print.PrintHelper;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.sql.SQLException;

public class PaymentSuccess extends AppCompatActivity {

    Button backHomeBtn = null;
    Button printBtn =null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_success);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.logo_restaurant);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.WHITE));

        backHomeBtn = (Button) findViewById(R.id.backhomeBtn);
        backHomeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PaymentSuccess.this, ViewOrderListByCasher.class);
                startActivity(intent);
            }
        });

        printBtn = (Button) findViewById(R.id.printvatBtn);
        printBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Print API
//                PrintHelper printHelper = new PrintHelper(getApplication());
//                printHelper.getScaleMode();
//
//                Bitmap bitmap = new BitmapFactory().decodeResource(getResources(),R.drawable.so1);
//                printHelper.printBitmap("so1 - print",bitmap);



                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
// Add the buttons
                builder.setPositiveButton("Done", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                    }
                });
                builder.setTitle("Print VAT Bill");
                builder.setMessage("You printed VAT bill successfully! Get bill....");
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
                alertDialog.getButton(android.app.AlertDialog.BUTTON_POSITIVE).setTextColor(Color.BLUE);
            }
        });
    }
}
