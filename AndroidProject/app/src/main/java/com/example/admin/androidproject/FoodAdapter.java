package com.example.admin.androidproject;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.androidproject.Entities.FoodEntities;

import org.w3c.dom.Text;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;
import java.util.Locale;

/**
 * Created by Admin on 3/19/2018.
 */

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.ViewHolder> {
    private Context mContext;
    private ItemClickListener clickListener;
    private List<FoodEntities> mList;

    public FoodAdapter(Context context, List<FoodEntities> list) {
        mContext = context;
        mList = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        View view = layoutInflater.inflate(R.layout.rv_food, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        FoodEntities foodItem = mList.get(position);
        ImageView image = holder.imgView;
        TextView name, place, price;
        name = holder.itemName;
        place = holder.itemPlace;
        price = holder.itemPrice;
        String nameImg = mList.get(position).getFoodImg();


        int id = mContext.getResources().getIdentifier(mList.get(position).getFoodImg() + "", "drawable", mContext.getPackageName());
        image.setImageResource(id);

        //image.setImageResource(mList.get(position).getImg());
        name.setText(foodItem.getFoodName());

        price.setText(formatVnCurrence(mContext,foodItem.getFoodPrice()+""));
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
        TextView itemName, itemPrice, itemPlace;

        public ViewHolder(View itemView) {
            super(itemView);
            itemName = itemView.findViewById(R.id.itemName);
            itemPlace = itemView.findViewById(R.id.itemPlace);
            itemPrice = itemView.findViewById(R.id.textPrice);
            imgView = itemView.findViewById(R.id.imgView);
            itemView.setOnClickListener(this);

        }


        @Override
        public void onClick(View v) {
            if (clickListener != null) clickListener.onClick(v, getAdapterPosition());
        }
    }

    public static String formatVnCurrence(Context context, String price) {

        NumberFormat format =
                new DecimalFormat("#,##0.00");// #,##0.00 ¤ (¤:// Currency symbol)
        format.setCurrency(Currency.getInstance(Locale.US));//Or default locale

        price = (!TextUtils.isEmpty(price)) ? price : "0";
        price = price.trim();
        price = format.format(Double.parseDouble(price));
        price = price.replaceAll(",", "\\.");

        if (price.endsWith(".00")) {
            int centsIndex = price.lastIndexOf(".00");
            if (centsIndex != -1) {
                price = price.substring(0, centsIndex);
            }
        }
        price = String.format("%s đ", price);
        return price;
    }
}
