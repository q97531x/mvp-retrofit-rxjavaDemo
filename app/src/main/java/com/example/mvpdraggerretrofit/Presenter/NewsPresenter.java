package com.example.mvpdraggerretrofit.Presenter;

import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.example.mvpdraggerretrofit.Api.AppComponent;
import com.example.mvpdraggerretrofit.Api.DaggerAppComponent;
import com.example.mvpdraggerretrofit.Api.NewsApiService;
import com.example.mvpdraggerretrofit.Api.RetrofitClient;
import com.example.mvpdraggerretrofit.Base.ArrayResponse;
import com.example.mvpdraggerretrofit.Base.NewsContract;
import com.example.mvpdraggerretrofit.Model.BasNewsListBean;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by XmacZone on 16/9/27.
 */

public class NewsPresenter implements NewsContract.Presenter{

    private NewsContract.View view;
    private Retrofit retrofit;
    private AppComponent appComponent;

    @Inject
    public NewsPresenter(NewsContract.View view) {
        this.view = view;
        view.setPresenter(this);
        appComponent = DaggerAppComponent.builder().retrofitClient(new RetrofitClient()).build();
    }

    @Override
    public void load() {
        retrofit = appComponent.retrofit();
        NewsApiService newsApiService = retrofit.create(NewsApiService.class);
        newsApiService.getNews("3LtHQN51B57rQnvP_BDZDJ","330100001","0")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<String>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        view.showError(e.toString());
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e("response",s);
                        ArrayResponse<BasNewsListBean> result = JSON.parseObject(s, new TypeReference<ArrayResponse<BasNewsListBean>>() {
                        });
                        view.showData(result.getValue());
                    }
                });
        /*Call<String> call = newsApiService.getNews("3LtHQN51B57rQnvP_BDZDJ","330100001","0");
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Log.e("response",response.message()+response.body());
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
        });*/

    }

    @Override
    public void start() {
        load();
    }
}
