package com.ronit.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

class ShoppingLIstAdapterd extends BaseAdapter {
    private Context context;
    private ArrayList<ShoppingList> itemlist;
    public ShoppingLIstAdapterd(Context c, ArrayList<ShoppingList> sl) {
        this.itemlist = sl;
        this.context = c;
    }
    @Override
    public int getCount() {
        return itemlist.size();
    }

    @Override
    public Object getItem(int position) {
        return itemlist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    static class ViewHolder{
        public View name;
        CheckBox checkBox;
        TextView textView;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;

        if(view==null){
            view = LayoutInflater.from(context).inflate(R.layout.list_items, viewGroup, false);
            viewHolder = new ViewHolder();
            viewHolder.checkBox = view.findViewById(R.id.itemCheckBox);
            viewHolder.name = view.findViewById(R.id.itemTextVIew);
            view.setTag(viewHolder);
        }
        else {
           viewHolder =  (ViewHolder) view.getTag();
        }
        ShoppingList currentItem = itemlist.get(i);
        viewHolder.checkBox.setText(currentItem.name);
        viewHolder.checkBox.setChecked(currentItem.isCompleted);

        viewHolder.checkBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
           currentItem.isCompleted = isChecked;
        });

        return view;
    }
}