package com.example.mvpdraggerretrofit.Api;

import com.example.mvpdraggerretrofit.Presenter.NewsPresenter;
import com.example.mvpdraggerretrofit.Ui.MainActivity;

import dagger.Component;
import retrofit2.Retrofit;

/**
 * Created by XmacZone on 16/9/27.
 */

@Component(modules = {RetrofitClient.class})
public interface AppComponent {
    Retrofit retrofit();

    void inject(MainActivity mainActivity);

}
