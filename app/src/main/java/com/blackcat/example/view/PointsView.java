package com.blackcat.example.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;

import com.blackcat.example.R;

/**
 * Created by blackcat on 2019/3/25.10.06
 * 绘制一堆点
 */
public class PointsView extends android.support.v7.widget.AppCompatImageView {
    //点的坐标
    float[] points = {0, 0, 50, 50, 50, 100, 100, 50, 100, 100, 150, 50, 150, 100};
    //创建一个画笔Paint开启防锯齿
   Paint paint =new Paint(Paint.ANTI_ALIAS_FLAG);

    public PointsView(Context context) {
        super(context);
    }

    public PointsView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PointsView(Context context, AttributeSet attrs, int defStyleAttr) {
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
        paint.setStrokeCap(Paint.Cap.SQUARE);
        /**
         * 进行绘制，
         * points 存放点的x和y位置
         * offset 偏移points数组里的两个数，或者说跳过points数组里的两个数
         * count  绘制points数组里8个值
         * offset=2和count=8相当于从0开始取points数组下标2到9的8个点进行绘制
         * 也就是绘制（50，50）（50，100）（100，50）（100，100）4个点
         * paint 画笔
         */
        canvas.drawPoints(points,2,8,paint);

    }
}
