package com.example.mvpdraggerretrofit.RecycleView;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.mvpdraggerretrofit.Presenter.NewsAdapter;
import com.example.mvpdraggerretrofit.R;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RecycleActivity extends AppCompatActivity {
    @Bind(R.id.rc_list)
    RecyclerView rcList;
    Adapter adapter;
    ArrayList<String> datas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle);
        ButterKnife.bind(this);
        datas = new ArrayList<>();
        for(int i = 0;i<6;i++){
            datas.add(i+"");
        }
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
//        linearLayoutManager.setOrientation(OrientationHelper.VERTICAL);
        rcList.setLayoutManager(linearLayoutManager);
        adapter = new Adapter(this);
        rcList.setAdapter(adapter);

    }

    @OnClick(R.id.imageBtn)
    public void Click(){
        Log.e("image","click"+(adapter==null?"is null":"not null"));
        adapter.setDatas(datas);
        adapter.notifyDataSetChanged();
    }

    class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder>{
        private ArrayList<String> list;
        private Context context;
        public Adapter(Context context) {
            this.context = context;
//            this.list = list;
        }

        public void setDatas(ArrayList<String> list){
            this.list = list;
        }

        @Override
        public int getItemCount() {
            return list == null?0:list.size();
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            MyViewHolder holder = new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_news,parent,false));
            return holder;
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            holder.tv.setText(list.get(position));
        }

        class MyViewHolder extends RecyclerView.ViewHolder{
            TextView tv;

            public MyViewHolder(View itemView) {
                super(itemView);
                this.tv = (TextView)itemView.findViewById(R.id.news_title);
            }
        }
    }
}
