package com.blackcat.example.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;

import com.blackcat.example.R;

/**
 * Created by blackcat on 2019/3/25.10.06
 * 绘制矩形
 */
public class LinesView extends android.support.v7.widget.AppCompatImageView {


    //创建一个画笔Paint开启防锯齿 也可以用paint.setAntiAlias(true)开启防锯齿
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public LinesView(Context context) {
        super(context);
    }

    public LinesView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public LinesView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //4个点画一条线 (两条对角线的位置)
        float[] points = {0, 0, getWidth(), getHeight(), getWidth(), 0, 0, getHeight()};
        //设置画笔的颜色
        paint.setColor(getResources().getColor(R.color.colorBlue));
        //设置空心圆
        paint.setStyle(Paint.Style.FILL);
        //设置画笔宽度
        paint.setStrokeWidth(4);
        /**
         * 进行绘制
         * startX 和startY是点的起始位置
         * stopX 和stopY是点的结束位置
         * paint 画笔
         */
        canvas.drawLine(0, 0, getWidth(), getHeight(), paint);
        canvas.drawLine(getWidth(), 0, 0, getHeight(), paint);
        canvas.drawLines(points, paint);

    }
}
