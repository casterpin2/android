package com.example.admin.androidproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.androidproject.Entities.OrderForCasherEntities;

import java.util.List;

/**
 * Created by ThangOcCho on 3/21/2018.
 */

public class ListViewAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<OrderForCasherEntities> list;


    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    public ListViewAdapter(Context context, int layout, List<OrderForCasherEntities> list) {
        this.context = context;
        this.layout = layout;
        this.list = list;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView;
        ViewHolder holder;
        if (view  == null){
            LayoutInflater li;
            li = LayoutInflater.from(getContext());
            view = li.inflate(R.layout.activity_custom_list_view, null);
            holder = new ViewHolder();
            holder.imageView = (ImageView) view.findViewById(R.id.imageView);
            holder.txtID = (TextView) (TextView) view.findViewById(R.id.orderID);
            holder.txtEmployeeName = (TextView) view.findViewById(R.id.employeeID);

            view.setTag(holder);
        }else{
            holder = (ViewHolder) view.getTag();
        }
        OrderForCasherEntities order = list.get(position);

//        switch (order.getTableNo()){
//            case 1:
//                holder.imageView.setImageResource(R.drawable.so1);
//                break;
//            case 2:
//                holder.imageView.setImageResource(R.drawable.so2);
//                break;
//        }
        ImageView tableNoImg = (ImageView) view.findViewById(R.id.imageView);
        int id = context.getResources().getIdentifier(list.get(position).getTableNo() + "", "drawable", context.getPackageName());
        tableNoImg.setImageResource(id);

        if(order != null) {
            TextView orderID = (TextView) view.findViewById(R.id.orderID);
            orderID.setText(String.valueOf(order.getEmployeeOrder()));
            TextView employeeName = (TextView) view.findViewById(R.id.employeeID);
            employeeName.setText(order.getEmployeeOrder());
        }

        return view;
    }

    public Context getContext() {
        return context;
    }

    public static class ViewHolder{
        ImageView imageView;
        TextView txtID;
        TextView txtEmployeeName;
    }
}
