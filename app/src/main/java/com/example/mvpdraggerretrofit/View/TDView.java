package com.example.mvpdraggerretrofit.View;

import android.content.Context;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by XmacZone on 16/10/9.
 */

public class TDView extends View {
    private Paint mPaint;
    private Camera mCamera;
    private Matrix mMatrix;
    private int mCenterX;
    private int mCenterY;
    private float limitRotate = 40;
    private float mCanvasRotateY = 0,mCanvasRotateX = 0;

    public TDView(Context context) {
        super(context);
        init();
    }

    public TDView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TDView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        mPaint = new Paint();
        mCamera = new Camera();
        mMatrix = new Matrix();

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();
        switch (event.getActionMasked()){
            case MotionEvent.ACTION_DOWN:
                rotateCanvasWhenMove(x,y);
                return true;
            case MotionEvent.ACTION_MOVE: {
                Log.e("xy", "x:" + x + "y:" + y);
                //将camera旋转的变量赋值
                rotateCanvasWhenMove(x,y);

                invalidate();
                return true;
            }
            case MotionEvent.ACTION_UP: {
                mCanvasRotateY = 0;
                mCanvasRotateX = 0;
                invalidate();
                return true;
            }
        }
        return true;
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
        Log.e("inva","onDraw");
        mCenterX = getWidth()/2;
        mCenterY = getHeight()/2;
        setmMatrix(canvas);
//        canvas.drawCircle(mCenterX,mCenterY,360,mPaint);
        canvas.save();
        for(int i = 0;i<120;i++){
            mPaint.setAlpha(255-(255*i/120));
            canvas.drawLine(mCenterX,150,mCenterX,170,mPaint);
            canvas.rotate(3,mCenterX,mCenterY);
        }
        canvas.restore();

    }

    private void setmMatrix(Canvas canvas){
        mMatrix.reset();
        mCamera.save();
        mCamera.rotateX(mCanvasRotateX);
        mCamera.rotateY(mCanvasRotateY);
        mCamera.getMatrix(mMatrix);
        mCamera.restore();
        mMatrix.preTranslate(-mCenterX,-mCenterY);
        mMatrix.postTranslate(mCenterX,mCenterY);
        canvas.concat(mMatrix);
    }

    private void rotateCanvasWhenMove(float x,float y){
        float dx = x - mCenterX;
        float dy = y - mCenterY;
        float percentX = dx/mCenterX;
        float percentY = dy/mCenterY;

        if(percentX>1f){
            percentX = 1f;
        }else if(percentX<-1f){
            percentX = -1f;
        }
        if(percentY>1f){
            percentY = 1f;
        }else if(percentY<-1f){
            percentY = -1f;
        }
        Log.e("percent","percentX="+percentX+"percentY="+percentY);
        mCanvasRotateY = limitRotate * percentX;
        mCanvasRotateX = limitRotate * percentY;
    }
}
