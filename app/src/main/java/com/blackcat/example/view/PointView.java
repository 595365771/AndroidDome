package com.blackcat.example.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;

import com.blackcat.example.R;

/**
 * Created by blackcat on 2019/3/25.10.06
 * 绘制点
 */
public class PointView extends android.support.v7.widget.AppCompatImageView {
   //创建一个画笔Paint开启防锯齿
   Paint paint =new Paint(Paint.ANTI_ALIAS_FLAG);

    public PointView(Context context) {
        super(context);
    }

    public PointView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PointView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //设置画笔的颜色
        paint.setColor(getResources().getColor(R.color.colorBlue));
        //设置空心圆
        paint.setStyle(Paint.Style.FILL);
        //设置画笔宽度（这里相当于点的大小）
        paint.setStrokeWidth(30);
        //设置点的形状Paint.Cap.ROUND圆形，SQUARE 或 BUTT是方的方形
        paint.setStrokeCap(Paint.Cap.ROUND);
        /**
         * 进行绘制，
         * x和y用来确定点中心的位置，方形和圆形都一样
         * paint 画笔
         */
        canvas.drawPoint(getWidth()/2,getHeight()/2,paint);

    }
}
