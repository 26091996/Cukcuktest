package com.example.xuanhaoit.cukcuktest.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.example.xuanhaoit.cukcuktest.Model.Product;
import com.example.xuanhaoit.cukcuktest.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by leroi on 11/08/2017.
 */

public class OrderDetailAdapter extends RecyclerView.Adapter<OrderDetailAdapter.ItemHodler>{
    Context context;
    List<Product> list;

    public OrderDetailAdapter(Context context, List<Product> list)
    {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ItemHodler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_more_table, null);
        return new ItemHodler(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHodler holder, int position) {
        String uriImage = "http://192.168.1.16:8080/img/";


        Glide.with(context).load(uriImage+list.get(position).getProductImage()).into(holder.img_dish);
        holder.txtTenMon.setText(list.get(position).getProductName());
//        int st = list.get(position).getSoLuong()*list.get(position).getGia();
//        txt_Chitiiet.setText(list.get(position).getQuanity() + " " + list.get(position).getProductUnit() + " x " + list.get(position).getProductPrice() + "");
        holder.txtTong.setText(list.get(position).getProductPrice()*list.get(position).getQuanity()+"");
        holder.txtDVT.setText((list.get(position).getProductUnit()));
        holder.txtSoLuong.setText(list.get(position).getProductQuantity()+"");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    class ItemHodler extends RecyclerView.ViewHolder {
        CircleImageView img_dish;
        TextView txtTenMon, txtSoLuong, txtDVT, txtTong;

        ItemHodler(View itemView) {
            super(itemView);
            img_dish =itemView.findViewById(R.id.img_dish);
            txtTenMon = itemView.findViewById(R.id.txt_TenMon);
            txtSoLuong = itemView.findViewById(R.id.txt_soluong);
            txtDVT = itemView.findViewById(R.id.txt_dvt);
            txtTong = itemView.findViewById(R.id.txt_tong);

        }
    }

}
