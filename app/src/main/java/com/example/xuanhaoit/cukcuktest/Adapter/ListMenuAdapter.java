package com.example.xuanhaoit.cukcuktest.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.xuanhaoit.cukcuktest.Model.Product;
import com.example.xuanhaoit.cukcuktest.R;
import com.example.xuanhaoit.cukcuktest.Utils.StringUtils;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by XuanHaoIT on 26/09/2017.
 */

public class ListMenuAdapter extends RecyclerView.Adapter<ListMenuAdapter.ItemHodler> {

    Context context;
    List<Product> list;

    public ListMenuAdapter(Context context, List<Product> list) {
        this.context = context;
        this.list = list;
    }

    public List<Product> getList() {
        return list;
    }

    @Override
    public ItemHodler onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_menu, null);
        return new ItemHodler(v);
    }

    @Override
    public void onBindViewHolder(final ItemHodler holder, final int position) {

        String uriImage = "http://192.168.1.16:8080/img/";

        Glide.with(context).load(uriImage+list.get(position).getProductImage()).into(holder.imageView);
        holder.txtTenMon.setText(list.get(position).getProductName());
        holder.txtGia.setText(StringUtils.formatCurrency(list.get(position).getProductPrice()));
        holder.txtSoLuong.setText(holder.i + "");
        holder.frame_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.linearLayout.setVisibility(View.VISIBLE);
                list.get(position).setVisibility(true);
                list.get(position).setQuanity(holder.i);

            }
        });
        holder.btn_minus.setClickable(true);
        holder.btn_plus.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.i = holder.i + 1;
                holder.txtSoLuong.setText(holder.i + "");
                list.get(position).setQuanity(holder.i);
            }
        });
        holder.btn_minus.setClickable(true);
        holder.btn_minus.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.i = holder.i - 1;
                holder.txtSoLuong.setText(holder.i + "");
                if (holder.i <= 0) {
                    holder.linearLayout.setVisibility(View.GONE);
                    list.get(position).setVisibility(false);
                }
                list.get(position).setQuanity(holder.i);
            }
        });
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ItemHodler extends RecyclerView.ViewHolder {
        CircleImageView imageView;
        TextView txtTenMon, txtGia;
        LinearLayout linearLayout;
        FrameLayout frame_menu;
        CircleImageView btn_plus, btn_minus;
        ImageView btn_tick;
        TextView txtSoLuong;
        Button btn_HuyBo, btn_DongY;
        int i = 1;

        ItemHodler(View itemView) {
            super(itemView);
            imageView = (CircleImageView) itemView.findViewById(R.id.AnhMon);
            txtGia = (TextView) itemView.findViewById(R.id.txtGia);
            txtTenMon = (TextView) itemView.findViewById(R.id.txtTenMon);
            linearLayout = (LinearLayout) itemView.findViewById(R.id.layuotDetail);
            frame_menu = (FrameLayout) itemView.findViewById(R.id.frame_menu);
            btn_minus = (CircleImageView) itemView.findViewById(R.id.btn_Minus);
            btn_plus = (CircleImageView) itemView.findViewById(R.id.btn_Plus);
            btn_tick = (ImageView) itemView.findViewById(R.id.btn_tick);
            txtSoLuong = (TextView) itemView.findViewById(R.id.btn_soLuong);

        }
    }
}
