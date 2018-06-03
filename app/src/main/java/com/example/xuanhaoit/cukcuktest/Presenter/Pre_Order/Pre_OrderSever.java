package com.example.xuanhaoit.cukcuktest.Presenter.Pre_Order;

import android.content.Context;
import android.widget.Toast;

import com.example.xuanhaoit.cukcuktest.CallBack.IService;
import com.example.xuanhaoit.cukcuktest.Model.Bill;
import com.example.xuanhaoit.cukcuktest.Model.BillDetail;
import com.example.xuanhaoit.cukcuktest.Utils.ApiUtils;
import com.example.xuanhaoit.cukcuktest.View.Order.IOrder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Pre_OrderSever implements IPre_Order {

    IOrder iOrder;
    IService iService;
    Context context;
    public Pre_OrderSever(IOrder iOrder, Context context)
    {
        this.iOrder = iOrder;
        this.context = context;
        iService = ApiUtils.getService();
    }

    public Pre_OrderSever(Context context)
    {
        this.context = context;
        iService = ApiUtils.getService();
    }
    @Override
    public void addBill() {
        iService.addBill(iOrder.addBill()).enqueue(new Callback<Bill>() {
            @Override
            public void onResponse(Call<Bill> call, Response<Bill> response) {
                if (response.isSuccessful())
                    Toast.makeText(context, "Send success Bill", Toast.LENGTH_LONG).show();

            }

            @Override
            public void onFailure(Call<Bill> call, Throwable t) {

            }
        });
    }

    public void addBillDetail(BillDetail billDetail) {
        iService.addBillDetail(billDetail).enqueue(new Callback<BillDetail>() {
            @Override
            public void onResponse(Call<BillDetail> call, Response<BillDetail> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(context, "Send success BillDetail", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<BillDetail> call, Throwable t) {

            }
        });
    }
}
