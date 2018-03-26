package com.example.admin.androidproject;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.androidproject.Entities.FoodInOrderEntities;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.List;
import java.util.Locale;

/**
 * Created by ThangOcCho on 3/22/2018.
 */

public class FoodListViewAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<FoodInOrderEntities> foodList;

    @Override
    public int getCount() {
        return foodList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    public FoodListViewAdapter(Context context, int layout, List<FoodInOrderEntities> foodList) {
        this.context = context;
        this.layout = layout;
        this.foodList = foodList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        FoodListViewAdapter.ViewHolder holder;
        if (view  == null){
            LayoutInflater li;
            li = LayoutInflater.from(getContext());
            view = li.inflate(R.layout.activity_custom_food_list_view, null);
            holder = new FoodListViewAdapter.ViewHolder();
            holder.imageView = (ImageView) view.findViewById(R.id.imageView);
            holder.foodName = (TextView) view.findViewById(R.id.foodNameTextView);
            holder.foodQuantity =(TextView) view.findViewById(R.id.quantityTextView);
            holder.foodPrice =(TextView) view.findViewById(R.id.priceTextView);

            view.setTag(holder);
        }else{
            holder = (FoodListViewAdapter.ViewHolder) view.getTag();
        }
        FoodInOrderEntities food = foodList.get(position);

        if(food != null) {
            TextView foodName = (TextView) view.findViewById(R.id.foodNameTextView);
            foodName.setText(food.getFoodName());
            TextView foodQuantity = (TextView) view.findViewById(R.id.quantityTextView);
            foodQuantity.setText(String.valueOf(food.getQuanlity()));
            TextView foodPrice = (TextView) view.findViewById(R.id.priceTextView);
            foodPrice.setText(formatVnCurrence(context,food.getPrice()+""));
            ImageView foodImg = (ImageView) view.findViewById(R.id.foodImage);
            int id = context.getResources().getIdentifier(foodList.get(position).getFoodImg() + "", "drawable", context.getPackageName());
            foodImg.setImageResource(id);
        }

        return view;
    }

    public Context getContext() {
        return context;
    }

    public class ViewHolder{
        ImageView imageView;
        TextView foodName;
        TextView foodQuantity;
        TextView foodPrice;
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
