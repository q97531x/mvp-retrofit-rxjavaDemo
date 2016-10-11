package com.example.mvpdraggerretrofit.Presenter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.mvpdraggerretrofit.Model.BasNewsListBean;
import com.example.mvpdraggerretrofit.R;

import java.util.List;

/**
 * Created by XmacZone on 16/9/28.
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.MyViewHolder>{
    private List<BasNewsListBean> newsList;
    private Context context;
    public NewsAdapter(Context context) {
        this.context = context;
    }

    public void setDataList(List<BasNewsListBean> list){
        newsList = list;
    }

    @Override
    public int getItemCount() {
        return newsList == null ? 0:newsList.size();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder holder = new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_news,parent,false));
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.tv.setText(newsList.get(position).getTitle());
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tv;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.tv = (TextView)itemView.findViewById(R.id.news_title);
        }
    }
}
