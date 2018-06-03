package com.example.xuanhaoit.cukcuktest.Utils;

import com.example.xuanhaoit.cukcuktest.CallBack.IService;

public class ApiUtils {

    private static final String BASE_URL = "http://192.168.1.16:8080/";

    public static IService getService()
    {
        return RetrofitClient.getClient(BASE_URL).create(IService.class);
    }
}