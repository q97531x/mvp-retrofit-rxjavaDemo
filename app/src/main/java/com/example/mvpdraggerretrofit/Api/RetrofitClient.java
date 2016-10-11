package com.example.mvpdraggerretrofit.Api;

import android.content.Context;

import com.example.mvpdraggerretrofit.Base.NewsContract;
import com.example.mvpdraggerretrofit.Presenter.NewsPresenter;
import com.example.mvpdraggerretrofit.Ui.MainActivity;

import java.util.concurrent.TimeUnit;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by XmacZone on 16/9/26.
 */

@Module
public class RetrofitClient {

//    private final Context context;

    /*public RetrofitClient(Context context) {
        this.context = context;
    }*/

    @Provides
    public OkHttpClient provideOKHttpClient(){
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .build();
        return okHttpClient;
    }

    @Provides
    public static Retrofit getRetrofit(OkHttpClient okHttpClient) {
        return new Retrofit.Builder().baseUrl("http://www.vomoho.com/vomoho/api/news/")
                .addConverterFactory(ScalarsConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(okHttpClient)
                .build();
    }

    @Provides
    public NewsContract.View createView(){
        MainActivity activity = new MainActivity();
        return activity;
    }

    @Provides
    public NewsPresenter createPresenter(NewsContract.View view){
        return new NewsPresenter(view);
    }
    /*@Provides
    public static <T> T createApi(Class<T> clazz, Retrofit retrofit) {
        return retrofit.create(clazz);
    }*/
}
