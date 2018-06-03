package com.example.xuanhaoit.cukcuktest.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.xuanhaoit.cukcuktest.Model.DinnerTable;
import com.example.xuanhaoit.cukcuktest.R;

import java.util.List;

/**
 * Created by XuanHaoIT on 15/09/2017.
 */

public class GridAdapter extends BaseAdapter {
    Context mContext;
    List<DinnerTable> list;
    LayoutInflater layoutInflater;

    public GridAdapter(Context mContext, List<DinnerTable> list){
        this.mContext = mContext;
        this.list = list;

    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public DinnerTable getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public List<DinnerTable> getList() {
        return list;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        convertView = layoutInflater.inflate(R.layout.item_gridview,null);
            TextView txt = (TextView) convertView.findViewById(R.id.txt);

        txt.setBackgroundResource(R.drawable.ic_brightness_1_black_24dp);
//        list.get(position).setTenBan("T"+(list.get(position).getTang())+"."+(list.get(position).getSoBan()+1));
        txt.setText(list.get(position).getDinnerTableName());

//        convertView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
        return convertView;
    }
}
