package com.blackcat.example.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;

import com.blackcat.example.R;

/**
 * Created by blackcat on 2019/3/25.10.06
 * 绘制圆
 */
public class ArcView extends android.support.v7.widget.AppCompatImageView {
   //创建一个画笔Paint开启防锯齿
   Paint paint =new Paint(Paint.ANTI_ALIAS_FLAG);

    public ArcView(Context context) {
        super(context);
    }

    public ArcView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ArcView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //设置画笔的颜色
        paint.setColor(getResources().getColor(R.color.colorBlue));
        //设置空心圆
        paint.setStyle(Paint.Style.FILL);
        //设置画笔宽度
        paint.setStrokeWidth(4);
        /**
         * drawArc() 是使用一个椭圆来描述弧形的。
         * left, top, right, bottom 描述的是这个弧形所在的椭圆；
         * startAngle 是弧形的起始角度（x 轴的正向，即正右的方向，是 0 度的位置；顺时针为正角度，逆时针为负角度；
         * sweepAngle 是弧形划过的角度；
         * useCenter 表示是否连接到圆心，如果不连接到圆心，就是弧形，如果连接到圆心，就是扇形。
         * paint 画笔
         */
        canvas.drawArc(0,0,getWidth(),getHeight(),90,90,false,paint);
        canvas.drawArc(0,0,getWidth(),getHeight(),180,90,false,paint);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawArc(0,0,getWidth(),getHeight(),270,90,false,paint);
        canvas.drawArc(0,0,getWidth(),getHeight(),360,90,true,paint);

    }
}
