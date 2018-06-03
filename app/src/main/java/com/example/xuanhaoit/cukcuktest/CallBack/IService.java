package com.example.xuanhaoit.cukcuktest.CallBack;

import com.example.xuanhaoit.cukcuktest.Model.Area;
import com.example.xuanhaoit.cukcuktest.Model.Bill;
import com.example.xuanhaoit.cukcuktest.Model.BillDetail;
import com.example.xuanhaoit.cukcuktest.Model.DinnerTable;
import com.example.xuanhaoit.cukcuktest.Model.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface IService {

    @GET("getArea")
    Call<List<Area>> getAreas();

    @GET("getALLDinnerTable")
    Call<List<DinnerTable>> getDinnerTables();

    @GET("getProductAll")
    Call<List<Product>> getAllProducts();

    @POST("createBill")
    Call<Bill> addBill(@Body Bill bill);

    @POST("createBillDetail")
    Call<BillDetail> addBillDetail(@Body BillDetail billDetail);
}
