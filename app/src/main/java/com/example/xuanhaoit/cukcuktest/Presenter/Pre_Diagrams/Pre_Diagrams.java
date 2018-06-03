package com.example.xuanhaoit.cukcuktest.Presenter.Pre_Diagrams;

import android.util.Log;

import com.example.xuanhaoit.cukcuktest.CallBack.IService;
import com.example.xuanhaoit.cukcuktest.Model.Area;
import com.example.xuanhaoit.cukcuktest.Model.DinnerTable;
import com.example.xuanhaoit.cukcuktest.Utils.ApiUtils;
import com.example.xuanhaoit.cukcuktest.View.Diagrams.IDiagrams;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by XuanHaoIT on 17/09/2017.
 */

public class Pre_Diagrams implements IPre_Diagrams {
    private IDiagrams iDiagrams;
    private IService iService;


    public Pre_Diagrams(IDiagrams iDiagrams){
        this.iDiagrams = iDiagrams;
        iService = ApiUtils.getService();
    }
    @Override
    public void GetArea() {
        iService.getAreas().enqueue(new Callback<List<Area>>() {
            @Override
            public void onResponse(Call<List<Area>> call, Response<List<Area>> response) {
                if (response.isSuccessful())
                {
                   iDiagrams.ListArea(response.body());
                } else {
                    int statusCode = response.code();
                    Log.d("Connect error", String.valueOf(statusCode));
                }
            }

            @Override
            public void onFailure(Call<List<Area>> call, Throwable t) {

            }
        });
    }

    @Override
    public void GetDinnerTable() {
        iService.getDinnerTables().enqueue(new Callback<List<DinnerTable>>() {
            @Override
            public void onResponse(Call<List<DinnerTable>> call, Response<List<DinnerTable>> response) {
                if (response.isSuccessful()) {
                    iDiagrams.ListDinnerTable(response.body());
                }else {
                    int statusCode = response.code();
                    Log.d("Connect error", String.valueOf(statusCode));
                }
            }

            @Override
            public void onFailure(Call<List<DinnerTable>> call, Throwable t) {

            }
        });
    }
}
