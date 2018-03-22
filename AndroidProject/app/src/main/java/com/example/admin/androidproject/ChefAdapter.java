package com.example.admin.androidproject;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.androidproject.Entities.ChefEntities;
import com.example.admin.androidproject.Entities.FoodEntities;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.List;
import java.util.Locale;

/**
 * Created by TUMG on 21/03/2018.
 */

public class ChefAdapter extends RecyclerView.Adapter<ChefAdapter.ViewHolder> {
    private Context mContext;
    private ItemClickListener clickListener;
    private List<ChefEntities> mList;
    private ViewHolder holder;
    private int position;

    public ChefAdapter(Context context, List<ChefEntities> list) {
        mContext = context;
        mList = list;
    }

    @Override
    public ChefAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        View view = layoutInflater.inflate(R.layout.chef_item_layout, parent, false);
        ChefAdapter.ViewHolder viewHolder = new ChefAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ChefAdapter.ViewHolder holder, int position) {
        this.holder = holder;
        this.position = position;
        ChefEntities foodItem = mList.get(position);
        ImageView image = holder.imgView;
        TextView name,quantity, status;
        quantity = holder.itemQuantity;
        name = holder.itemName;
        status = holder.textStatus;
        int nameImg = mList.get(position).getFoodImg();


        int id = mContext.getResources().getIdentifier(mList.get(position).getFoodImg() + "", "drawable", mContext.getPackageName());
        image.setImageResource(id);

        //image.setImageResource(mList.get(position).getImg());
        name.setText(foodItem.getFoodName());


    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void setClickListener(ItemClickListener itemClickListener) {
        this.clickListener = itemClickListener;
    }



    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imgView;
        TextView itemName, itemQuantity,textStatus;

        public ViewHolder(View itemView) {
            super(itemView);
            itemName = itemView.findViewById(R.id.itemName);
            itemQuantity = itemView.findViewById(R.id.itemQuantity);
            textStatus = itemView.findViewById(R.id.textStatus);
            imgView = itemView.findViewById(R.id.imgView);
            itemView.setOnClickListener(this);

        }


        @Override
        public void onClick(View v) {
            if (clickListener != null) clickListener.onClick(v, getAdapterPosition());
        }
    }


}