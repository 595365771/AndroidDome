package com.blackcat.example.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;

import com.blackcat.example.R;

/**
 * Created by blackcat on 2019/3/25.10.06
 * 绘制圆
 */
public class CircleView extends android.support.v7.widget.AppCompatImageView {
   //创建一个画笔Paint开启防锯齿
   Paint paint =new Paint(Paint.ANTI_ALIAS_FLAG);

    public CircleView(Context context) {
        super(context);
    }

    public CircleView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CircleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //设置画笔的颜色
        paint.setColor(getResources().getColor(R.color.colorBlue));
        //设置空心圆
        paint.setStyle(Paint.Style.STROKE);
        //设置画笔宽度
        paint.setStrokeWidth(4);
        /**
         * 进行绘制，cx和cy用来确定圆心的位置，坐标系是View自己的坐标
         * radius 是圆的半径
         * paint 画笔
         */
        canvas.drawCircle(getWidth()/2,getHeight()/2,getWidth()/2-10,paint);

    }
}
