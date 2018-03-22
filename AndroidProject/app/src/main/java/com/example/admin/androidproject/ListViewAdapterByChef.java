package com.example.admin.androidproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.androidproject.Entities.ChefEntities;
import com.example.admin.androidproject.Entities.OrderForCasherEntities;

import java.util.List;

/**
 * Created by Admin on 3/23/2018.
 */

public class ListViewAdapterByChef extends BaseAdapter {

    private Context context;
    private int layout;
    private List<ChefEntities> list;

    public ListViewAdapterByChef() {
    }

    public ListViewAdapterByChef(Context context, int layout, List<ChefEntities> list) {
        this.context = context;
        this.layout = layout;
        this.list = list;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public int getLayout() {
        return layout;
    }

    public void setLayout(int layout) {
        this.layout = layout;
    }

    public List<ChefEntities> getList() {
        return list;
    }

    public void setList(List<ChefEntities> list) {
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
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



        ListViewAdapter.ViewHolder holder;
        if (convertView  == null){
            LayoutInflater li;
            li = LayoutInflater.from(getContext());
            convertView = li.inflate(R.layout.activity_custom_list_view, null);
            holder = new ListViewAdapter.ViewHolder();
            holder.imageView = (ImageView) convertView.findViewById(R.id.imageView);
            holder.txtID = (TextView) (TextView) convertView.findViewById(R.id.orderID);
            holder.txtEmployeeName = (TextView) convertView.findViewById(R.id.employeeID);
            System.out.println("A");
            convertView.setTag(holder);
        }else{
            holder = (ListViewAdapter.ViewHolder) convertView.getTag();
        }
        ChefEntities order = list.get(position);
        if(order != null) {
            System.out.println("B");
            TextView orderID = (TextView) convertView.findViewById(R.id.orderID);
            order.setOderByName(order.getOrderId());
            TextView employeeName = (TextView) convertView.findViewById(R.id.employeeID);
            employeeName.setText(order.getOderByName());

            holder.imageView.setImageResource(R.drawable.test);


        }

        return convertView;
    }
    public static class ViewHolder{
        ImageView imageView;
        TextView txtID;
        TextView txtEmployeeName;
    }
}
