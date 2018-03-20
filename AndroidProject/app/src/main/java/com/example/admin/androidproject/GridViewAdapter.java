package com.example.admin.androidproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.androidproject.Entities.FoodEntities;

/**
 * Created by Admin on 3/20/2018.
 */

public class GridViewAdapter extends BaseAdapter {
    private Context context;
    private String[] tenLogo;
    private int[] hinhLogo;
    private FoodEntities food;

    public GridViewAdapter(Context context, String[] tenLogo, int[] hinhLogo) {
        this.context = context;
        this.tenLogo = tenLogo;
        this.hinhLogo = hinhLogo;
    }

    @Override
    public int getCount() {
        return tenLogo.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        convertView = layoutInflater.inflate(R.layout.girdview_row,null);
        TextView textView =(TextView) convertView.findViewById(R.id.textViewLogo);

        ImageView imageView = (ImageView) convertView.findViewById(R.id.imageViewLogo);

        textView.setText(tenLogo[position]);
        imageView.setImageResource(hinhLogo[position]);
        return convertView;
    }
}
