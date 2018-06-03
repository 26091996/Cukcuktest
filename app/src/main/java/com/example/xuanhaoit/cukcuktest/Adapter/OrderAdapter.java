package com.example.xuanhaoit.cukcuktest.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.xuanhaoit.cukcuktest.R;

import java.util.List;

/**
 * Created by leroi on 11/08/2017.
 */

public class OrderAdapter extends BaseAdapter {
    Context mContext;
    List<String> list;
    LayoutInflater layoutInflater;

    public OrderAdapter(Context mContext, List<String> list){
        this.mContext = mContext;
        this.list = list;

    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        convertView = layoutInflater.inflate(R.layout.item_order,null);
        TextView txt = (TextView) convertView.findViewById(R.id.txt_Ban);
        txt.setText(list.get(position));
        return convertView;
    }
}
