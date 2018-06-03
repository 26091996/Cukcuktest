package com.example.xuanhaoit.cukcuktest.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.xuanhaoit.cukcuktest.Model.Area;
import com.example.xuanhaoit.cukcuktest.Model.Bill;
import com.example.xuanhaoit.cukcuktest.Model.DinnerTable;
import com.example.xuanhaoit.cukcuktest.Model.list_order;
import com.example.xuanhaoit.cukcuktest.R;
import com.example.xuanhaoit.cukcuktest.View.Diagrams.IDiagrams;
import com.example.xuanhaoit.cukcuktest.View.Order.Order_Detail;

import java.util.List;

public class listOrderAdapter extends RecyclerView.Adapter<listOrderAdapter.OrderHolder> {
    private Context context;
    private List<Bill> orderList;
    private List<DinnerTable> tableList;
    private String Ban;
    private int SoNguoi;
    private int idBill;
    public listOrderAdapter(Context context, List<Bill> orderList, List<DinnerTable> tableList)
    {
        this.context = context;
        this.orderList = orderList;
        this.tableList = tableList;
    }

    @NonNull
    @Override
    public OrderHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_list_order, parent, false);

        return new OrderHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final OrderHolder holder, final int position) {
            for(int j=0;j<tableList.size();j++)
            if (orderList.get(position).getDinnerTableID() == tableList.get(j).getDinnerTableID())
            {
                Ban = tableList.get(position).getDinnerTableName();
                Log.d("ban",tableList.get(position).getDinnerTableName());
                holder.tvOrderCustomer.setText(Ban);
                SoNguoi = tableList.get(position).getDinnerTableQuanity();
            }

        String orderDate = "Thời gian vào: " + orderList.get(position).getBillDate();
//        String deliveryDate = "Ngày Giao: " + order.getNgayGiao();
        holder.tvOrderDate.setText(orderDate);

//        holder.tvDeliveryDate.setText(deliveryDate);
//        holder.tvOrderTotal.setText(StringUtil.formatCurrency(order.getTongTien()));
        holder.tvOrderTotal.setText(orderList.get(position).getGrandTotal()+"");

        String text;
        int res;
        int color;

        switch (orderList.get(position).getStatus()) {
            case 0:
                text = "Đang đợi món";
                res = R.drawable.bkg_orange;
                color = R.color.deep_orange;
                break;
            case 1:
                text = "Đang dùng";
                res = R.drawable.bkg_green;
                color = R.color.green_a400;
                break;
//            case 2:
//                text = "Đã Bán Hàng";
//                res = R.drawable.bkg_blue;
//                color = R.color.indigo;
//                break;
            default:
                text = null;
                res = 0;
                color = 0;
                break;

        }
        if (text != null && res != 0 && color != 0) {
            holder.tvOrderStatus.setText(text);
            holder.tvOrderStatus.setTextColor(context.getResources().getColor(color));
            holder.tvOrderStatus.setBackgroundResource(res);
        }


    }


    @Override
    public int getItemCount() {
        return orderList.size();
    }

    class OrderHolder extends RecyclerView.ViewHolder {

        TextView tvOrderCustomer,tvOrderAddress,tvOrderDate,tvDeliveryDate,tvOrderTotal,tvOrderStatus;

        OrderHolder(final View itemView) {
            super(itemView);
            tvOrderCustomer = itemView.findViewById(R.id.tv_order_customer);
            tvOrderAddress = itemView.findViewById(R.id.tv_order_address);
            tvOrderDate = itemView.findViewById(R.id.tv_order_date);
//            tvDeliveryDate  = itemView.findViewById(R.id.tv_delivery_date);
            tvOrderTotal = itemView.findViewById(R.id.tv_listorder_total);
            tvOrderStatus = itemView.findViewById(R.id.tv_order_status);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, Order_Detail.class);
                    Bill bill = orderList.get(getAdapterPosition());
                    intent.putExtra("pos",getAdapterPosition());
                    context.startActivity(intent);
                }
            });
        }
    }
}
