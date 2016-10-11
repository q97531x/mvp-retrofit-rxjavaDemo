package com.example.mvpdraggerretrofit.Api;

import dagger.Module;

/**
 * Created by XmacZone on 16/9/26.
 * 创建Retrofit实例
 */


public class ApiBuilder {
    private static NewsApiService service;

    /*public static NewsApiService getNewsService(){
        if(service == null){
            service = RetrofitClient.createApi(NewsApiService.class,RetrofitClient.getRetrofit());
        }
        return service;
    }*/
}
