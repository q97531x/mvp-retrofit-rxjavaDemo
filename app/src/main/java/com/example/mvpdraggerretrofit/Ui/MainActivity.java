package com.example.mvpdraggerretrofit.Ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ListView;

import com.example.mvpdraggerretrofit.Api.AppComponent;

import com.example.mvpdraggerretrofit.Api.DaggerAppComponent;
import com.example.mvpdraggerretrofit.Api.RetrofitClient;
import com.example.mvpdraggerretrofit.Base.NewsContract;
import com.example.mvpdraggerretrofit.Model.BasNewsListBean;
import com.example.mvpdraggerretrofit.Presenter.NewsAdapter;
import com.example.mvpdraggerretrofit.Presenter.NewsPresenter;
import com.example.mvpdraggerretrofit.R;

import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements NewsContract.View{
    @Inject
    NewsPresenter presenter;
    private AppComponent appComponent;
    @Bind(R.id.news_list)
    RecyclerView newsList;
    static NewsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initView();
        appComponent = DaggerAppComponent.builder().retrofitClient(new RetrofitClient()).build();
        appComponent.inject(this);
        presenter.start();
    }

    private void initView(){
//        adapter = new NewsAdapter(this);
//        Log.e("message","show:"+(adapter == null?"null":"not null")+adapter.getItemCount());

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(OrientationHelper.VERTICAL);
        newsList.setLayoutManager(linearLayoutManager);
        adapter = new NewsAdapter(this);
        newsList.setAdapter(adapter);
    }

    @OnClick(R.id.btn)
    public void OnClick(){
        Intent intent = new Intent(MainActivity.this,CustomActivity.class);
        startActivity(intent);
    }

    @Override
    public void showError(String s) {

    }

    @Override
    public void showData(List<BasNewsListBean> newsListBean) {
        adapter.setDataList(newsListBean);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void setPresenter(NewsContract.Presenter presenter) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }
}
