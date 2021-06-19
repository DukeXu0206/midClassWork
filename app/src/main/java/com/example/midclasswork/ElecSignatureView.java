package com.example.midclasswork;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;



public class ElecSignatureView extends View {
    private int widthSize;//画板的宽
    private int heightSize;
    private Bitmap bitmap;//整个画板显示的位图
    private Paint paint = new Paint();//画板的画笔
    private Canvas canvas = new Canvas();//画板的画布
    private float xTouch = 0;//移动的位置
    private float yTouch = 0;

    public ElecSignatureView(Context context) {
        super(context);
        initData();
    }

    public ElecSignatureView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initData();
    }

    public ElecSignatureView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initData();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public ElecSignatureView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initData();
    }

    private void initData() {
        setClickable(true);//设置为可点击才能获取到MotionEvent.ACTION_MOVE
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(7);
        //设置是否使用抗锯齿功能，抗锯齿功能会消耗较大资源，绘制图形的速度会减慢
        paint.setAntiAlias(true);
        //设置是否使用图像抖动处理，会使图像颜色更加平滑饱满，更加清晰
        paint.setDither(true);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        Log.d("ElecSignatureView", "onMeasure widthMeasureSpec=" + widthMeasureSpec + "  heightMeasureSpec=" + heightMeasureSpec);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        heightSize = MeasureSpec.getSize(heightMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        Log.d("ElecSignatureView", "onMeasure widthSize=" + widthSize + "  heightSize=" + heightSize);
        initBitmap();
    }

    private void initBitmap(){
        if (null != bitmap){
            bitmap.recycle();
        }
        bitmap = Bitmap.createBitmap(widthSize, heightSize, Bitmap.Config.ARGB_8888);
        Paint paint = new Paint();
        paint.setColor(Color.rgb(220, 220, 220));
        canvas.setBitmap(bitmap);
        canvas.drawRect(0, 0, bitmap.getWidth(), bitmap.getHeight(), paint);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Log.d("ElecSignatureView", "onDraw");
        super.onDraw(canvas);
        canvas.drawBitmap(bitmap, 0, 0, paint);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d("ElecSignatureView", "onTouchEvent event=" + event);
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                xTouch = event.getX();
                yTouch = event.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                canvas.drawLine(xTouch, yTouch, event.getX(), event.getY(), paint);
                xTouch = event.getX();
                yTouch = event.getY();
                invalidate();
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        return super.onTouchEvent(event);
    }

    /**
     * 获取画好的电子签名
     * @return
     */
    public Bitmap getBitmap() {
        return bitmap;
    }

    /**
     * 清除电子签名
     */
    public void clear(){
        initBitmap();
        invalidate();
    }
}
