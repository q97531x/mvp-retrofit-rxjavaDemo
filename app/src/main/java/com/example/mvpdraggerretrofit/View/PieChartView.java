package com.example.mvpdraggerretrofit.View;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import com.example.mvpdraggerretrofit.R;

/**
 * Created by XmacZone on 16/9/29.
 */

public class PieChartView extends View{
    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private int color = getResources().getColor(R.color.colorPrimary);
    private int diameter;
    private float startAngle = 0;
    public PieChartView(Context context) {
        super(context);
        init();
    }

    public PieChartView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public PieChartView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        mPaint.setColor(color);
        invalidate();
    }

    public void setColor(int color){
        this.color = color;
//        init();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if(getWidth()>getHeight()){
            diameter = getHeight();
        }else {
            diameter = getWidth();
        }
        RectF rectF = new RectF(0,0,diameter,diameter);
        canvas.drawArc(rectF,startAngle,30,true,mPaint);
        mPaint.setColor(getResources().getColor((R.color.colorPrimaryDark)));
        canvas.drawArc(rectF,startAngle+30,100,true,mPaint);
    }
}
