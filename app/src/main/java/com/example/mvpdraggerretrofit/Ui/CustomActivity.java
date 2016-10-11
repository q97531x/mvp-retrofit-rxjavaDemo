package com.example.mvpdraggerretrofit.Ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.mvpdraggerretrofit.R;
import com.example.mvpdraggerretrofit.View.TDView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class CustomActivity extends AppCompatActivity {
    @Bind(R.id.TD)
    TDView tdView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom);
        ButterKnife.bind(this);
    }
}
