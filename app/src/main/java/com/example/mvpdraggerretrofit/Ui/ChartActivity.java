package com.example.mvpdraggerretrofit.Ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.mvpdraggerretrofit.R;
import com.example.mvpdraggerretrofit.View.PieChartView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ChartActivity extends AppCompatActivity {
    @Bind(R.id.pieChart)
    PieChartView pieChartView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart);
        ButterKnife.bind(this);
        pieChartView.setColor(getResources().getColor(R.color.colorAccent));
    }
}
