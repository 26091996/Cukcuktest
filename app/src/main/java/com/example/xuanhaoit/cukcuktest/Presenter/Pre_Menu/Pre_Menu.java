package com.example.xuanhaoit.cukcuktest.Presenter.Pre_Menu;

import android.util.Log;

import com.example.xuanhaoit.cukcuktest.CallBack.IService;
import com.example.xuanhaoit.cukcuktest.Model.Product;
import com.example.xuanhaoit.cukcuktest.Utils.ApiUtils;
import com.example.xuanhaoit.cukcuktest.View.Menu.IMenu;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by XuanHaoIT on 20/09/2017.
 */

public class Pre_Menu implements IPre_Menu {

    IService iService;
    IMenu iMenu;
    public Pre_Menu(IMenu iMenu) {
        this.iMenu = iMenu;
        iService = ApiUtils.getService();
    }

    @Override
    public void GetDish() {

    }

    @Override
    public void GetDrinks() {

    }

    @Override
    public void GetAll() {
        iService.getAllProducts().enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                if (response.isSuccessful())
                    iMenu.GetDSAll(response.body());
                else {
                    int statusCode = response.code();
                    Log.d("Connect error", String.valueOf(statusCode));
                }
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {

            }
        });

    }

}
