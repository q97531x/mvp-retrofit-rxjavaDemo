package com.example.mvpdraggerretrofit.View;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;


/**
 * Created by XmacZone on 16/9/29.
 */

public class PullAndLoadListView extends RecyclerView {
    public PullAndLoadListView(Context context) {
        super(context);
    }

    public PullAndLoadListView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public PullAndLoadListView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }
}
