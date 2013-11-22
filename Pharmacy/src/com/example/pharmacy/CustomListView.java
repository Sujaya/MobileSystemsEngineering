package com.example.pharmacy;



import java.util.List;


import android.app.Activity;
import android.content.Context;
import android.graphics.Color;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;




public class CustomListView extends ArrayAdapter<Medicine> {
 
    Context context;
    private final List<Medicine> lt;
    
    public CustomListView(Context context, int resourceId,
            List<Medicine> items) {
        super(context, resourceId, items);
        this.context = context;
        this.lt=items;
    }
 
    /*private view holder class*/
    private class ViewHolder {
        TextView txtName;
        TextView txtQuantity;
        
    }
 
    public View getView(int position, View convertView, ViewGroup parent) {
       ViewHolder holder = null;
        Medicine medicine = getItem(position);
 
        LayoutInflater mInflater = (LayoutInflater) context
                .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.list_item, null);
            mInflater.inflate(R.layout.list_item, null);
            holder = new ViewHolder();
            holder.txtName = (TextView) convertView.findViewById(R.id.name);
            holder.txtQuantity = (TextView) convertView.findViewById(R.id.quantity);
            
            convertView.setTag(holder);
            
        } 
        else
        	holder=((ViewHolder)convertView.getTag());
        
        
         ViewHolder vh = (ViewHolder)convertView.getTag();
        vh.txtName.setTextColor(Color.BLACK);
        vh.txtName.setText(medicine.getName());
        vh.txtQuantity.setTextColor(Color.BLACK);
        vh.txtQuantity.setText(medicine.getQuantity());
        
      
        return convertView;
    }
}

