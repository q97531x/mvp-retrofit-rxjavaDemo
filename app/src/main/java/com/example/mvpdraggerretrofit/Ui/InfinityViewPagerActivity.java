package com.example.mvpdraggerretrofit.Ui;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mvpdraggerretrofit.R;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class InfinityViewPagerActivity extends AppCompatActivity {
    @Bind(R.id.viewPager)
    ViewPager viewPager;
    ArrayList<String> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infinity_view_pager);
        ButterKnife.bind(this);
        for(int i = 0;i<5;i++){
            list.add(i+"");
        }
        list.add(0,"4");
        list.add(list.size(),"0");
        viewPager.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return list.size()+2;
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                TextView tv = new TextView(InfinityViewPagerActivity.this);
                tv.setText(list.get(position));
                tv.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                ViewGroup.LayoutParams lp = tv.getLayoutParams();

                lp = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
//            tv.setLayoutParams(lp);
                container.addView(tv,lp);
                return tv;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView((TextView)object);
            }
        });
        viewPager.setCurrentItem(1,false);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                Log.e("position",position+"");
                if(position == 0){
                    viewPager.setCurrentItem(5,false);
                }else if(position == 6){
                    viewPager.setCurrentItem(1,false);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }


}
